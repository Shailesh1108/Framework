package com.utility;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory 
{
	
	public static WebDriver startApplication( WebDriver driver, String browserName, String appUrl)
	{
		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if( browserName.equals("IE"))
		{
			
		}
		
		driver.get(appUrl);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		return driver;
	}
	
	
	
	
	
	public static void closeApplication(WebDriver driver)
	{
		driver.quit();
	}
	
	
	
	

}
