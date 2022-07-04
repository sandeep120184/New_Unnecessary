package com.dc.rns.qa.ExtentReports;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;
import org.testng.xml.XmlSuite;

import com.dc.rns.qa.Base.BaseTest;
import com.dc.rns.qa.util.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport implements IReporter {

private static ExtentReports extent;
private static ExtentTest test;
	


	public static ExtentReports ExtentReportSetUp()
	{
	System.out.println("Step 7");
	SimpleDateFormat dt = new SimpleDateFormat("YYYY-MM-DD HH-MM-SS");
	Date date = new Date();
	String actualdate= dt.format(date);
	String path = System.getProperty("user.dir") + 
			"/Reports/Automation_ExtentReport_"+actualdate+".html";
	
	/*ExtentSparkReporter spark = new ExtentSparkReporter(path);
	ExtentReports extent = new ExtentReports();
	extent.AttachReporter(spark);
*/	
	extent = new ExtentReports(path,true);
		extent.addSystemInfo("Environment", "QA");
		extent.addSystemInfo("Project Name", "RNS");
		System.out.println("step8");
		return extent;
				
	}



	private static String split(SimpleDateFormat dt, String string) {
		// TODO Auto-generated method stub
		return null;
	}

/*


public void testresults(ITestResult itr)
{
	System.out.println("step9");
	
	if (itr.getStatus() == ITestResult.FAILURE)
	{
		System.out.println("step10");
	
		test.log(LogStatus.FAIL, itr.getTestName());
		System.out.println("step11");
		test.log(LogStatus.FAIL, itr.getThrowable());
		System.out.println("step12");
		
	}else if (itr.getStatus() == ITestResult.SKIP)
	{
		System.out.println("step13");
		test.log(LogStatus.SKIP, itr.getTestName());
		System.out.println("step14");
		test.log(LogStatus.SKIP, itr.getThrowable());
		System.out.println("step15");
	}else if(itr.getStatus() == ITestResult.SUCCESS)
			{
		System.out.println("step16");
				test.log(LogStatus.PASS, itr.getTestName());
				System.out.println("step17");
			}

	extent.endTest(test);
}


public void endReport()
{
	System.out.println("step18");
extent.flush();
System.out.println("step19");
}



/*
	 * public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
	 * String outputDirectory) { 
	 * extent = new ExtentReports(outputDirectory + File.separator + "ExtentReport.html", true); 
	 * 
	 * for (ISuite suite : suites) { Map<String, ISuiteResult> result =
	 * suite.getResults();
	 * 
	 * for (ISuiteResult r : result.values()) {
	 * 
	 * ITestContext context = r.getTestContext();
	 * buildTestNodes(context.getPassedTests(), LogStatus.PASS);
	 * buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
	 * buildTestNodes(context.getSkippedTests(), LogStatus.SKIP); } }
	 * 
	 * extent.flush(); extent.close(); }
	 * 
	 * private void buildTestNodes(IResultMap tests, LogStatus status) { ExtentTest
	 * test;
	 * 
	 * if (tests.size() > 0) { for (ITestResult result : tests.getAllResults()) {
	 * test = extent.startTest(result.getMethod().getMethodName());
	 * test.getTest().setStartedTime(getTime(result.getStartMillis()));
	 * test.getTest().setEndedTime(getTime(result.getEndMillis()));
	 * 
	 * 
	 * for(String message:Reporter.getOutput(result)) { test.log(LogStatus.INFO,
	 * message); }
	 * 
	 * 
	 * for (String group : result.getMethod().getGroups()) {
	 * test.assignCategory(group);
	 * 
	 * int s = result.getStatus(); //String res =
	 * Screenshot.takeScreenshot(BaseTest.driver, result.getName());
	 * 
	 * if (result.getThrowable()!=null) if (s==1) { test.log(status, "Test " +
	 * status.toString().toLowerCase() + "ed"); }else { test.log(status, "Test " +
	 * status.toString().toLowerCase() + "ed"); }
	 * 
	 * 
	 * String message = "Test " + status.toString().toLowerCase() + "ed"; if (s ==
	 * 1) { test.log(status, message); } else { test.log(status, message); //
	 * test.log(status, message + test.addScreenCapture(res));
	 * 
	 * } extent.endTest(test); } }
	 * 
	 * } private Date getTime(long startMillis) { Calendar calendar =
	 * Calendar.getInstance(); calendar.setTimeInMillis(startMillis); return
	 * calendar.getTime(); }
	 * 
	 * 
	 */

}
