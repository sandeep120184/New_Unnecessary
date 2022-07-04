package com.dc.rns.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.dc.rns.qa.Base.BaseTest;

public class Screenshot extends BaseTest
{
	
	public static String takeScreenshot(WebDriver driver, String ScreenshotName)
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String strDestination = System.getProperty("user.dir")+ "/Screenshots/" + ScreenshotName + dateName+ ".png";
		try {
			FileUtils.copyFile(sShot, new File(strDestination));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strDestination;
	}
	
	

}



