package com.parameters;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest 
{
	WebDriver driver;
	
	
	@Test
	@Parameters({"env","browser","url","emailId","pwd"})
	public void gmailLoginTest(String env,String browser,String url,String emailId,String pwd) throws Exception
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","M:/TestAutomation/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","M:/TestAutomation/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		driver.get(url);
	//	driver.findElement(By.xpath("//div[text()='Use another account']")).click();
		driver.findElement(By.xpath("//input[@name='identifier']")).sendKeys(emailId);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.close();
		
	}

}
