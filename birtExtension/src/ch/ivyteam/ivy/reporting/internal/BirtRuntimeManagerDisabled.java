package ch.ivyteam.ivy.reporting.internal;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.eclipse.core.runtime.SubMonitor;

import ch.ivyteam.ivy.manager.restricted.AbstractManager;
import ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager;
import ch.ivyteam.ivy.reporting.restricted.ReportingException;
import ch.ivyteam.log.Logger;

/**
 * Birt runtime manager for external Birt engine. This implementation should
 * be used on the Server where OSGI is not (yet) supported. See {@link BirtRuntimeManagerExtensionOsgi} 
 * for the Designer implementation.
 * @author kvg
 * @since 03.05.2010
 */
@Singleton
public class BirtRuntimeManagerDisabled extends AbstractManager implements IExtensionBirtRuntimeManager
{
  private static final Logger LOGGER = Logger.getClassLogger(BirtRuntimeManagerDisabled.class);
  
  @Override
  public void createSimpleReport(String designPath, List<String> formats, File reportPath, String reportName, Map<String, Object> parameterMap)
  {
    LOGGER.info("Creating of simple reports on the server is not yet supported: "+reportPath+"/"+reportName+" [report generation skipped]");
  }

  @Override
  public List<String> getAvailableThemes(String designPath) throws ReportingException
  {
    return Collections.emptyList();
  }
  
  @Override
  public List<String> getDesignParameters(String designPath) throws ReportingException
  {
    return Collections.emptyList();
  }

  @Override
  public String getName()
  {
    return "Birt Extension Runtime Manager [Disabled]"; //[Standalone BIRT engine]";
  }

  @Override
  public boolean isStarted()
  {
    return false;
  }

  @Override
  public void doStart(SubMonitor monitor)
  {
  }

  @Override
  public <T> T getBirtEngine(Class<T> birtEngineClass, Object someContextObject)
  {
    throw new IllegalStateException("Not implemented");
  }
}
