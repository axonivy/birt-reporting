package ch.ivyteam.ivy.extension.birt.process.element;

import java.awt.Component;
import java.awt.GridLayout;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.extension.birt.BirtEngine;
import ch.ivyteam.ivy.extension.birt.IvyBirtReportService;
import ch.ivyteam.ivy.extension.birt.OutputFormat;
import ch.ivyteam.ivy.process.engine.IRequestId;
import ch.ivyteam.ivy.process.extension.IIvyScriptEditor;
import ch.ivyteam.ivy.process.extension.IProcessExtensionConfigurationEditorEnvironment;
import ch.ivyteam.ivy.process.extension.IProcessExtensionConfigurationEditorEx;
import ch.ivyteam.ivy.process.extension.impl.AbstractUserProcessExtension;
import ch.ivyteam.ivy.scripting.language.IIvyScriptContext;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;
import ch.ivyteam.ivy.scripting.objects.File;

/**
 * PI implementation to show a SAP dialog
 * 
 * @author mde
 * @since 23.02.2009
 */
public class CreateReportXmlDialog extends AbstractUserProcessExtension
{
  public static final String ID = "CREATE_REPORT_XML_DIALOG_BEAN";
  public static final String NAME = "Create Report with XML Input";
  public static final String DESCRIPTION = "Create a report with XML Input";
  public static final String ICON = "CreateReportDialog";
  private IvyBirtReportService birtService;
  private IIvyScriptContext context;

  /**
   * @see ch.ivyteam.ivy.process.extension.IUserProcessExtension#perform(ch.ivyteam.ivy.process.engine.IRequestId,
   *      ch.ivyteam.ivy.scripting.objects.CompositeObject,
   *      ch.ivyteam.ivy.scripting.language.IIvyScriptContext)
   */
  @Override
  @SuppressWarnings({"rawtypes", "unchecked"})
  public CompositeObject perform(IRequestId requestId, CompositeObject in,
          IIvyScriptContext scriptContext) throws Exception
  {

    this.context = scriptContext;
    CompositeObject out;
    out = in.clone();
    scriptContext = createOwnContext(scriptContext);

    String reportDesign = "";
    File outputFile = null;
    HashMap parameterMap = new HashMap();
    InputStream xmlInput = null;
    OutputFormat format = null;
    Ivy.log().debug(getConfiguration());
    StringTokenizer st = new StringTokenizer(getConfiguration(), "|");
    if (st.hasMoreElements())
      reportDesign = (String) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      outputFile = (File) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      format = (OutputFormat) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      parameterMap = (HashMap) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      xmlInput = (InputStream) executeIvyScript(scriptContext, st.nextElement().toString());

    // Do some logging for Debug
    Ivy.log().debug("Report Design: " + reportDesign);
    Ivy.log().debug("Outputformat: " + format);
    Ivy.log().debug("Parameters: " + parameterMap);
    Ivy.log().debug("XML Input String " + xmlInput);

    if (xmlInput == null)
    {
      // Add data source parameters
      getService().generateSingleReport(reportDesign, outputFile, parameterMap, format);
    }
    else
    {
      getService().generateSingleReport(reportDesign, outputFile, parameterMap, format, xmlInput);
    }
    return out;
  }

  private IvyBirtReportService getService()
  {
    if (birtService == null)
    {
      BirtEngine engine = (BirtEngine) getServerExtension(context, BirtEngine.EXTENSION_ID);
      birtService = engine.getReportService();
    }
    return birtService;
  }

  public static class Editor extends JPanel implements IProcessExtensionConfigurationEditorEx
  {
    private IIvyScriptEditor editorReportDesignFile;
    private IIvyScriptEditor editorReportParameterMap;
    private IIvyScriptEditor editorXmlInput;
    private IIvyScriptEditor editorOutputFile;
    private IIvyScriptEditor editorOutputFormat;

    public Editor()
    {
      super(new GridLayout(6, 2));
    }

    @Override
    public void setConfiguration(String config)
    {
      StringTokenizer st = new StringTokenizer(config, "|");
      if (st.hasMoreElements())
        editorReportDesignFile.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorOutputFile.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorOutputFormat.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorReportParameterMap.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorXmlInput.setText(st.nextElement().toString());
    }

    /**
     * Gets the component attribute of the Editor object
     * @return this
     */
    @Override
    public Component getComponent()
    {
      return this;
    }

    /**
     * Gets the configuration
     * @return The configuration as an String
     */
    @Override
    public String getConfiguration()
    {
      return editorReportDesignFile.getText().trim() + "|"
              + editorOutputFile.getText().trim() + "|"
              + editorOutputFormat.getText().trim() + "|"
              + editorReportParameterMap.getText().trim() + "|"
              + editorXmlInput.getText().trim();
    }

    /**
     * @return boolean
     */
    @Override
    public boolean acceptInput()
    {
      if (!editorReportDesignFile.getText().equals("") &&
              !editorOutputFile.getText().equals("") &&
              !editorOutputFormat.getText().equals("") &&
              !editorXmlInput.getText().equals(""))
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    @Override
    public void setEnvironment(IProcessExtensionConfigurationEditorEnvironment env)
    {
      editorReportDesignFile = env.createIvyScriptEditor(null, null, "String");
      editorOutputFile = env.createIvyScriptEditor(null, null, File.class.getName());
      editorOutputFormat = env
              .createIvyScriptEditor(null, null, OutputFormat.class.getName());
      editorReportParameterMap = env.createIvyScriptEditor(null, null, Map.class.getName());
      editorXmlInput = env.createIvyScriptEditor(null, null, InputStream.class.getName());

      add(new JLabel("Report Design (without .rptdesign"));
      add(editorReportDesignFile.getComponent());
      add(new JLabel("Output File (save the report to this file"));
      add(editorOutputFile.getComponent());
      add(new JLabel("Output Format (use OutputFormat Enumeration)"));
      add(editorOutputFormat.getComponent());
      add(new JLabel("Report Parameters Map (must be a java.util.Map or null)"));
      add(editorReportParameterMap.getComponent());
      add(new JLabel("XML Input Stream(of type java.io.InputStream)"));
      add(editorXmlInput.getComponent());
    }

  }
}
