package ch.ivyteam.ivy.extension.birt.process.element;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ch.ivyteam.ivy.process.element.IBpmnIconFactory;
import ch.ivyteam.ivy.process.element.IExtensibleProcessElementFactory;
import ch.ivyteam.ivy.process.element.IExtensibleStandardProcessElementExtension;

/**
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
    if (CreateReportDialog.ICON.equals(iconName) || CreateReportXmlDialog.ICON.equals(iconName))
    {
      return createActivityBpmnIcon(iconFactory, CreateReportDialog.ICON);
    }
    else if (CreateDynamicReportDialog.ICON.equals(iconName))
    {
      return createActivityBpmnIcon(iconFactory, CreateDynamicReportDialog.ICON);
    }
    return null;
  }

  private Icon createActivityBpmnIcon(IBpmnIconFactory iconFactory, String icon)
  {
    URL iconUrl = getClass().getClassLoader().getResource(icon + ".png");
    if (iconUrl == null)
    {
      return null;
    }
    return iconFactory.createActivityBpmnIcon(new ImageIcon(iconUrl), false);
  }
  
  @Override
  public void declareProcessElements(IExtensibleProcessElementFactory factory)
  {
    factory.declareProgramInterfaceProcessElement(CreateReportDialog.ID, CreateReportDialog.class.getName(), CreateReportDialog.ICON);
    factory.declareProgramInterfaceProcessElement(CreateReportXmlDialog.ID, CreateReportXmlDialog.class.getName(), CreateReportXmlDialog.ICON);
    factory.declareProgramInterfaceProcessElement(CreateDynamicReportDialog.ID, CreateDynamicReportDialog.class.getName(), CreateDynamicReportDialog.ICON);
  }
}
