package com.axonivy.ivy.supplements;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebTestReportGeneration {

	@Test
	public void testReport() throws Exception
	{
		LogCollector engineLog = new LogCollector();
		engineLog.start();
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get(IvyEngine.getBaseUrl()+"/info/index.jsp?showSystemApp=true");
			System.out.println("navigate to "+driver.getCurrentUrl());
			assertThat(driver.getTitle()).contains("ivy");
			
			driver.findElement(By.linkText("View persistent Report (HTML)")).click(); // open report viewer
			driver.findElement(By.linkText("Report")).click(); // open the generated report
			assertThat(driver.getPageSource()).contains("Reporting mit BIRT und Ivy");
		}
		catch(Exception ex)
		{
			engineLog.stop();
			throw ex;
		}
	}
	
}
