package com.crm.tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.Util.Utilities;
import com.crm.pages.ContactsPage;
import com.crm.pages.DealsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.qa.base.TestBase;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	Utilities utili;
	ContactsPage contactsPage;
	DealsPage dealspage;
	public HomePageTest()
	{
		super();
	}
    
	
	@BeforeMethod
	public void setUp(){
			initialization();
			loginpage=new LoginPage();
			utili=new Utilities();
		    homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		    
	}
    
	@Test(priority=5)
	public void verifyHomePageTitleTest(){
		String homePageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","HomePage title is not matched");
	}
	
	@Test(priority=6)
	public void verifyContactsLinkTest(){
		contactsPage=homepage.clickOnContactsLink();
	}
		
	@Test(priority=7)
	public void verifyDealsLinkTest(){
		dealspage=homepage.clickOndealsLink();
		
	}
	
	@Test()
	public void verifyCorrectUserNameTest(){
		utili.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
		
	}

