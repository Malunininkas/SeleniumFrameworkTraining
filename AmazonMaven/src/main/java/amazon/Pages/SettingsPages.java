package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
			WebElement itemDelete = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.elementToBeClickable(By.id("ya-myab-address-delete-btn-0")));
			itemDelete.click();
	
			logger.debug("confirming delete address");
			WebElement delete = (new WebDriverWait(driver, 10))
					   .until(ExpectedConditions.
							   elementToBeClickable(By.id("deleteAddressModal-0-submit-btn")));
			delete.click();
//BUG: Sometimes delete confirmation gets stuck and loop tries to click itemDelete again, which stops the cleanup
			--size;
		}
	}
}
