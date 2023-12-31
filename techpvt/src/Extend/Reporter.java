package com.Automation.Extend;


import java.util.Locale;

import com.Automation.Extend.TestReporter;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.NetworkMode;

import parallelExecution.Extend.Interface.ITestReporter;


public class Reporter {

	private static ExtentReports reporter = null;
	private static IReporter testReporter = null;
	
	public static void createReporter(String filePath)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath);
		
	}
	
	public static void createReporter(String filePath, boolean replaceExisting)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, NetworkMode networkMode)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, networkMode);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, NetworkMode networkMode, Locale locale)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, networkMode, locale);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, DisplayOrder displayOrder)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, displayOrder);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, DisplayOrder displayOrder,  Locale locale)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, displayOrder, locale);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, DisplayOrder displayOrder,  NetworkMode networkMode)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, displayOrder, networkMode);
	}
	
	public static void createReporter(String filePath, boolean replaceExisting, DisplayOrder displayOrder,  NetworkMode networkMode, Locale locale)
	{
		if(reporter == null)
			reporter = new ExtentReports(filePath, replaceExisting, displayOrder, networkMode, locale);
	}
	
	public static void flushReport()
	{
		if(reporter != null)
			reporter.flush();
	}
	
	public static void closeReport()
	{
		if(reporter != null)
			reporter.close();
	}
	
	// this code can be further simplified
	public static IReporter getTestReporter()
	{
		if(testReporter == null)
		{
			if(reporter != null)
			{
				testReporter = (IReporter) new TestReporter(reporter);
			}
		}
		return testReporter;
	}
}