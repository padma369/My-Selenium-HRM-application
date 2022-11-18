package Excecise1;

import org.junit.Assert;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utility.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmzTestwithWebDriverManager {

	WebDriver driver;

	@Test
	public void verifySearchFeature() throws Exception {

		// create an object

		ConfigRead conf = new ConfigRead();

		String browsernames = conf.getBrowserforsomeotherbrowser();

		String url = conf.getAmazonApp();

		System.out.println("Browser Execution : " + browsernames);

		System.out.println("App URL : " + url);

//System.setProperty("webdriver.chrome.driver","C:\\Users\\Student\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
//      WebDriverManager.chromedriver().setup();
//     WebDriver driver = new ChromeDriver();
		
		

		if (browsernames.equalsIgnoreCase("chrome")) {
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");  //we dont need to set property for web driver manger
		//	WebDriverManager.chromedriver().setup();
		//	driver = new ChromeDriver();
		driver =	WebDriverManager.chromedriver().create();     // this is for 5.3 version of webdriver manager library we added
            

		}

		else if (browsernames.equalsIgnoreCase("edge")) {

//System.setProperty("webdriver.edge.driver", "C:\\Users\\Student\\Downloads\\edgedriver_win32 (1)\\msedgedriver.exe");

			//WebDriverManager.edgedriver().setup();
		//	driver = new EdgeDriver();
		driver =	WebDriverManager.edgedriver().create();     // this is for 5.3 version of webdriver manager library we added
			
		}

		else {

//System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Student\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		//	WebDriverManager.firefoxdriver().setup();  --- this is for 4.43 version library we added so we need to write driver = new firefoxdriver.
		//	   driver = new FirefoxDriver();
	driver =	WebDriverManager.firefoxdriver().create();   // this is for 5.3 version of webdriver manager library we added. for 5.3, we dont need to write driver = new firefoxdriver.
			

		}

		driver.manage().window().maximize();

		Thread.sleep(5000);

		driver.get(url);

		String searchItem = "iphone 14";

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(5000);

		// validation step

		String appTitle = driver.getTitle();

		System.out.println("Application title after search item: " + appTitle);

		Assert.assertEquals("Amazon.in : iphone 14", appTitle);

		Assert.assertEquals("Amazon.in : " + searchItem, appTitle);

		System.out.println("Returned boolean value is: " +appTitle.contains(searchItem));

		Assert.assertTrue(appTitle.contains(searchItem));

		Thread.sleep(5000);

		driver.close();

	}

}
