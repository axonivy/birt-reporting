package ch.ivyteam.ivy.extension.birt.process.element;

import ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPalette;
import ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPaletteExtension;

/** 
 * Process Palette Extension for XDPPS Process Elements
 * @author mde
 * @since 27.01.2009
 */
public class BirtProcessPalette implements IIvyProcessPaletteExtension
{
  /** The name of the SAP palette group */
  private static final String BIRT_GROUP = "ch.ivyteam.ivy.extension.birt.BirtGroup";
  private final String BIRT_GROUP_LABEL = "BIRT";
  private final int BIRT_GROUP_ID = 10000; 

  /**
   * @see ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPaletteExtension#addEntries(ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPalette)
   */
  @Override
  public void addEntries(IIvyProcessPalette palette)
  {
    palette.addProcessElementEntry(BIRT_GROUP, CreateReportDialog.ID, 1000);
    palette.addProcessElementEntry(BIRT_GROUP, CreateReportXmlDialog.ID, 1001);
    palette.addProcessElementEntry(BIRT_GROUP, CreateDynamicReportDialog.ID, 1002);
  }

  /**
   * @see ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPaletteExtension#addGroups(ch.ivyteam.ivy.designer.process.ui.editor.palette.IIvyProcessPalette)
   */
  @Override
  public void addGroups(IIvyProcessPalette palette)
  {
    palette.addGroup(BIRT_GROUP, BIRT_GROUP_LABEL, BIRT_GROUP_ID);
  }

}
