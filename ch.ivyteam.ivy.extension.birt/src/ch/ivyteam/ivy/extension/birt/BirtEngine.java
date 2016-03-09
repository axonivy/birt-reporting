package ch.ivyteam.ivy.extension.birt;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.core.runtime.IProgressMonitor;

import ch.ivyteam.di.restricted.DiCore;
import ch.ivyteam.ivy.Advisor;
import ch.ivyteam.ivy.reporting.restricted.IBirtRuntimeManager;
import ch.ivyteam.ivy.server.IServerExtension;

/**
 * Xpert.ivy BIRT Server Extension for the BIRT engine
 * 
 * @author mde
 * @since 19.08.2008
 */
public class BirtEngine implements IServerExtension
{
  public static final String EXTENSION_ID = "ch.ivyteam.ivy.extension.birt.BirtEngine";
  private IReportEngine reportEngine;
  /* Report engine for report design. Is used to create dynamic reports */
  @SuppressWarnings("unused")
  private IDesignEngine designEngine;
  private IvyBirtReportService reportService;
  private Logger log = Logger.getLogger("ch.ivyteam.ivy.extension.birt.BirtEngine");

  /**
   * @see ch.ivyteam.ivy.server.IServerExtension#getIdentifier()
   */
  public String getIdentifier()
  {
    return EXTENSION_ID;
  }

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#getName()
   */
  public String getName()
  {
    return "BirtEngine";
  }

  public IReportEngine getReportEngine()
  {
    return reportEngine;
  }

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#start(org.eclipse.core.runtime.IProgressMonitor)
   */
  public void start(IProgressMonitor monitor) throws Exception
  {
    // Save security manager and set it to null, on order to have no permission
    // exceptions when loading BIRT
    SecurityManager ivySecurityManager = System.getSecurityManager();
    System.setSecurityManager(null);
    startReportEngine();
    startDesignEngine();
    initializeReportService();
    // Set Ivy Security Manager back
    System.setSecurityManager(ivySecurityManager);
  }

  private void startReportEngine() throws Exception
  {
    if (Advisor.getAdvisor().isDesigner())
    {
      reportEngine = DiCore.getGlobalInjector().getInstance(IBirtRuntimeManager.class)
              .getBirtEngine(IReportEngine.class, this);
    }
    else
    {
      reportEngine = IvyBirtUtils.getReportEngineInstance();
    }
  }

  private void startDesignEngine() throws Exception
  {
    if (Advisor.getAdvisor().isDesigner())
    {
      designEngine = DiCore.getGlobalInjector().getInstance(IBirtRuntimeManager.class)
              .getBirtEngine(IDesignEngine.class, this);
    }
    else
    {
      designEngine = IvyBirtUtils.getDesignEngineInstance();
    }
  }

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#stop(org.eclipse.core.runtime.IProgressMonitor)
   */
  public void stop(IProgressMonitor monitor) throws Exception
  {
    reportEngine.destroy();
    Platform.shutdown();
    reportEngine = null;
    designEngine = null;
  }

  public IvyBirtReportService getReportService()
  {
    return reportService;
  }

  private void initializeReportService() throws Exception
  {
    String repository = IvyBirtUtils.getDesignRepository();
    if (StringUtils.isNotBlank(repository))
    {
      log.info("Report Design Repository is provided at: " + repository);
      reportService = new IvyBirtReportService(reportEngine, repository);
    }
    else
    {
      log.warn("No Report Design Repository is provided");
      reportService = new IvyBirtReportService(reportEngine);
    }
  }

}
