package ch.ivyteam.ivy.extension.birt.rendering.ivy;

import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.RenderOption;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.scripting.objects.File;

/**
 * HTML Render options for Ivy. Some attributes must be specified for Ivy, in
 * order to display HTML reports correctly
 * @author mde
 */
public class IvyHtmlRenderOptions extends HTMLRenderOption
{
  public IvyHtmlRenderOptions(File outputFile, RenderOption option)
  {
    super(option);
    setImageDirectory(outputFile.getJavaFile().getParentFile().getAbsolutePath());
    String url = Ivy.html().fileref(outputFile);
    url = url.substring(0, url.lastIndexOf("/") + 1);
    Ivy.log().info(url);
    setBaseImageURL(url);

    if (outputFile.isTemporary())
    {
      setImageHandler(new TemporaryHTMLServerImageHandler());
    }
    else
    {
      setImageHandler(new HTMLServerImageHandler());
    }
  }
}
