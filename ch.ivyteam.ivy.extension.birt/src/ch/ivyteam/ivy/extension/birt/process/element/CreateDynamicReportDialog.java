package ch.ivyteam.ivy.extension.birt.process.element;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.extension.birt.BirtEngine;
import ch.ivyteam.ivy.extension.birt.IvyBirtReportService;
import ch.ivyteam.ivy.extension.birt.OutputFormat;
import ch.ivyteam.ivy.extension.birt.dynreport.IDynamicReport;
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
public class CreateDynamicReportDialog extends AbstractUserProcessExtension
{
  public static final String ID = "CREATE_REPORT_DYNAMIC_DIALOG_BEAN";
  public static final String NAME = "Create Dynamic Report";
  public static final String DESCRIPTION = "Create a dynamic report";
  public static final String ICON = "CreateDynamicReportDialog";
  private IvyBirtReportService birtService;
  private IIvyScriptContext context;

  /**
   * @see ch.ivyteam.ivy.process.extension.IUserProcessExtension#perform(ch.ivyteam.ivy.process.engine.IRequestId,
   *      ch.ivyteam.ivy.scripting.objects.CompositeObject,
   *      ch.ivyteam.ivy.scripting.language.IIvyScriptContext)
   */
  @Override
  public CompositeObject perform(IRequestId requestId, CompositeObject in,
          IIvyScriptContext scriptContext) throws Exception
  {

    this.context = scriptContext;
    CompositeObject out;
    out = in.clone();
    scriptContext = createOwnContext(scriptContext);

    IDynamicReport dynamicReport = null;
    File outputFile = null;
    OutputFormat format = null;
    Ivy.log().debug(getConfiguration());
    StringTokenizer st = new StringTokenizer(getConfiguration(), "|");
    if (st.hasMoreElements())
      dynamicReport = (IDynamicReport) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      outputFile = (File) executeIvyScript(scriptContext, st.nextElement().toString());
    if (st.hasMoreElements())
      format = (OutputFormat) executeIvyScript(scriptContext, st.nextElement().toString());

    // Do some logging for Debug
    Ivy.log().debug("Dynamic Report: " + dynamicReport);
    Ivy.log().debug("Outputformat: " + format);
    getService().generateDynamicReport(dynamicReport, outputFile, format);
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
    private IIvyScriptEditor dynamicReportClass;
    private IIvyScriptEditor editorOutputFile;
    private IIvyScriptEditor editorOutputFormat;

    public Editor()
    {
      super(new GridLayout(3, 2));
    }

    /**
     * Sets the configuration
     * @param config the configuration as an String
     */
    public void setConfiguration(String config)
    {
      StringTokenizer st = new StringTokenizer(config, "|");
      if (st.hasMoreElements())
        dynamicReportClass.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorOutputFile.setText(st.nextElement().toString());
      if (st.hasMoreElements())
        editorOutputFormat.setText(st.nextElement().toString());
    }

    /**
     * Gets the component attribute of the Editor object
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
      return dynamicReportClass.getText().trim() + "|"
              + editorOutputFile.getText().trim() + "|"
              + editorOutputFormat.getText().trim();
    }

    /**
     * @return boolean
     */
    public boolean acceptInput()
    {
      if (!dynamicReportClass.getText().equals("") &&
              !editorOutputFile.getText().equals("") &&
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
      dynamicReportClass = env.createIvyScriptEditor(null, null,
              "ch.ivyteam.ivy.extension.birt.dynreport.IDynamicReport");
      editorOutputFile = env.createIvyScriptEditor(null, null, "ch.ivyteam.ivy.scripting.objects.File");
      editorOutputFormat = env
              .createIvyScriptEditor(null, null, "ch.ivyteam.ivy.extension.birt.OutputFormat");

      add(new JLabel("Dynamic report class (interface IDynamicReport)"));
      add(dynamicReportClass.getComponent());
      add(new JLabel("Output File (save the report to this file"));
      add(editorOutputFile.getComponent());
      add(new JLabel("Output Format (use OutputFormat Enumeration)"));
      add(editorOutputFormat.getComponent());
    }

  }
}
