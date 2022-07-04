package com.dc.rns.qa.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dc.rns.qa.Pages.DCDashBoard;
import com.dc.rns.qa.Pages.LoginPage;
import com.dc.rns.qa.Base.*;

public class DashBoard extends BaseTest{
	
	DCDashBoard dash;
	
	public DashBoard()
	{
		super();
	}
	
	@BeforeMethod
		public void setup()
		{
			browsersetup();
			dash=new DCDashBoard();

		}

@Test(priority=1)
public void fnSign() {
	dash.LoginBtnClick();
}


@Test(priority=2)
public void Title() {
	dash.LoginTitle();
}


@AfterMethod
public void Teardown()
{
	driver.close();
	driver.quit();
}

	}


