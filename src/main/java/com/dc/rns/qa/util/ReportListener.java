package com.dc.rns.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dc.rns.qa.Base.BaseTest;
import com.dc.rns.qa.ExtentReports.ExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportListener extends ExtentReport implements ITestListener {

	private ExtentReports extent;
	private ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		
		test = extent.startTest(result.getMethod().getMethodName().toString());
		System.out.println("onTestStart");
				
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccessBegin");
		test.log(LogStatus.PASS, result.getMethod().getMethodName().toString());
		System.out.println("onTestSuccessEnd");
		
	}

	
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailureBegin");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName());
		System.out.println("onTestFailureEnd_1");	
		test.log(LogStatus.FAIL, result.getThrowable());
		System.out.println("onTestFailureEnd_2");
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println("onTestFailureEnd_3");
		File sShot = ((TakesScreenshot)BaseTest.driver).getScreenshotAs(OutputType.FILE);
		System.out.println("onTestFailureEnd_4");
		String strDestination = System.getProperty("user.dir")+ "/Screenshots/"
		+result.getMethod().getMethodName()
		+dateName+".png";
		System.out.println("onTestFailureEnd_5");
		try {
			FileUtils.copyFile(sShot, new File(strDestination));
			System.out.println("onTestFailureEnd_6");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("onTestFailureEnd_7");
			test.log(LogStatus.FAIL, test.addScreenCapture(strDestination));
			System.out.println("onTestFailureEnd_8");
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
      System.out.println("onTestSkipBegin");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName());
		System.out.println("onTestSkipEnd");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	
	public void onStart(ITestContext context) {
		
		System.out.println("onStartBegin");
		try {
			extent = ExtentReport.ExtentReportSetUp();
			System.out.println("onStartInsideTry");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void onFinish(ITestContext context) {
		System.out.println("onFinishBegin");
		extent.flush();
		System.out.println("onFinishEnd");

	}

	
}
