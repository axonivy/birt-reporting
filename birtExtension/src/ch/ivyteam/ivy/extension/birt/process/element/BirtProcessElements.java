package ch.ivyteam.ivy.extension.birt.process.element;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ch.ivyteam.ivy.process.element.IBpmnIconFactory;
import ch.ivyteam.ivy.process.element.IExtensibleProcessElementFactory;
import ch.ivyteam.ivy.process.element.IExtensibleStandardProcessElementExtension;

/**
 * Xpert.ivy extensible standard process element extension for SAP process
 * elements
 * 
 * @author mde
 * @since 27.01.2009
 */
public class BirtProcessElements implements IExtensibleStandardProcessElementExtension
{
  @Override
  public String getName()
  {
    return "BIRTProcessElements";
  }

  @Override
  public Icon createBpmnIcon(IBpmnIconFactory iconFactory, String iconName)
  {
    if (iconName.equals(CreateReportDialog.ICON) || iconName.equals(CreateReportXmlDialog.ICON))
    {
      URL iconUrl = getClass().getClassLoader().getResource(CreateReportDialog.ICON + ".png");
      if (iconUrl != null)
      {
        return iconFactory.createActivityBpmnIcon(new ImageIcon(iconUrl), false);
      }
    }
    else if (iconName.equals(CreateDynamicReportDialog.ICON))
    {
      URL iconUrl = getClass().getClassLoader().getResource(CreateDynamicReportDialog.ICON + ".png");
      if (iconUrl != null)
      {
        return iconFactory.createActivityBpmnIcon(new ImageIcon(iconUrl), false);
      }
    }
    return null;
  }

  @Override
  public void declareProcessElements(IExtensibleProcessElementFactory factory)
  {
    factory.declareProgramInterfaceProcessElement(CreateReportDialog.ID,
            CreateReportDialog.class.getName(), CreateReportDialog.ICON);
    factory.declareProgramInterfaceProcessElement(CreateReportXmlDialog.ID,
            CreateReportXmlDialog.class.getName(), CreateReportXmlDialog.ICON);
    factory.declareProgramInterfaceProcessElement(CreateDynamicReportDialog.ID,
            CreateDynamicReportDialog.class.getName(), CreateDynamicReportDialog.ICON);
  }
}
