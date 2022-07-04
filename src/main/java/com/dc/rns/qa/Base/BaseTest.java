package com.dc.rns.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.dc.rns.qa.util.WebEventListner;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop; 
	public static EventFiringWebDriver eventFiring;
	public static WebEventListner Listner;

	public BaseTest()
	{


		try {

			//	FileInputStream fs = 
			//		new FileInputStream(System.getProperty("user.dir")+
			//			"//src//main//java//com//dc//rns//qa//Config//Config.Properties");

			prop = new Properties();	
			
			FileInputStream fs = new FileInputStream("D://POM Practice//java//com//dc//rns//qa//Config//Config.Properties");
			prop.load(fs);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}


	}



	public static void browsersetup()
	{

		System.out.println("property value is:"+prop.getProperty("strBrowser"));
		String strbr=prop.getProperty("strBrowser");
		if (strbr.equalsIgnoreCase("chrome"))
		{
			System.out.println("driver is: chrome"+strbr);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else  if (strbr.equalsIgnoreCase("firefox"))
		{
			System.out.println("driver is: "+strbr);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}

//need to understand and practice on this
	/*
		eventFiring = new EventFiringWebDriver(driver);
		Listner =	new WebEventListner();
		eventFiring.register(Listner);
		driver = eventFiring;

*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		System.out.println("url is:"+prop.getProperty("url"));
		String url =prop.getProperty("url");
		driver.get(url);
		
	}

}
