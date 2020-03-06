package com.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase
{
	//PageFactory-object repository
       @FindBy(name="username")	
       WebElement un;
       
       @FindBy(name="password")
       WebElement pw;
       
       @FindBy(xpath="//input[@class='btn btn-small']")
       WebElement loginBtn;
       
       @FindBy(xpath="//a[text()='Sign Up']")
       WebElement signup;
       
       @FindBy(xpath="(//img[@class='img-responsive'])[1]")
       WebElement crmLogo;
       
       @FindBy(xpath="(//a[text()='Features']")
       WebElement featureBtn;
       
       //Initializing the page objects
       public LoginPage()
       {
    	   PageFactory.initElements(driver,this);
       }
       
       //Actions:
       public String validateLoginPageTitle()
       {
    	   return driver.getTitle();
       }
       
       public boolean validateCRMImage()
       {
    	   return crmLogo.isDisplayed();
       }
       
       public HomePage login(String unm,String pwd)
       {
    	   un.sendKeys(unm);
    	   pw.sendKeys(pwd);
    	  
    	   JavascriptExecutor executor = (JavascriptExecutor)driver;
    	   executor.executeScript("arguments[0].click();",loginBtn);
    	   //loginBtn.click();
		  return new HomePage();
       }
       
       public FeaturePage featurePage()
       {
    	   //featureBtn.click();
    	   JavascriptExecutor js=(JavascriptExecutor)driver;
    	   js.executeScript("arguments[0].click();",loginBtn);
    	   return new FeaturePage();
       }
       
}
