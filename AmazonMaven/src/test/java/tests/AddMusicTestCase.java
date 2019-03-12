package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.GlobalPages;

public class AddMusicTestCase extends AmazonBase {
	
	@BeforeClass
	public static void FindItem()
	{
		GlobalPages.Search("The Beatles Rubber Soul");
		GlobalPages.OpenItem("Rubber Soul");
	}
	
	@Test(description="Add all types of music items and removed them from the carts")
	public static void AddMp3ToCart() 
	{		

//TASK: make global search
//TASK: give search parameters from separate file?
		GlobalPages.SelectItemType("MP3");
		GlobalPages.AddToCart();
	}
		
	@Test(description="Add all types of music items and removed them from the carts")
	public static void AddCDToCart() 
	{		
		GlobalPages.SelectItemType("Audio CD");
		GlobalPages.AddToCart();
		GlobalPages.GetBackToTheItem();
	}
	
	@Test(description="Add all types of music items and removed them from the carts")
	public static void AddVinylToCart() 
	{
		GlobalPages.SelectItemType("Vinyl");
		GlobalPages.AddToCart();
		GlobalPages.GetBackToTheItem();
	}

	@Test(description="Add all types of music items and removed them from the carts")
	public static void AddCassetteToCart() 
	{		
		GlobalPages.SelectItemType("Audio, Cassette");
		GlobalPages.AddToCart();
		GlobalPages.GetBackToTheItem();
	}
	
	@Test(description="Test added and removed 5 Audio CDs")
	public static void Add5CDsToCart() {
		

		
		GlobalPages.SelectItemType("Audio CD");	
		GlobalPages.SelectQuantity("5");
		GlobalPages.AddToCart();
		GlobalPages.GetBackToTheItem();
	}
}
