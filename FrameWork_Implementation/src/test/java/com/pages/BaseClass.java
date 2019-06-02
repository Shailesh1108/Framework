package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.ConfigDataProvider;
import com.utility.ExcelDataProvider;
import com.utility.Helper;

public class BaseClass
{
 public WebDriver driver;
 public ExcelDataProvider excel;
 public ConfigDataProvider config;
 public ExtentReports report;
 public ExtentTest logger;
    
@BeforeSuite
public void setUpSuite()
{
	Reporter.log("Suite Started", true);
	 excel = new ExcelDataProvider();
	 config = new ConfigDataProvider();
	 ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM+"+Helper.getCurrentDateTime()+".html"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
	 
	 
}
    @BeforeClass
    public void setup()
    {
    	Reporter.log("Before Class Started", true);
    	driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
    }
    
    @AfterClass
    public void closeapp()
    {
    	Reporter.log("After Class Started", true);
    	BrowserFactory.closeApplication(driver);
    }
    
    @AfterMethod
        
    	public void tearDownMethod(ITestResult result )
    	{
    	Reporter.log("test After method", true);
    	if(result.getStatus()==ITestResult.FAILURE)
    	{
    		logger.fail("Test Failed", MediaEntityBuilder.createscreenCapturefromPath(Helper.captureScreenshot(driver)).build());
    	}
    	
    	else if(result.getStatus()==ITestResult.SUCCESS)
    	{
    		logger.Pass("Test Failed", MediaEntityBuilder.createscreenCapturefromPath(Helper.captureScreenshot(driver)).build());
    	}
    	
    	else if(result.getStatus()==ITestResult.SKIP)
    	{
    		logger.Skip("Test Failed", MediaEntityBuilder.createscreenCapturefromPath(Helper.captureScreenshot(driver)).build());
    	}
    	report.flush();
    	}
    	
  

}
