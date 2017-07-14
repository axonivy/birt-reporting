package ch.ivyteam.ivy.extension.birt.dynreport;

import java.util.Locale;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.eclipse.birt.report.model.api.ElementFactory;
import org.eclipse.birt.report.model.api.ReportDesignHandle;
import org.eclipse.birt.report.model.api.SessionHandle;
import org.eclipse.birt.report.model.api.StructureFactory;
import org.eclipse.birt.report.model.api.elements.structures.EmbeddedImage;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.extension.birt.IvyBirtUtils;
import ch.ivyteam.ivy.security.SecurityManagerFactory;

import com.ibm.icu.util.ULocale;

/**
 * Abstract implementation for a dynamic report. Any dynamic report must be
 * implementation for the class
 * @author mde
 * @since 03.03.2011
 */
public abstract class AbstractDynamicReport implements IDynamicReport
{
  /* The dynamic report design */
  private ReportDesignHandle designHandle = null;
  /* Element factoroy for the report design */
  private ElementFactory designFactory;
  /* Logger for the Extension */
  private static Logger log = Logger.getLogger("ch.ivyteam.ivy.extension.birt.BirtEngine");

  public AbstractDynamicReport()
  {
    createEmptyReportDesign();
  }

  /**
   * @return the dynamic report design
   */
  public ReportDesignHandle getReportDesign()
  {
    if (designHandle == null)
    {
      createEmptyReportDesign();
    }
    return designHandle;
  }

  /**
   * save the dynamic report design temporary
   */
  public void save()
  {
    try
    {
      designHandle.close();
    }
    catch (Exception e)
    {
      log.error("Exception in save dynamic report design: ", e);
    }
  }

  /**
   * Create a new empty report design
   */
  public void createEmptyReportDesign()
  {
    try
    {
      SessionHandle session = IvyBirtUtils.getDesignEngineInstance().newSessionHandle(
              new ULocale(Ivy.session().getContentLocale().getCountry()));
      designHandle = session.createDesign();
      designFactory = designHandle.getElementFactory();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public ElementFactory getDesignFactory()
  {
    return designFactory;
  }

  /**
   * Add CMS image to report as embedded image. Execute CMS find object
   * operation as system
   * @param path
   * @param imageName
   */
  public void addCmsImageToReport(final String path, String imageName)
  {
    try
    {
      EmbeddedImage image = StructureFactory.createEmbeddedImage();
      byte[] imageData = SecurityManagerFactory.getSecurityManager().executeAsSystem(new Callable<byte[]>()
        {
          @Override
          public byte[] call() throws Exception
          {
            return Ivy.cms().findContentObjectValue(path, Locale.GERMAN).getContentAsByteArray();
          }
        });
      image.setData(imageData);
      image.setName(imageName);
      getReportDesign().addImage(image);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * The create dynamic report method must be implemented
   * @return Created report design
   */
  @Override
  public abstract ReportDesignHandle createDynamicReport();

}
