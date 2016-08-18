package com.axonivy.ivy.supplements;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LogCollector {
	private final File log;
	private long lengthOnStart;

	public LogCollector() 
	{
		log = new File(System.getProperty("test.engine.log"));
	}
	
	public void start()
	{
		lengthOnStart = log.length();
	}
	
	public List<String> readNewLogs() throws IOException
	{
		List<String> lines = new ArrayList<>();
		try(RandomAccessFile readableLog = new RandomAccessFile(log, "r");)
	      {
	        readableLog.seek(lengthOnStart);
	        String line = null;
	        while((line = readableLog.readLine()) != null)
	        {
	          lines.add(line);
	        }
	      }
		return lines;
	}
	
	public List<String> readNewLogsSilent()
	{
		try
		{
			return readNewLogs();
		}
		catch (Exception ex)
		{
			return Collections.emptyList();
		}
	}
	
	public void stop()
	{
		List<String> logLines = readNewLogsSilent();
		if (!logLines.isEmpty())
		{
			System.err.println("Engine logs occured during test:");
			for(String line : logLines)
			{
				System.err.println(line);
			}
		}
	}
	
}
