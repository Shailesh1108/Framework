package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	 public LoginPage(WebDriver driver)
	 {
		 this.driver= driver;
		 
	 }
	 
	 @FindBy(name= "username")
	 private WebElement  uname;
	 
	 @FindBy(name= "password")
	 private WebElement pass;
	 
	 public void logintoCrm(String Username, String Password)
	 {
		 uname.sendKeys(Username);
		 pass.sendKeys(Password);
	 }

}
