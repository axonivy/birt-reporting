package ch.ivyteam.ivy.reporting.internal;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;

import javax.inject.Singleton;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineConstants;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.eclipse.birt.report.model.api.DesignConfig;
import org.eclipse.birt.report.model.api.DesignFileException;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.birt.report.model.api.IDesignEngineFactory;
import org.eclipse.birt.report.model.api.LibraryHandle;
import org.eclipse.birt.report.model.api.ParameterHandle;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.SessionHandle;
import org.eclipse.birt.report.model.api.ThemeHandle;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;

import ch.ivyteam.ivy.java.IJavaConfigurationManager;
import ch.ivyteam.ivy.lifecycle.IAsyncStarting;
import ch.ivyteam.ivy.lifecycle.ILifecycle;
import ch.ivyteam.ivy.manager.restricted.AbstractManager;
import ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager;
import ch.ivyteam.ivy.reporting.restricted.ReportingException;
import ch.ivyteam.log.Logger;

/**
 * The BirtRuntimeManager is responsible for starting and stopping the Birt
 * engines. It provides access to singleton instancees of the Birt Reporting-
 * and Design-Engines which allow the creation of Birt Reports.
 * @author jst, kvg
 */
@Singleton
public class BirtRuntimeManagerExtensionOsgi extends AbstractManager implements IExtensionBirtRuntimeManager, IAsyncStarting
{
  private static final Logger LOGGER = Logger.getClassLogger(BirtRuntimeManagerExtensionOsgi.class);

  /** The Birt report engine is used to generate a report. */
  private IReportEngine fReportEngine;

  /** The Birt design engine is used to read and manipulate report designs. */
  private IDesignEngine fDesignEngine;

  @Override
  public String getName()
  {
    return "Birt Extension Runtime Manager [OSGI]";
  }

  @Override
  public Class<? extends ILifecycle> dependsOn()
  {
    return IJavaConfigurationManager.class;
  }
  
  @Override
  public void doStart(SubMonitor monitor)
  {
    createAndStartBirtEngines(monitor);
  }

  @Override
  public void doStop(SubMonitor monitor)
  {
    shutdownEngines(monitor);
  }
  
  /**
   * Start the Birt Report and Design Engine. This is an expensive operation.
   * @param monitor 
   */
  @SuppressWarnings("unchecked")
  private void createAndStartBirtEngines(IProgressMonitor monitor)
  {
    monitor.beginTask("Creating BIRT engines...", 2);
    try
    {
      java.util.logging.Logger birtLogger = LogManager.getLogManager().getLogger("");

      // create report engine
      final EngineConfig engineConfig = new EngineConfig();
      engineConfig.setLogger(birtLogger);
      engineConfig.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.getClass().getClassLoader());
      
      IReportEngineFactory reportEngineFactory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
      if (reportEngineFactory == null)
      {
        LOGGER.warn("Could not create BIRT report engine factory: report engine will not be available.");
        return;
      }
      fReportEngine = reportEngineFactory.createReportEngine(engineConfig);
      fReportEngine.setLogger(birtLogger);
      monitor.worked(1);

      // create design engine
      final DesignConfig designConfig = new DesignConfig();
      IDesignEngineFactory designEngineFactory = (IDesignEngineFactory) Platform.createFactoryObject(IDesignEngineFactory.EXTENSION_DESIGN_ENGINE_FACTORY);
      if (designEngineFactory == null)
      {
        LOGGER.warn("Could not create BIRT design engine factory: design engine will not be available.");
        return;
      }
      fDesignEngine = designEngineFactory.createDesignEngine(designConfig);
      monitor.worked(1);

      LOGGER.debug("BIRT engines successfully created.");
    }
    finally
    {
      monitor.done();
    }
  }

  /**
   * Destroys the report and design engine.
   * @param monitor 
   */
  private void shutdownEngines(IProgressMonitor monitor)
  {
    monitor.beginTask("Shutting down BIRT engines...", 1);
    try
    {
      if (fReportEngine != null)
      {
        fReportEngine.destroy();
        fReportEngine = null;
      }
      fDesignEngine = null;
    }
    finally
    {
      monitor.done();
    }
  }

  /**
   * @see ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager#getAvailableThemes(java.lang.String)
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<String> getAvailableThemes(String designPath) throws ReportingException
  {
    List<String> themes = new LinkedList<String>();
    try
    {
      SessionHandle session = fDesignEngine.newSessionHandle(null);

      ReportDesignHandle design = session.openDesign(designPath);
      List<LibraryHandle> libraries = design.getLibraries();
      for (LibraryHandle library : libraries)
      {
        for (int i = 0; i < library.getThemes().getCount(); i++)
        {
          ThemeHandle theme = (ThemeHandle) library.getThemes().get(i);
          String themeName = library.getNamespace() + "." + theme.getName();
          themes.add(themeName);
        }
      }
      return themes;
    }
    catch (DesignFileException ex)
    {
      throw new ReportingException("Could not open design file: " + designPath, ex);
    }
  }

  /**
   * @see ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager#getDesignParameters(java.lang.String)
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<String> getDesignParameters(String designPath) throws ReportingException
  {
    List<String> parameters = new LinkedList<String>();
    try
    {
      SessionHandle session = fDesignEngine.newSessionHandle(null);
      ReportDesignHandle design = session.openDesign(designPath);

      List<ParameterHandle> parameterList = design.getAllParameters();
      for (ParameterHandle parameter : parameterList)
      {
        parameters.add(parameter.getName());
      }

      return parameters;
    }
    catch (DesignFileException ex)
    {
      throw new ReportingException("Could not open design file: " + designPath, ex);
    }
  }

  @SuppressWarnings("unchecked")
  private IReportEngine getReportEngine(Object contextProviderObject)
  {
    if (contextProviderObject == null)
    {
      throw new IllegalArgumentException("Must provide a non-null context object to provide access to class loader");
    }
    if (fReportEngine != null)
    {
      // In order for data sets in the report to call java event handler classes, 
      // the reportEngine has to know the classLoader in order to load those classes.
      HashMap<String, Object> context = fReportEngine.getConfig().getAppContext();
      context.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, contextProviderObject.getClass().getClassLoader());
      return fReportEngine;
    }
    return null;
  }

  private IDesignEngine getDesignEngine()
  {
    return fDesignEngine;
  }

  /**
   * @see ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager#createSimpleReport(String, List, File, String, Map)
   */
  @Override
  public void createSimpleReport(
          String reportDesign, 
          List<String> formats, 
          File outputDir,
          String reportName,
          Map<String, Object> parameterMap)
  {
    File reportFile = null;
    File htmlReportImagesDir = null;
    
    try
    {
      // Open the report design
      IReportRunnable design = fReportEngine.openReportDesign(reportDesign);

      // Create task to run and render the report
      IRunAndRenderTask task = fReportEngine.createRunAndRenderTask(design);
      if (parameterMap != null && !parameterMap.isEmpty())
      {
        setReportParameters(task, parameterMap);
      }

      for (String format : formats)
      {
        RenderOption options = new RenderOption();
        reportFile = new File(outputDir, reportName + "." + format);
        options.setOutputFileName(reportFile.getAbsolutePath());
        options.setOutputFormat(format);

        // set format specific options
        if ("html".equalsIgnoreCase(format))
        {
          HTMLRenderOption htmlOptions = new HTMLRenderOption(options);
          htmlReportImagesDir = new File(outputDir, reportName + "_Images");
          htmlOptions.setImageDirectory(htmlReportImagesDir.getAbsolutePath());
        }
        task.setRenderOption(options);

        // run and render report
        task.run();
      }
      task.close();
    }
    catch (EngineException ex)
    {
      LOGGER.warn("Could not create report ''{0}'' from report design ''{1}''.", ex, reportFile, reportDesign);
    }
  }

  /**
   * @see ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager#isStarted()
   */
  @Override
  public boolean isStarted()
  {
    return (fReportEngine != null && fDesignEngine != null);
  }

  /**
   * Sets the report parameters.
   * @param task The run and render task.
   * @param parameterMap The Map with paramerter name, parameter value
   */
  private void setReportParameters(IRunAndRenderTask task, Map<String, Object> parameterMap)
  {
    for (Map.Entry<String, Object> parameter : parameterMap.entrySet())
    {
      task.setParameterValue(parameter.getKey(), parameter.getValue());
    }
    
    // Check that the parameters are valid
    if (! task.validateParameters())
    {
      LOGGER.warn("Report parameters are not valid: "+parameterMap);
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getBirtEngine(Class<T> birtEngineClass, Object someContextObject)
  {
    if (birtEngineClass == IReportEngine.class)
    {
      return (T)getReportEngine(someContextObject);
    }
    else if (birtEngineClass == IDesignEngine.class)
    {
      return (T)getDesignEngine();
    }
    throw new IllegalArgumentException("Unknown birt engine class "+birtEngineClass);
  }
}