package Excecise1;

import org.junit.Assert;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import Utility.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathExercise {

	WebDriver driver;

	@Test

	public void verifySearchFeature() throws Exception {

		// create an object

		ConfigRead conf = new ConfigRead();
		String browser = conf.getBrowser();
		String url = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
		String urlsecond = "http://only-testing-blog.blogspot.com/2013/11/new-test.html";
		System.out.println("Browser Execution : " + browser);
		System.out.println("App URL : " + url);
		
		driver = WebDriverManager.chromedriver().create(); 
		//driver = new ChromeDriver();

		driver.manage().window().maximize();

		Thread.sleep(3000);
		driver.get(url);
		

		Thread.sleep(3000);
		WebElement UserName = driver.findElement(By.cssSelector("input[id*='Email']"));
		WebElement Password = driver.findElement(By.cssSelector("input[id*='Password']"));
		WebElement RemembermeCheckbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement LoginButton = driver.findElement(By.xpath("//button[@type='submit']"));

		
		UserName.clear();
		UserName.sendKeys("admin@yourstore.com");
		Password.clear();
		Password.sendKeys("admin");

		Thread.sleep(3000);

		RemembermeCheckbox.click();
		Thread.sleep(3000);
        LoginButton.click();
        
        
		Thread.sleep(5000);
		WebElement CustomersMenu = driver.findElement(By.xpath("//i[@class='nav-icon far fa-user']"));
		CustomersMenu.click();
		WebElement Customersoption = driver.findElement(By.xpath("//p[text()=' Customers']"));
		Customersoption.click();

		Thread.sleep(3000);
		WebElement PageHeader = driver.findElement(By.xpath("//h1[@class='float-left']"));

		// validation step
		String appTitle = driver.getTitle();
		System.out.println("Application title after search item: " + appTitle);
		Assert.assertEquals("Customers / nopCommerce administration", appTitle);		
		Assert.assertTrue(appTitle.contains("Customers"));
		System.out.println(appTitle.contains("Customers"));
		
		String Customersheader = PageHeader.getText();
		System.out.println("Page header for customers page is: " + Customersheader);
		Assert.assertEquals("Customers", Customersheader);

		Thread.sleep(5000);
		String Expectedurl = "https://admin-demo.nopcommerce.com/Admin/Customer/List";
		String currenturl = driver.getCurrentUrl();
		System.out.println("Customers page url is: " + currenturl);
		Assert.assertEquals(Expectedurl, currenturl);

		Thread.sleep(3000);
//		driver.close();
		
		
		///////////////////////////////////////////////////
		

//		WebDriverManager.chromedriver().create(); 
//		driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();

		driver.get(urlsecond);
		
		WebElement bikecheckbox = driver.findElement(By.cssSelector("input[value*='Bike']"));
		WebElement Femaleradiobutton = driver.findElement(By.cssSelector("input[value*='female']"));
		
		bikecheckbox.click();
		Femaleradiobutton.click();
		
		Thread.sleep(3000);
		driver.close();
		

	}

}
