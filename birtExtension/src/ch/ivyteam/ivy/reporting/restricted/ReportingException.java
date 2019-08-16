package ch.ivyteam.ivy.reporting.restricted;

/**
 * Standard exception thrown by reporting subsystem.
 * @author jst
 * @since 27.07.2009
 */
public class ReportingException extends Exception
{
  public ReportingException()
  {
  }

  public ReportingException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public ReportingException(String message)
  {
    super(message);
  }

  public ReportingException(Throwable cause)
  {
    super(cause);
  }
}
