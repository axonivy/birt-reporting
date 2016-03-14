package ch.ivyteam.ivy.extension.birt;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.birt.core.exception.BirtException;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.extension.birt.dynreport.IDynamicReport;
import ch.ivyteam.ivy.extension.birt.rendering.ivy.IvyHtmlRenderOptions;
import ch.ivyteam.ivy.scripting.objects.File;

/**
 * Simple Birt Report Service to generate report
 * @author mde
 */
public class IvyBirtReportService
{
  /* Report Suffix of Birt Report Design files */
  private static final String BIRT_REPORT_SUFFIX = ".rptdesign";
  /* The BIRT Report engine */
  private IReportEngine engine;
  /* The path to report design repository */
  private String designRepository;

  public IvyBirtReportService(IReportEngine _engine)
  {
    engine = _engine;
  }

  public IvyBirtReportService(IReportEngine _engine, String _designRepository)
  {
    this(_engine);
    designRepository = _designRepository;
  }

  public void setReportEngine(IReportEngine _engine)
  {
    engine = _engine;
  }

  /**
   * Generate a PDF report
   * @param reportDesign absolute path of the report design
   * @param outputFile
   * @param format
   * @param parameters
   */
  public void generateSingleReport(String reportDesign, File outputFile, Map<String, Object> parameters, OutputFormat format)
  {
    generateSingleReport(reportDesign, outputFile, parameters, format, null);
  }

  /**
   * Generate a pdf report with a given XML data source
   * @param reportDesign absolute path of the report design
   * @param outputFile
   * @param format
   * @param parameters
   * @param xmlData
   */
  public void generateSingleReport(String reportDesign, File outputFile, Map<String, Object> parameters, OutputFormat format, InputStream xmlData)
  {
    try
    {
      String reportDesignPath = getReportDesign(reportDesign);
      generateReport(engine.openReportDesign(reportDesignPath), outputFile, format, parameters, xmlData);
    }
    catch (EngineException e)
    {
      Ivy.log().error(e);
    }
  }

  public void generateDynamicReport(IDynamicReport dynamicReport, File outputFile, OutputFormat format)
  {
    try
    {
      if (dynamicReport != null)
      {
        generateReport(engine.openReportDesign(dynamicReport.createDynamicReport()), outputFile, format, null, null);
      }
      else
      {
        Ivy.log().error("Dynamic Report class instance is null. Please check your dynamic report class. Report can not be created");
      }
    }
    catch (EngineException e)
    {
      Ivy.log().error(e);
    }
  }

  /**
   * Generate the report
   * @param design report design file
   * @param outputFile result file
   * @param parameters map of parameters
   * @param format output format
   * @param xmlData xml input stream
   */
  private void generateReport(IReportRunnable design, File outputFile, OutputFormat format,
          Map<String, Object> parameters, InputStream xmlData)
  {
    try
    {
      // fix IllegalStateException while generating HTML task. See https://www.eclipse.org/forums/index.php/t/545694/
      System.setSecurityManager(null);
    	
      IRunAndRenderTask task = engine.createRunAndRenderTask(design);
      if (parameters != null)
      {
        task.setParameterValues(parameters);
        task.validateParameters();
      }
      // Set the locale set the actual ivy session
      task.setLocale(Ivy.session().getContentLocale());

      if (xmlData != null)
      {
        setXmlDataStream(xmlData, task);
      }

      RenderOption options = new RenderOption();
      options.setOutputFormat(format.getName());
      if (format.equals(OutputFormat.HTML))
      {
        options = new IvyHtmlRenderOptions(outputFile, options);
      }
      task.setRenderOption(options);
      FileOutputStream fos = new FileOutputStream(outputFile.getJavaFile());
      task.getRenderOption().setOutputStream(fos);
      
      task.run();
      task.close();
      fos.close();
      Ivy.log().info("Report was successfully created: " + outputFile.getAbsolutePath());
    }
    catch (BirtException e)
    {
      Ivy.log().error(e);
      throw new RuntimeException("Could not generate the report", e);
    }
    catch (FileNotFoundException e)
    {
      Ivy.log().error(e);
      throw new RuntimeException("Could not found result file", e);
    }
    catch (IOException e)
    {
      Ivy.log().error(e);
      throw new RuntimeException("Could not close Output Stream", e);
    }
  }

  @SuppressWarnings("unchecked")
  private void setXmlDataStream(InputStream xmlData, IRunAndRenderTask task)
  {
    task.getAppContext().put("org.eclipse.datatools.enablement.oda.xml.inputStream", xmlData);
  }

  /**
   * @param reportDesign
   * @return the absolute path of the report design. If a design repository
   *         exists, then the path will be calculated, otherwise the report
   *         design contains already the absolute path
   */
  private String getReportDesign(String reportDesign)
  {
    if (designRepository != null && !designRepository.equals(""))
    {
      return designRepository + "/" + reportDesign + BIRT_REPORT_SUFFIX;
    }
    else
    {
      return reportDesign + BIRT_REPORT_SUFFIX;
    }
  }
}
