package tests;

import org.testng.annotations.Test;

import amazon.AmazonBase;
import amazon.Pages.GlobalPages;
import amazon.Pages.PlaceOrderPages;

public class SmokeTestCase extends AmazonBase {
	
	@Test(description="Test adds an item to the cart, SMOKE")
	public void AddtoCartSmoke()
	{
		GlobalPages.Search("The Beatles Rubber Soul");
		GlobalPages.OpenItem("Rubber Soul");
		GlobalPages.SelectItemType("Audio CD");
		GlobalPages.AddToCart();
	}
	
	@Test(dependsOnMethods = {"AddtoCartSmoke"}, 
			description="Test fills address form and submits it, SMOKE")
	public void SubmitAddressSmoke()
	{
		GlobalPages.ProceedToAddedItemCheckout();
		
		PlaceOrderPages.AddAddress("24 School Ln, Egham");
		PlaceOrderPages.AddAddress2("22");
		PlaceOrderPages.AddCity("SHOTTISHAM");
		PlaceOrderPages.AddPostalCode("TW20 9LQ");
		PlaceOrderPages.SelectCountry("United Kingdom");
		PlaceOrderPages.AddPhone("+12025550131");
		PlaceOrderPages.AddAddressInstructions("This order "
				+ "is being done by automated test built by "
				+ "Selenium for Java, therefore, do not "
				+ "deliver and refund lease, thanks");
		
		GlobalPages.Submit();
		GlobalPages.Submit();
	}
	
	@Test(dependsOnMethods = {"AddtoCartSmoke", "SubmitAddressSmoke"},
			description="Test proceeds to the payment and fills CC information, SMOKE")
	public void FillCCSmoke()
	{
		PlaceOrderPages.CcName("Dulce Campbell");
		PlaceOrderPages.CcNumber("4865398914894674");
		PlaceOrderPages.CcValidM("8");
		PlaceOrderPages.CcValidY("2023");
 	}
}
