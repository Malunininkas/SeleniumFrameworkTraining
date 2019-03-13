package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import amazon.AmazonBase;

public class SettingsPages extends AmazonBase{

	
	public static void OpenAddresses() {
		
		logger.debug("openning list of added addresses");
		driver.findElement(By.cssSelector("[data-card-identifier=\"Addresses\"]")).click();
	}
	
	
	public static void DeleteAddress() {

		long size = driver.findElements(By.className("a-link-normal")).stream()
				.filter(e -> e.getText().equals("Set as Default")).count();

		while(size > 0) {
	
			logger.debug("choosing address to delete");
			driver.findElement(By.id("ya-myab-address-delete-btn-0")).click();
			
	
			logger.debug("waiting 500ms for modal to fade in");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 500);");	
			
			logger.debug("confirming deletion");
			driver.findElement(By.id("deleteAddressModal-0-submit-btn")).click();
			--size;
		}
	}
}
