package amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import amazon.AmazonBase;

public class MusicPages extends AmazonBase {


	public static void OpenMp3Cart() {
		
		GlobalPages.OpenDepartment("Digital Music");
		
		logger.debug("opening mp3 cart");
		WebElement mp3Cart = driver.findElements(By.className("nav-a-content")).stream()
				.filter(e -> e.getText().equals("MP3 cart")).findFirst().get();
		mp3Cart.click();
	}
	
	
	public static void RemoveMp3() {
		
		logger.debug("removing mp3 from the cart");

		WebElement remove = driver.findElements(By.cssSelector("[data-callback=\"toggleButtonsOnPage\"]")).stream()
				.filter(e -> e.getText().equals("Remove")).findFirst().get();
		remove.click();
	}

		
	public static void RemoveAllMp3() {
		
		logger.debug("removing all mp3 from the cart");

		Long size = driver.findElements(By.cssSelector("[data-callback=\"toggleButtonsOnPage\"]")).stream()
				.filter(e -> e.getText().equals("Remove")).count();
		
		while(size > 0) {
						
			WebElement remove = driver.findElements(By.cssSelector("[data-callback=\"toggleButtonsOnPage\"]")).stream()
					.filter(e -> e.getText().equals("Remove")).findFirst().get();
			remove.click();
			--size;
		}
	}

		
}
