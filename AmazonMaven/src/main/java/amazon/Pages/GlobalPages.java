package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.AmazonBase;

public class GlobalPages extends AmazonBase {
	
	public static void OpenAccountAndLists() {
		
		logger.debug("clicking account and lists button");
		driver.findElement(By.id("nav-link-accountList")).click();
	}
	
	
	public static void Search(String itemName) {
		
		logger.debug("searching for the item");
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys(itemName);
		searchBox.sendKeys(Keys.RETURN);
	}
	
	
	public static void OpenItem(String itemName) {
		

		logger.debug("opening the the item page");
		driver.findElement(By.cssSelector("img[alt='" + itemName + "'")).click();
	}
	
	
	public static void SelectQuantity(String v) {
		
		logger.debug("selecting quantity");
		Select sq = new Select(driver.findElement(By.cssSelector("[id=\"quantity\"]")));
		sq.selectByVisibleText(v);
	}
	
	
	public static void AddToCart() {
		
		logger.debug("adding to cart");
		if (driver.findElements(By.cssSelector("[data-clickedbuttontype=\"addToCart\"]")).size() > 0) {
			WebElement AddToCart = driver.findElement(By.cssSelector("[data-clickedbuttontype=\"addToCart\"]"));
			AddToCart.click();
		}
		else {
			WebElement AddToCart = driver.findElement(By.id("add-to-cart-button"));
			AddToCart.click();
		}
	}

		
	public static void OpenCart() {
		
		logger.debug("opening the cart");
		driver.findElement(By.id("nav-cart-count")).click();
	}
	
	public static void ProceedToCart() {
		
		logger.debug("proceeding to cart");
		driver.findElement(By.name("proceedToCheckout")).click();
	}
	
	public static void SelectItemType(String typeName) {
		
		logger.debug("selecting item type");
		WebElement itemType = driver.findElements(By.cssSelector(".a-button-text > span"))
				.stream().filter(e -> e.getText().equals(typeName)).findFirst().get();
		itemType.click();
	}	
	
	
	private static void ExpandAddedToCart() {
		
		logger.debug("hovering on the added item icon");
		Actions hover = new Actions(driver);
		WebElement addedToCart = driver.findElement(By.className("huc-v2-table-col"));
		hover.moveToElement(addedToCart);
		hover.perform();
		}


	public static void GetBackToTheItem() {

		ExpandAddedToCart();
//TASK: Move out expands
		logger.debug("getting back to the item page");
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mdp-title")));
		driver.findElement(By.className("sc-product-image")).click();
	}
	
	
	public static void OpenAddedItemCart() {
		logger.debug("opening the cart from added item page");
		driver.findElement(By.id("hlb-view-cart-announce")).click();
	}

	
	public static void ProceedToAddedItemCheckout() {
		logger.debug("proceeding to added item checkout");
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
	}
	
	
	public static void DeleteDublicatingItems() {
		
		logger.debug("deleting duplicating items from cart");
		WebElement delete = (new WebDriverWait(driver, 3))
				   .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Delete\"]")));
		delete.click();
	}
	
	
	public static void DeleteAllCartItems() {
		
		logger.debug("deleting all items from cart");

		Long deleteSize = driver.findElements(By.cssSelector("input[value=\"Delete\"]")).stream().count();
		
		while(deleteSize > 0) {
			
			WebElement delete = (new WebDriverWait(driver, 3))
					   .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Delete\"]")));
			delete.click();
			--deleteSize;
		}
	}


	private static void ExpandDepartmentsList() {
		
		logger.debug("hovering on departments menu dropdown ");
		Actions hover = new Actions(driver);
		WebElement departments = driver.findElement(By.id("nav-link-shopall"));
		hover.moveToElement(departments);
		hover.perform();
	}
	
	
	public static void OpenDepartment(String depName) {
	
		ExpandDepartmentsList();
		
		logger.debug("opening department");
		WebElement departments = driver.findElements(By.className("nav-text")).stream().filter(e -> e.getText().equals(depName)).findFirst().get();
		departments.click();
	}

	
	public static void Submit() {

		logger.debug("submitting");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

	
	public static void Continue() {
//TASK: remove?		GlobalPages.Continue();		
		logger.debug("continuing");
		driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();
	}
	
	
}
