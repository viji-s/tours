package com.newtour.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MT_004 extends BaseClass{
	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
		super.setUp(br);
		logger.info("the setup method is called");
	}
	@Test
	public void hotelReservation() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Hotels')]")).click();
		WebElement text=driver.findElement(By.xpath("//body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/p/font/b/font[1]"));
		String act_text=text.getText();
		Assert.assertTrue(act_text.contains("under construction"));
		logger.info("Hotel reservation Assertion is success");
	}
     @AfterTest
	public void tearDown() {
		super.tearDown();
	}
}
