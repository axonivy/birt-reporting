package ch.ivyteam.ivy.extension.birt.process.element;

import java.util.Locale;

import ch.ivyteam.ivy.designer.process.ui.info.IProcessElementUiInformationExtension;

/**
 * Provides the labels of all BIRT process elements
 * @author mde
 * @since 27.01.2009
 */
public class BirtProcessElementUiInformation implements IProcessElementUiInformationExtension
{
  @Override
  public String getDescription(String processElementClassName, Locale locale)
  {
    if (processElementClassName.equals(CreateReportDialog.ID))
    {
      return CreateReportDialog.DESCRIPTION;
    }
    else if (processElementClassName.equals(CreateReportXmlDialog.ID))
    {
      return CreateReportXmlDialog.DESCRIPTION;
    }
    else if (processElementClassName.equals(CreateDynamicReportDialog.ID))
    {
      return CreateDynamicReportDialog.DESCRIPTION;
    }
    return null;
  }

  @Override
  public String getName(String processElementClassName, Locale locale)
  {
    if (processElementClassName.equals(CreateReportDialog.ID))
    {
      return CreateReportDialog.NAME;
    }
    else if (processElementClassName.equals(CreateReportXmlDialog.ID))
    {
      return CreateReportXmlDialog.NAME;
    }
    else if (processElementClassName.equals(CreateDynamicReportDialog.ID))
    {
      return CreateDynamicReportDialog.NAME;
    }
    return null;
  }

  @Override
  public String getShortName(String processElementClassName, Locale locale)
  {
    return getName(processElementClassName, locale);
  }
}
