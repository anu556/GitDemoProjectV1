package com.crm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
	WebElement userNameLabel;
	
	@FindBy(xpath=("//a[contains(text(),'Upgrade your account')])[2]"))
    WebElement freeaccount;
	
    @FindBy(xpath=("//td[text()='CRMPRO']"))
    WebElement crmproTitle;
    
    @FindBy(xpath=("//a[text()='Contacts']"))
    WebElement contactsLink;
    
    @FindBy(xpath=("//a[text()='Deals']"))
    WebElement dealsLink;
    @FindBy(xpath="//a[text()='New Contact']")
	WebElement newcontactsClick;
    

 public HomePage()
 {
	 PageFactory.initElements(driver,this);
 }
 
 //Actions:
 
   public String verifyHomePageTitle()
   
   {
	   return driver.getTitle();
   }
   
   public ContactsPage clickOnContactsLink()
   {
	   driver.switchTo().frame("mainpanel");
	   JavascriptExecutor executor = (JavascriptExecutor)driver;
	   executor.executeScript("arguments[0].click();",contactsLink); 
	   return new ContactsPage();
   }
	 
	
	
	 public DealsPage clickOndealsLink()
	 {
		 driver.switchTo().frame("mainpanel");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
  	   js.executeScript("arguments[0].click();",dealsLink);
		// dealsLink.click();
		 return new DealsPage();
	 }
	 
	 public boolean verifyCorrectUserName(){
		 return userNameLabel.isDisplayed();
		 
	 }
	 
	 public void clickOnNewContactsLink(){
	 Actions a=new Actions(driver);
	 a.moveToElement(contactsLink).build().perform();
	 newcontactsClick.click();
	 
	 
	 } 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
 }
 
 
