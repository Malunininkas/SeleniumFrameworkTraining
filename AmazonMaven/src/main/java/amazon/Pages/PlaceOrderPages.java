package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;

public class PlaceOrderPages extends AmazonBase{
	
	
	
	
	
	public static void DeleteShippingAddress() {
//TASK: Build try delete catch no such element for general cleanup	
		logger.debug("deleting shipping address");
		WebElement itemType = driver.findElements(By.className("a-button-text"))
				.stream().filter(e -> e.getText().equals("Delete")).findFirst().get();
		itemType.click();
	}
	
	
	public static void AddAddress(String addressLine1) {
		
		logger.debug("adding address");
		driver.findElement(By.id("enterAddressAddressLine1")).sendKeys(addressLine1);
	}
	
	
	public static void AddAddress2(String addressLine1) {
		
		logger.debug("adding address");
		driver.findElement(By.id("enterAddressAddressLine2")).sendKeys(addressLine1);
	}
	
	
	public static void AddCity(String addressCity) {
		
		logger.debug("adding city name");
		driver.findElement(By.id("enterAddressCity")).sendKeys(addressCity);
	}
	
	
	public static void AddPostalCode(String postalCode) {
		
		logger.debug("adding postal code");
		driver.findElement(By.id("enterAddressPostalCode")).sendKeys(postalCode);
	}

	
	public static void SelectCountry(String countryName) {
		
		logger.debug("selecting country");
		Select countryList = new Select(driver.findElement(By.id("enterAddressCountryCode")));
		countryList.selectByVisibleText(countryName);
	}

	
	public static void AddPhone(String phoneNumber) {
		
		logger.debug("adding phone number");
		driver.findElement(By.id("enterAddressPhoneNumber")).sendKeys(phoneNumber);
	}

	
	public static void AddAddressInstructions(String addressInstructions) {
		
		logger.debug("adding address instructions");
		driver.findElement(By.id("AddressInstructions")).sendKeys(addressInstructions);
	}
	
	
	public static void SubmitAddress() {

		logger.debug("submitting address");
		driver.findElement(By.name("shipToThisAddress")).click();
	}
	
	
	public static void CcName(String ccName) {
		
		logger.debug("adding credit card name");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ccName")));
		driver.findElement(By.id("ccName")).sendKeys(ccName);
	}
	
		
	public static void CcNumber(String ccNumber) {
		logger.debug("adding credit card number");
		driver.findElement(By.id("addCreditCardNumber")).sendKeys(ccNumber);
	}
	
	
	public static void CcValidM(String ccM_m) {
		
		logger.debug("adding credit card valid month");
		driver.findElements(By.className("a-dropdown-prompt")).stream().filter(e -> e.getText().equals("01")).findFirst().get().click();
		driver.findElement(By.cssSelector("[data-value=\"" + ccM_m + "\"]")).click();
	}
	
	
	public static void CcValidY(String ccY_yyyy) {
		
		logger.debug("adding credit card valid year");
		driver.findElements(By.className("a-dropdown-prompt")).stream().filter(e -> e.getText().equals("2019")).findFirst().get().click();
		driver.findElement(By.cssSelector("[data-value=\"" + ccY_yyyy + "\"]")).click();
//BUG:	This step stale if imported from excel 
	}	
}
