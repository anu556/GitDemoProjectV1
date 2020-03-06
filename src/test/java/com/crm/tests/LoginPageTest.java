package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pages.FeaturePage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.qa.base.TestBase;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	FeaturePage featurepage;
	public LoginPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
	
		
		
	}
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	
    @Test(priority=2)
    public void crmLogoImageTest(){
    	boolean flag=loginpage.validateCRMImage();
    	Assert.assertTrue(flag);
    	
    }
    
    @Test(priority=3)
    public void loginTest(){
    	homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    	
    	 	
    }
    
    @Test(priority=4)
    public void featurePageTest(){
    	featurepage=loginpage.featurePage();
    	    }
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}

}
