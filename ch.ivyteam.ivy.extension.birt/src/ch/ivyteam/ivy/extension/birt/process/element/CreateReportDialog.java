package ch.ivyteam.ivy.extension.birt.process.element;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.extension.birt.BirtEngine;
import ch.ivyteam.ivy.extension.birt.IvyBirtReportService;
import ch.ivyteam.ivy.extension.birt.IvyBirtUtils;
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
public class CreateReportDialog extends AbstractUserProcessExtension
{
  public static final String ID = "CREATE_REPORT_DIALOG_BEAN";
  public static final String NAME = "Create Report with Database";
  public static final String DESCRIPTION = "Create a report with a given BIRT Design file";
  public static final String ICON = "CreateReportDialog";
  private IvyBirtReportService birtService;
  private IIvyScriptContext context;

  /**
   * @see ch.ivyteam.ivy.process.extension.IUserProcessExtension#perform(ch.ivyteam.ivy.process.engine.IRequestId,
   *      ch.ivyteam.ivy.scripting.objects.CompositeObject,
   *      ch.ivyteam.ivy.scripting.language.IIvyScriptContext)
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public CompositeObject perform(IRequestId requestId, CompositeObject in,
          IIvyScriptContext scriptContext) throws Exception
  {

    this.context = scriptContext;
    CompositeObject out;
    out = in.clone();
    scriptContext = createOwnContext(scriptContext);

    String reportDesign = "";
    File outputFile = null;
    HashMap<String, Object> parameterMap = null;
    String dataSource = "";
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
      dataSource = (String) executeIvyScript(scriptContext, st.nextElement().toString());

    // Do some logging for Debug
    Ivy.log().debug("Report Design: " + reportDesign);
    Ivy.log().debug("Outputformat: " + format);
    Ivy.log().debug("Parameters: " + parameterMap);
    Ivy.log().debug("Name of the Data Source: " + dataSource);

    // Add data source parameters
    if (parameterMap == null)
    {
      parameterMap = new HashMap<String, Object>();
    }
    parameterMap.putAll(IvyBirtUtils.getDatabaseConnectionPropertiesMap(dataSource));
    getService().generateSingleReport(reportDesign, outputFile, parameterMap, format);
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
    private IIvyScriptEditor editorDataSource;
    private IIvyScriptEditor editorOutputFile;
    private IIvyScriptEditor editorOutputFormat;

    /**
     * Constructor for the Editor object
     */
    public Editor()
    {
      super(new GridLayout(6, 2));
    }

    /**
     * Sets the configuration
     * 
     * @param config the configuration as an String
     */
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
        editorDataSource.setText(st.nextElement().toString());
    }

    /**
     * Gets the component attribute of the Editor object
     * 
     * @return this
     */
    public Component getComponent()
    {
      return this;
    }

    /**
     * Gets the configuration
     * 
     * @return The configuration as an String
     */
    public String getConfiguration()
    {
      return editorReportDesignFile.getText().trim() + "|"
              + editorOutputFile.getText().trim() + "|"
              + editorOutputFormat.getText().trim() + "|"
              + editorReportParameterMap.getText().trim() + "|"
              + editorDataSource.getText().trim() + "|";

    }

    /**
     * @return boolean
     */
    public boolean acceptInput()
    {
      if (!editorReportDesignFile.getText().equals("") &&
              !editorOutputFile.getText().equals("") &&
              !editorReportParameterMap.getText().equals("") &&
              !editorDataSource.getText().equals("") &&
              !editorOutputFormat.getText().equals(""))
      {
        return true;
      }
      else
      {
        return false;
      }
    }

    public void setEnvironment(IProcessExtensionConfigurationEditorEnvironment env)
    {
      editorReportDesignFile = env.createIvyScriptEditor(null, null, "String");
      editorOutputFile = env.createIvyScriptEditor(null, null, "ch.ivyteam.ivy.scripting.objects.File");
      editorOutputFormat = env.createIvyScriptEditor(null, null, "ch.ivyteam.ivy.extension.birt.OutputFormat");
      editorReportParameterMap = env.createIvyScriptEditor(null, null, "java.util.Map");
      editorDataSource = env.createIvyScriptEditor(null, null, "String");

      add(new JLabel("Report Design (without .rptdesign"));
      add(editorReportDesignFile.getComponent());
      add(new JLabel("Output File (save the report to this file"));
      add(editorOutputFile.getComponent());
      add(new JLabel("Output Format (use OutputFormat Enumeration)"));
      add(editorOutputFormat.getComponent());
      add(new JLabel("Report Parameters Map (must be a java.util.Map or null)"));
      add(editorReportParameterMap.getComponent());
      add(new JLabel("Name of Datasource, if your report use a data source"));
      add(editorDataSource.getComponent());
    }

  }
}
