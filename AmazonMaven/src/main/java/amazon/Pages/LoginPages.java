package amazon.Pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import amazon.AmazonBase;

public class LoginPages extends AmazonBase {
	
	
	public static void Login(String email, String pass, String name) {
		
		logger.debug("logging in");
		GlobalPages.OpenAccountAndLists();
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("ap_password")).sendKeys(pass);
		driver.findElement(By.id("signInSubmit")).click();
		
		logger.debug("checking name");
		String getName = driver.findElement(By.cssSelector("#nav-link-accountList > span:nth-child(1)")).getText();
		String expectedName = "Hello, " + name;
//Task: Adapt Pages to allow tests use different accounts
 		if (expectedName.equals(getName))
		{
			System.out.println(getName + ", Authentication Successful.");
		}
		else
		{
			System.out.println("Authentication Failed - Wrong Account Name: " + getName);
		}
		
		try {
			  driver.findElement(By.id("nav-link-accountList"));
			}
		catch (Exception NoSuchElementException) 
			{
			  Assert.fail("Account List element was not found");
			}
		Assert.assertTrue(driver.findElement(By.id("nav-link-accountList")).isDisplayed());	
	}

}	

	