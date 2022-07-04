package com.dc.rns.qa.Pages;
import com.dc.rns.qa.Base.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DCDashBoard extends BaseTest{
	
		
//@FindBy(xpath="//*[@id='btn-1581481968157']")
//	WebElement Login;



	public DCDashBoard()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String LoginTitle()
	{
		
		return driver.getTitle();
	}
	
	
	
	public void LoginBtnClick()
	{
	WebElement Login=driver.findElement(By.xpath("//*[@id='btn-1581481968157']"));
		Login.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//return new LoginPage();
		
	}
	
	
	
}
