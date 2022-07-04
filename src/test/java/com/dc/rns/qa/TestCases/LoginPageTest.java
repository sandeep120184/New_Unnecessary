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


public class LoginPageTest extends BaseTest{

	LoginPage loginpage;
	DCDashBoard dashboard;
	HomePage homepage;	
	ExcelReader rd;	
	
	
	//ExtentReport extr;
	//ExtentTest test;
	static ExtentReports rt;
	

	//public static ExtentReports extent;
	//public static ExtentTest test;
 

	public static String sheetname = "login";
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		browsersetup();
		rd = new ExcelReader();
		dashboard =new DCDashBoard();
		dashboard.LoginBtnClick();
		loginpage= new LoginPage();
	
		//sc = new Screenshot();
		
	}

@DataProvider()
public Object[][] strLoginData()
{
 Object data[][]= rd.getData(sheetname);
return data;
}
	

@Test(priority=1,dataProvider = "strLoginData")	
public void Login(String uname,String pswd)
{
	System.out.println("step1");

 loginpage.fnLogin(uname, pswd);
 System.out.println("step3");
}
	
	@Test(priority=2)
	public void ValidateLoginTitle()
	{
		System.out.println("step4");


		String strTitle=loginpage.LoginPageTitle();
		System.out.println("step6");
		Assert.assertEquals(strTitle, "Login1");
	}

	@AfterMethod
	public void Teardown()
	{
        driver.close();
		driver.quit();
	}

}
