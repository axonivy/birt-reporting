package ch.ivyteam.ivy.extension.birt.rendering.ivy;

import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IImage;

import ch.ivyteam.ivy.environment.EnvironmentNotAvailableException;
import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.persistence.PersistencyException;

/**
 * TemporaryHTMLServerImageHandler that adds the session id to images urls in
 * order to display the Report in an report viewer
 * @author mde
 */
public class TemporaryHTMLServerImageHandler extends HTMLServerImageHandler
{
  private String sessionId = "";

  public TemporaryHTMLServerImageHandler()
  {
    try
    {
      sessionId = Ivy.session().getHttpSessionIdentifier();
    }
    catch (EnvironmentNotAvailableException e)
    {
      e.printStackTrace();
    }
    catch (PersistencyException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  protected String handleImage(IImage image, Object context, String prefix, boolean needMap)
  {
    String src = super.handleImage(image, context, prefix, needMap);
    return src += ";jsessionid=" + sessionId;
  }

}
