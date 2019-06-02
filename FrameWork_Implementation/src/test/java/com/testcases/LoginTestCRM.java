package com.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utility.BrowserFactory;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class LoginTestCRM extends BaseClass
{
 
     
	@Test
	public void loginApp(String uname, String pass)
	{		
		 report.createTest("Login To CRM");
		 LoginPage l = PageFactory.initElements(driver, LoginPage.class);
		 logger.info("Starting Application");
		 l.logintoCrm(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		 logger.pass("Login Success");
		 Helper.captreScreenshot(driver);
		
	}
	
}
