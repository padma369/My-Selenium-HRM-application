package Excecise1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HRM_Login_Chrome {


@Test

public void verifyLoginLogoutTest() throws Exception {
 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Student\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
  WebDriver driver = new ChromeDriver();
 driver.manage().window().maximize();
 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");           // REST API --- api ---- data
 Thread.sleep(5000);

    //Identification
  //Name - UserName
 WebElement txt_UserName = driver.findElement(By.name("username"));                  //unique 
 
 //action
  txt_UserName.sendKeys("Admin");
 System.out.println("Tagname of username field: " +txt_UserName.getTagName());
 System.out.println("Placeholder of username field: " + txt_UserName.getAttribute("placeholder"));
  //name - password
 driver.findElement(By.name("password")).sendKeys("admin123");
 //Tagname
//click on Login button
driver.findElement(By.tagName("button")).click();

 //validation Step
 //click on user dropdown element 
 //Class - oxd-userdropdown-name
 driver.findElement(By.className("oxd-userdropdown-name")).click();
 Thread.sleep(5000); 

// linkText
//  driver.findElement(By.linkText("Logout")).click();
//linkText
 driver.findElement(By.partialLinkText("Logo")).click();

  //validation Step
 Thread.sleep(5000);   //hard-coded delay
 driver.close();

   

}

}




