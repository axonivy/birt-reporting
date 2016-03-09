package ch.ivyteam.ivy.extension.birt;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;

import ch.ivyteam.db.jdbc.DatabaseConnectionConfiguration;
import ch.ivyteam.ivy.application.IExternalDatabaseConfiguration;
import ch.ivyteam.ivy.environment.Ivy;

/**
 * Important Utility services for BIRT
 * @author mde
 */
public class IvyBirtUtils
{
  /* Extension properties. File located in configuration/extensions/birt.properties */
  private static Properties birtProperties;
  /* Default location for the properties file */
  private static String propertiesFileLocation = "configuration/extensions/birt.properties";
  /* Logger for the Extension */
  private static Logger log = Logger.getLogger("ch.ivyteam.ivy.extension.birt.BirtEngine");

  /* Path to the report engine runtime */
  public static final String ENGINE_HOME = "engineHome";
  /* Path to the report design repository, that contains the design files */
  public static final String DESING_REPOSITORY = "designRepository";
  
  /**
   * Load BIRT properties file for Ivy Extension
   * @return properties
   * @throws Exception 
   */
  private static Properties getBirtProperties() throws Exception
  {
    if (birtProperties == null)
    {
      birtProperties = new Properties();
      birtProperties.load(new FileInputStream(new java.io.File(propertiesFileLocation)));
    }
    return birtProperties;
  }

  /**
   * Load the engine home property
   * @return path to the report engine home defined in the properties file
   * @throws Exception if no engine home property is set
   */
  public static String getEngineHome() throws Exception
  {
    String engineHome = getBirtProperties().getProperty(ENGINE_HOME);
    if (engineHome != null)
    {
      log.info("Birt Engine Home is located on: " + engineHome);
      return engineHome;
    }
    else
    {
      throw new Exception("The birt.properties File must provide a property engineHome that contains the full path to the Report Engine");
    }
  }
  
  public static String getDesignRepository() throws Exception
  {
    return getBirtProperties().getProperty(DESING_REPOSITORY);
  }

  /**
   * @param databaseName
   * @return map of connection properties for the given data source
   * @throws Exception
   */
  public static Map<String, String> getDatabaseConnectionPropertiesMap(final String databaseName)
          throws Exception
  {
    // get a connection url from the environment
    return Ivy.session().getSecurityContext().executeAsSystemUser(new Callable<Map<String, String>>()
              {
                public Map<String, String> call() throws Exception
                {
                  Map<String, String> jdbcMap = new HashMap<String, String>();
                  IExternalDatabaseConfiguration db = Ivy.wf().getApplication().findExternalDatabaseConfiguration(databaseName);
                  if (db != null)
                  {
                    DatabaseConnectionConfiguration externalDbConfig = db.getDatabaseConnectionConfiguration();
                    jdbcMap.put("jdbcDriverClass", externalDbConfig.getDriverName());
                    jdbcMap.put("jdbcDriverUrl", externalDbConfig.getConnectionUrl());
                    jdbcMap.put("jdbcUsername", externalDbConfig.getUserName());
                    jdbcMap.put("jdbcPassword", externalDbConfig.getPassword());
                  }
                  return jdbcMap;
                }
              });
  }

  /**
   * @return report Engine instance
   */
  public static IReportEngine getReportEngineInstance()
  {
    try
    {
      EngineConfig engineConfig = new EngineConfig();
      engineConfig.setEngineHome(getEngineHome());
      Platform.startup(engineConfig);
      IReportEngineFactory factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
      return factory.createReportEngine(engineConfig);
    }
    catch (Exception e)
    {
      log.error(e);
      return null;
    }
  }

  /**
   * @return design Engine instance
   */
  public static IDesignEngine getDesignEngineInstance()
  {
    try
    {
      DesignConfig designConfig = new DesignConfig();
      designConfig.setBIRTHome(getEngineHome());
      IDesignEngineFactory factory = (IDesignEngineFactory) Platform.createFactoryObject(IDesignEngineFactory.EXTENSION_DESIGN_ENGINE_FACTORY);
      return factory.createDesignEngine(designConfig);
    }
    catch (Exception e)
    {
      log.error(e);
      return null;
    }
  }
}
