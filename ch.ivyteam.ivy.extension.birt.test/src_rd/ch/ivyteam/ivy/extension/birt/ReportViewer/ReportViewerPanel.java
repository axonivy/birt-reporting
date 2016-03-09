package ch.ivyteam.ivy.extension.birt.ReportViewer;

import ch.ivyteam.ivy.richdialog.exec.panel.IRichDialogPanel;
import ch.ivyteam.ivy.richdialog.rdpanels.RichDialogGridBagPanel;
import ch.ivyteam.ivy.richdialog.widgets.components.RBrowser;
import ch.ivyteam.ivy.richdialog.widgets.containers.RScrollPane;

/**
 * RichDialog panel implementation for ReportViewerPanel.
 * @author <%=author%>
 * @since <%=date%>
 */
public class ReportViewerPanel extends RichDialogGridBagPanel 
implements IRichDialogPanel 
{ 
  /** Serial version id */
  private static final long serialVersionUID = 1L;
private RBrowser brReportViewer = null;
private RScrollPane scpReportViewer = null;
  
  /**
   * Create a new instance of ReportViewerPanel
   */
  public ReportViewerPanel()
  {
    super();
    initialize();
  }
  
  /**
   * This method initializes ReportViewerPanel
   * @return void
   */
  private void initialize()
  {
        this.setPreferredSize(new com.ulcjava.base.application.util.Dimension(336,335));
        this.add(getScpReportViewer(), new com.ulcjava.base.application.GridBagConstraints(0, 1, 1, 1, -1, -1, com.ulcjava.base.application.GridBagConstraints.CENTER, com.ulcjava.base.application.GridBagConstraints.NONE, new com.ulcjava.base.application.util.Insets(0,0,0,0), 0, 0));
  }

/**
 * This method initializes brReportViewer	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.components.RBrowser	
 */
private RBrowser getBrReportViewer() {
	if (brReportViewer == null) {
		brReportViewer = new RBrowser();
		brReportViewer.setName("brReportViewer");
	}
	return brReportViewer;
}

/**
 * This method initializes scpReportViewer	
 * 	
 * @return ch.ivyteam.ivy.richdialog.widgets.containers.RScrollPane	
 */
private RScrollPane getScpReportViewer() {
	if (scpReportViewer == null) {
		scpReportViewer = new RScrollPane();
		scpReportViewer.setName("scpReportViewer");
		scpReportViewer.setStyleProperties("{/fill \"BOTH\"/weightY \"1\"/weightX \"1\"}");
		scpReportViewer.setViewPortView(getBrReportViewer());
	}
	return scpReportViewer;
}
}  //  @jve:decl-index=0:visual-constraint="10,10"