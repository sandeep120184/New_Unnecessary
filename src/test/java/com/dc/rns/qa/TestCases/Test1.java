package com.dc.rns.qa.TestCases;
import static org.testng.Assert.assertEquals;
import com.dc.rns.qa.Pages.*;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dc.rns.qa.Pages.LoginPage;
import com.dc.rns.qa.util.ExcelReader;
import com.dc.rns.qa.util.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.dc.rns.qa.Base.*;
import com.dc.rns.qa.ExtentReports.ExtentReport;
import com.dc.rns.qa.ExtentReports.ExtentReport_New;


public class Test1 extends BaseTest{

	public void test()
	{
		System.out.println("first commit from team memeber");
	}
}