package ch.ivyteam.ivy.extension.birt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
  private static final Logger LOGGER = Logger.getLogger(BirtEngine.class);
  private static final String PROPERTIES_FILE_LOCATION = "configuration/extensions/birt.properties";
  private static final String BIRT_ENGINE_HOME = "engineHome";
  private static final String DESING_REPOSITORY = "designRepository";

  private static final Properties birtProperties = new Properties();

  static
  {
    File birtPropsFile = new File(PROPERTIES_FILE_LOCATION);
    if (birtPropsFile.exists())
    {
      try (InputStream is = new FileInputStream(birtPropsFile))
      {
        birtProperties.load(is);
      }
      catch (IOException ex)
      {
        LOGGER.error("could not load " + PROPERTIES_FILE_LOCATION, ex);
      }
    }
  }
  
  private IvyBirtUtils()
  {
  }
  
  /**
   * Load the engine home property
   * @return path to the report engine home defined in the properties file
   */
  public static String getEngineHome()
  {
    String engineHome = birtProperties.getProperty(BIRT_ENGINE_HOME, "lib/birtRuntime");
    LOGGER.info("Birt Engine Home is located on: " + engineHome);
    return engineHome;
  }
  
  public static String getDesignRepository()
  {
    return birtProperties.getProperty(DESING_REPOSITORY);
  }

  public static Map<String, String> getDatabaseConnectionPropertiesMap(final String databaseName) throws Exception
  {
    // get a connection url from the environment
    return Ivy.session().getSecurityContext().executeAsSystemUser(() -> {
      Map<String, String> jdbcMap = new HashMap<>();
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
    });
  }

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
      LOGGER.error("Creation of report engine failed", e);
      return null;
    }
  }

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
      LOGGER.error("Creation of design engine failed", e);
      return null;
    }
  }
}
