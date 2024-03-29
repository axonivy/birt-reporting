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

  private IReportEngine engine;
  private String designRepository;

  public IvyBirtReportService(IReportEngine engine)
  {
    this.engine = engine;
  }

  public IvyBirtReportService(IReportEngine engine, String designRepository)
  {
    this(engine);
    this.designRepository = designRepository;
  }

  public void setReportEngine(IReportEngine engine)
  {
    this.engine = engine;
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
    catch (EngineException ex)
    {
      Ivy.log().error("Could not generate single report.", ex);
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
    catch (EngineException ex)
    {
      Ivy.log().error("Could not generate reporty.", ex);
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
      if (format == OutputFormat.HTML)
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
    catch (BirtException ex)
    {
      logAndThrow("Could not generate the report", ex);      
    }
    catch (FileNotFoundException ex)
    {
      logAndThrow("Could not found result file", ex);
    }
    catch (IOException ex)
    {
      logAndThrow("Could not close Output Stream", ex);
    }
  }
  
  private static void logAndThrow(String message, Exception ex)
  {
    Ivy.log().error(message, ex);
    throw new RuntimeException(message, ex);
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
