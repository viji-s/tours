package com.newtour.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MT_003 extends BaseClass {

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
		super.setUp(br);
		logger.info("The setup method is called");
	}

	@Test
	public void cruises() {
		logger.info("the page is opened");
		String startday = "Sat";
		String startport = "Seattle";
		String endday = "Sat";
		String endport = "Seattle";

		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[5]/td[2]/a[1]"))
				.click();
		String exp_title = "Cruises: Mercury Tours";
		String act_title = driver.getTitle();
		System.out.println(act_title);
		Assert.assertEquals(exp_title, act_title);
		logger.info("The title is matched");

		WebElement day1 = driver.findElement(By.xpath("//body//tr//tr//tr//tr//tr//tr[4]/td[1]"));
		String d1 = day1.getText();
		System.out.println(d1);
		Assert.assertEquals(d1, startday);
		logger.info("The start day is verified");

		WebElement port1 = driver.findElement(By.xpath("//body//tr//tr//tr//tr//tr//tr[4]/td[2]"));
		String p1 = port1.getText();
		System.out.println(p1);
		Assert.assertEquals(p1, startport);
		logger.info("The start port is verified");

		WebElement day2 = driver.findElement(By.xpath("//body//tr//tr//tr//tr//tr//tr[11]/td[1]"));
		String e1 = day2.getText();
		System.out.println(e1);
		Assert.assertEquals(e1, endday);
		logger.info("The end day is verified");

		WebElement port2 = driver.findElement(By.xpath("//body//tr//tr//tr//tr//tr//tr[11]/td[2]"));
		String p2 = port2.getText();
		System.out.println(p2);
		Assert.assertEquals(p2, endport);
		logger.info("The end port is verified");

	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
		logger.info("the tear down method is calld");

	}

}
