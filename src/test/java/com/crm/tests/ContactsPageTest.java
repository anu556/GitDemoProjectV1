package com.crm.tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.Util.Utilities;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.qa.base.TestBase;



public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	Utilities utili;
	ContactsPage contactsPage;
	String sheetName="contacts";

	    public ContactsPageTest()
	    {
	    	super();
	    }
	    
	    @BeforeMethod
	    public void setUp(){
	    	initialization();
	    	loginpage=new LoginPage();
	    	contactsPage =new ContactsPage();
	    	utili=new Utilities();
	    	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	    	contactsPage=homepage.clickOnContactsLink();
	    }
	    
	 /*   @Test(priority=1)
	    public void verifyContactsLabelTest(){
	    	Assert.assertTrue(contactsPage.verifyContactsLabel(), "contactslabel is missing on the page");
	    	
	    }
	    
	     @Test(priority=2)
	    public void verifycontactsClickTest(){
	    	contactsPage.verifyContactclick();
	    }
	     
	    @Test(priority=3)
	    public void verifyContactNameTest()
	    {
		    boolean ff=contactsPage.verifyContactName();
	    	Assert.assertTrue(ff);
	    }
	    
	 /*   @Test(priority=4)
	    public void verifyNewContactclickTest(){
	    	
	    	contactsPage.verifyContactclick();
	    	
	    }*/
	    
	  /*  @DataProvider
	    public Object[][] getCRMTestData()  
	    {
	    	Object data[][]=Utilities.getTestData(sheetName);
	    	return data;
	    }
	    
	    @Test(priority=4, dataProvider="getCRMTestData")
	    public void validatecreateNewContactTest(String title,String firstname,String lastname,String company){
	    	//utili.switchToFrame();
	    	homepage.clickOnNewContactsLink();
	    	contactsPage.createNewContact(title,firstname,lastname,company);
	    }*/
	    
	    @Test
	    public void validateselectContactsTest() throws InterruptedException
	    {
	    	//utili.switchToFrame();
	    	contactsPage.selectContacts();
	    	System.out.println("Element is clicked");
	    }
	    @Test
	    public void validateselectContactsByName()
	    {
	    	contactsPage.selectContactsByName("Boom Sharma");
	    }
        
	    @AfterMethod
	    public void tearDown(){
	    	
	      driver.quit();
	    	
	    }
}
