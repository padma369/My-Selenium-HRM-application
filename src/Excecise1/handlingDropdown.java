package Excecise1;

import org.junit.Assert;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import ControlExample.BaseTest;

public class handlingDropdown extends BaseTest {

	 @Test

	public void dropdown_mul_test() throws Exception {
		 
		 
		 //dorpdown selection with multiple values
		 
		 // is multiple is for: to check that dropdown is allowing the multiple values are not.
		
		
		WebElement list1 = driver.findElement(By.tagName("select"));
		Select sel1 = new Select(list1);
		System.out.println("is multiple selectionare enabled or not: " + sel1.isMultiple());   //is multiple is not allowed. so it will give false.
		Assert.assertFalse(sel1.isMultiple()); // false    // we are giving false so assertfalse we are using. so the condition will pass

		Thread.sleep(2000);
		sel1.selectByIndex(1); // Saab

		Thread.sleep(2000);
		sel1.selectByValue("Singapore"); // Opel

		Thread.sleep(2000);
		sel1.selectByVisibleText("Toyota"); // Toyota
		
		
		Thread.sleep(3000);
		
		/////////////////////////////////////////////////////////
		
		//Dropdown is with single value acceptance

		WebElement list = driver.findElement(By.cssSelector("select[name='FromLB']"));
		Select sel = new Select(list);
		System.out.println("is multiple selectionare enabled or not: " + sel.isMultiple());
		Assert.assertTrue(sel.isMultiple());

		Thread.sleep(2000);
		sel.selectByIndex(0); // USA
		Thread.sleep(2000);
		sel.selectByIndex(1); // Russia
		
		Thread.sleep(2000);		
		sel.selectByValue("India"); // India

		Thread.sleep(2000);
		sel.selectByVisibleText("Germany"); // Germany

		Thread.sleep(4000);
		sel.deselectAll();

		sel.selectByValue("India");
		sel.selectByVisibleText("Germany");
		sel.selectByIndex(0);

		Thread.sleep(4000);
		sel.deselectByVisibleText("Germany");
		sel.deselectByIndex(0);
		
		
		



	}

}
