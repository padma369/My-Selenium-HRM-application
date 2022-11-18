package Excecise1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ControlExample.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxUsingRuto extends BaseTest {
	
	@Test

    public void handleCheckbox() throws InterruptedException {



        System.out.println("handle checkbox...");
        
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();
     
        driver.findElement(By.xpath("//input[@value='Bike']")).click();
        
        driver.findElement(By.xpath("//form[@name='combo_box' ]//table/tbody[1]/tr[1]/td[1]/select[1]/option[3]")).click();
        
       

    }



}




