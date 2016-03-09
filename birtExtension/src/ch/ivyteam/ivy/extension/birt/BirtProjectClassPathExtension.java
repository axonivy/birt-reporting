package ch.ivyteam.ivy.extension.birt;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.JavaCore;

import ch.ivyteam.ivy.java.IIvyProjectClassPathExtension;

/**
 * Adds the classes of this plugin to the compile and runtime class path
 * @author rwei
 * @since 15.09.2008
 */
public class BirtProjectClassPathExtension implements IIvyProjectClassPathExtension
{

  public List<String> getClassLoaderContributingBundles()
  {
    return Arrays.asList(new String[] {"ch.ivyteam.ivy.extension.birt"});
  }

  public List<String> getCompileClassPathContributingBundles()
  {
    return Arrays.asList(new String[] {"ch.ivyteam.ivy.extension.birt"});
  }

  /**
   * @see ch.ivyteam.ivy.java.IIvyProjectClassPathExtension#getCompileClassPathAccessRules(java.lang.String)
   */
  public List<IAccessRule> getCompileClassPathAccessRules(String bundleIdentifier)
  {
    return Arrays.asList(new IAccessRule[] {
        JavaCore.newAccessRule(new Path("ch.ivyteam.ivy.extension.birt/*"), IAccessRule.K_ACCESSIBLE),
        EXCLUDE_ALL_OTHER_RULE
    });
  }

  /**
   * @see ch.ivyteam.ivy.java.IIvyProjectClassPathExtension#getCompileClassPath(java.lang.String)
   */
  public List<String> getCompileClassPath(String bundleIdentifier)
  {
    return null;
  }

}
