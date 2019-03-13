package amazon;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import amazon.Pages.LoginPages;
import assets.Cleaner;
import assets.ExcelRead;

public class AmazonBase {
	
	protected static WebDriver driver;
	protected static Logger logger;
		
	@BeforeClass
	public static void SetupAmazon() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mano\\Dropbox\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
//Task:	Headless
//Task: Screenshots, video		
		String appUrl = "https://www.amazon.com";
		driver.get(appUrl);

		driver.manage().window().maximize();
		logger = Logger.getLogger("Terminator is");
		LoginPages.Login(ExcelRead.getCell(0,0), ExcelRead.getCell(0,1), ExcelRead.getCell(0,2));
		Reporter.log("      Cleaning...", true);
		Cleaner.cleaner();
		driver.get(appUrl);
	}
	
	
	@AfterClass
	public static void CloseBrowser()
	{
		Reporter.log("      Closing...", true);
		driver.close();
	}
}	
