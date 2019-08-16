package ch.ivyteam.ivy.extension.birt;

public enum OutputFormat
{
  HTML("html", ".html"),
  DOC("doc", ".doc"),
  PDF("pdf", ".pdf");

  private final String suffix;
  private final String name;

  private OutputFormat(String name, String suffix)
  {
    this.name = name;
    this.suffix = suffix;
  }

  public String getSuffix()
  {
    return suffix;
  }

  public String getName()
  {
    return name;
  }

  public static final OutputFormat getOutputFormatByName(String name)
  {
    for(OutputFormat format : values())
    {
      if (format.name.equals(name))
      {
        return format;
      }
    }
    return null;
  }
}
