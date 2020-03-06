package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase 
{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contactClick;
	
	@FindBy(xpath="(//input[@name='contact_id'])[2]")
	WebElement contactbuttonClick;
	
	@FindBy(xpath="(//table)[12]/tbody/tr[3]/td[2]/strong[1]")
	WebElement contactName;
	
	@FindBy(xpath="(//table)[13]/tbody/tr/td[2]/descendant::*[3]")
	WebElement newContact;
	

	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstName;
	

	@FindBy(xpath="//input[@id='surname']")
	WebElement lastName;
	

	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
    @FindBy(xpath="//input[@type='submit' and @value='Save']")
    WebElement saveBtn;
	
    @FindBy(xpath="//input[@value='52738050']")
    WebElement chckBox;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//Actions:-
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
		
	
	public void verifyContactclick(){
		
		contactbuttonClick.click();
		
	}
	
	public boolean verifyContactName(){
		
		return contactName.isDisplayed();
	}
	 
	
	public void createNewContact(String title,String ftName,String ltName,String comp)
	{
		
		Select select=new Select(driver.findElement(By.name("title")));
	    select.selectByVisibleText(title);
	    firstName.sendKeys(ftName);
	    lastName.sendKeys(ltName);
	    company.sendKeys(comp);
	    saveBtn.click();
	}
	
	public void selectContacts(){
		//driver.switchTo().frame("mainpanel");
		chckBox.click();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}
	
	
	
}//(//table)[12]/tbody/tr[3]/td[2]/strong[1]
//(//input[@name='contact_id'])[2]
