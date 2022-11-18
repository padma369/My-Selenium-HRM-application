package Excecise1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import ControlExample.BaseTest;

public class HandlingAlert extends BaseTest {

	@Test

	public void Alert() throws Exception {

		// allert with ok button only

		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();

		// SwitchTo ----- alert/window/frame
		// accept/dismiss/getText/sendkeys
		Alert simple_Alert = driver.switchTo().alert();
		Thread.sleep(4000);

		// validation
		String actualAlertText = simple_Alert.getText();
		System.out.println(actualAlertText);
		Assert.assertEquals("Hi.. This is alert message!", actualAlertText);
		Assert.assertTrue(actualAlertText.contains("alert message"));

		// simple_Alert.accept(); //click on Ok button
		simple_Alert.dismiss(); // click on cancel button ----- esc key from the keyboard
		
		
		

		////////////////////////////////////////////////////////////
        // alert with cancel button and ok buttons

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();

		Alert confirmAlert = driver.switchTo().alert();
		Thread.sleep(4000);

		// validation

		String actualAlertText1 = confirmAlert.getText();
		System.out.println(actualAlertText1);
		Assert.assertEquals("Press 'OK' or 'Cancel' button!", actualAlertText1);
		Assert.assertTrue(actualAlertText1.contains("'OK' or 'Cancel'"));

		confirmAlert.dismiss(); // click on cancel button ----- esc key

		// validation step

		String cancelLabel = driver.findElement(By.cssSelector("#demo")).getText();
		System.out.println(cancelLabel);
		Assert.assertTrue(cancelLabel.contains("Cancel"));

	}

}
