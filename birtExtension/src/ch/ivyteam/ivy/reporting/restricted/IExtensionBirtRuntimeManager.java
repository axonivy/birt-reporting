package ch.ivyteam.ivy.reporting.restricted;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.model.api.IDesignEngine;
import org.eclipse.core.runtime.IProgressMonitor;

import ch.ivyteam.ivy.manager.IManager;
import ch.ivyteam.ivy.reporting.internal.BirtRuntimeManagerExtensionProvider;

import com.google.inject.ProvidedBy;

/**
 * The Interface for the BirtRuntimeManager. A BirtRuntimeManager is responsible for starting and stopping the
 * Birt engine. It provides the Birt Reporting- and Designer-Engine which allow the creation of Birt Reports.
 * @author jst
 * @since 13.08.2009
 */
@ProvidedBy(BirtRuntimeManagerExtensionProvider.class)
public interface IExtensionBirtRuntimeManager extends IManager
{
  /** key for the system property for the birt home directory, that's where the birt engine is. */
  public final static String KEY_PROPERTY_BIRT_HOME_DIR = "Birt.HomeDirectory";

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#getName()
   */
  @Override
  public abstract String getName();

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#start(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public abstract void start(IProgressMonitor monitor);

  /**
   * @see ch.ivyteam.ivy.lifecycle.ILifecycle#stop(org.eclipse.core.runtime.IProgressMonitor)
   */
  @Override
  public abstract void stop(IProgressMonitor monitor);

  /**
   * Given a report design, this method will return a list of Themes which are available to this report
   * design.
   * 
   * @param designPath The path to the *.rptdesign
   * @return The available themes for this report design. Never null.
   * @throws ReportingException
   */
  public abstract List<String> getAvailableThemes(String designPath) throws ReportingException;
  
  /**
   * Returns the birt engine of the given class.  
   * The report engine will be configured with the class loader that was used
   * to instantiate the given object. Typically you should provide 'this' as a parameter from wherever
   * @param birtEngineClass either {@link IReportEngine} or {@link IDesignEngine}
   * @param someContextObject will cat as class loader provider
   * @return birt engine
   */
  public <T> T getBirtEngine(Class<T> birtEngineClass, Object someContextObject);

  /**
   * Create a simple report using the BirtRuntime. For a more advanced report please have a look at
   * ReportingManager.
   * 
   * @param designPath path to the *.rptdesign file to use as basis for report
   * @param formats the formats to output, e.g. "pdf", "html", "doc"
   * @param outputDir the directory where the reports should be generated
   * @param reportName the base name of the report to be created, e.g. "myReport", 
   *                    this will result in 'reportDir/myReport.html', 'reportDir/myReport.doc', 
   *                    'reportDir/myReport.pdf'; according to provided formats
   * @param parameterMap any additional parameters for the report (null permitted) 
   */
  public void createSimpleReport(String designPath, List<String> formats, File outputDir, String reportName, Map<String,Object> parameterMap);

  /**
   * Return all parameters for a report design.
   * @param designPath The path to the report design file (*.rptdesign).
   * @return A list of parameter names.
   * @throws ReportingException
   */
  public List<String> getDesignParameters(String designPath) throws ReportingException;
  
  /**
   * @return Is the birtRuntime already started.
   */
  public boolean isStarted();

}