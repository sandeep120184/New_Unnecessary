package com.dc.rns.qa.Pages;
import com.dc.rns.qa.Base.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseTest {



	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="signin")
	WebElement SignIn;
	
public LoginPage()
{
	PageFactory.initElements(driver, this);
}
	

public String LoginPageTitle()
{

	return driver.getTitle();
}
public HomePage fnLogin(String uname,String pass)
{
	username.sendKeys(uname);
	password.sendKeys(pass);
	SignIn.click();
	return new HomePage();
}

}
