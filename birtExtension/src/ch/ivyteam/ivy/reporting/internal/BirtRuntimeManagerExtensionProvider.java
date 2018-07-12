package ch.ivyteam.ivy.reporting.internal;

import javax.inject.Singleton;

import org.eclipse.core.runtime.Platform;

import ch.ivyteam.ivy.manager.restricted.AbstractManagerProvider;
import ch.ivyteam.ivy.reporting.restricted.IExtensionBirtRuntimeManager;

/**
 * The factory for creation and access of a BirtRuntime manager
 * 
 * @author jst
 * @since 16.07.2009
 */
@Singleton
public class BirtRuntimeManagerExtensionProvider extends AbstractManagerProvider<IExtensionBirtRuntimeManager>
{
  @Override
  public Class<? extends IExtensionBirtRuntimeManager> getImplementedBy()
  {
    if (Platform.isRunning() && birtClassesAreAccessible())
    {
      return BirtRuntimeManagerExtensionOsgi.class;
    }
    else
    {
      return BirtRuntimeManagerDisabled.class;
    }
  }
  
  public static boolean birtClassesAreAccessible()
  {
    try
    {
      BirtRuntimeManagerExtensionProvider.class.getClassLoader().loadClass("org.eclipse.birt.report.engine.api.EngineConfig");
      return true;
    }
    catch (ClassNotFoundException ex)
    {
      return false;
    }
  }
}
