package com.newtour.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MT_002 extends BaseClass {

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
		super.setUp(br);
		logger.info("setup called");
	}

	@Test
	public void FindFlight() {
		WebElement radbtn = driver.findElement(By.xpath("//input[contains(@value,'roundtrip')]"));
		if (radbtn.isDisplayed() && radbtn.isEnabled() && radbtn.isSelected()) {
			logger.info("Round tripradio button is selcted by default");
		} else {
			logger.info("Select the round trip radio button");
			radbtn.click();
		}
		// passenger selection
		WebElement psndrop = driver.findElement(By.name("passCount"));
		Select passengers = new Select(psndrop);
		logger.info("Select the no.of passenger");
		passengers.selectByVisibleText("4");

		// Depart from selected
		WebElement depfrom = driver.findElement(By.name("fromPort"));
		Select deprtfrom = new Select(depfrom);
		deprtfrom.selectByValue("San Francisco");
		logger.info("select the depart loc");

		// Departing month
		Select depmont = new Select(driver.findElement(By.name("fromMonth")));
		depmont.selectByValue("12");
		logger.info("select the depart month");

		// Departing date
		Select depdat = new Select(driver.findElement(By.name("fromDay")));
		depdat.selectByVisibleText("15");
		logger.info("select the dpt date");

		// Arriving location
		Select arrloc = new Select(driver.findElement(By.name("toPort")));
		arrloc.selectByIndex(3);
		logger.info("select the arrivin loc");

		// Returning month
		Select tomonth = new Select(driver.findElement(By.name("toMonth")));
		tomonth.selectByVisibleText("January");
		logger.info("select the ret month");

		// Returning date
		Select to_day = new Select(driver.findElement(By.name("toDay")));
		to_day.selectByVisibleText("1");
		logger.info("select the ret date");

		// Selecting the business class
		WebElement business = driver.findElement(By.xpath("//*[@value='Business']"));
		if (business.isDisplayed() && business.isEnabled() && business.isSelected()) {
			logger.info("business class is selected");
			System.out.println("The business class is selected");
		} else {
			if (business.isDisplayed() && business.isEnabled()) {
				logger.info("click the business class");
				business.click();
			}

		}

		// Selecting the airline
		Select airline = new Select(driver.findElement(By.name("airline")));
		airline.selectByVisibleText("Unified Airlines");
		logger.info("airline is selected");
		// clicking the continue button

		driver.findElement(By.xpath("//input[@name='findFlights']")).click();
		String pagetext = driver.findElement(By.xpath("//td[@class='title']//font[contains(text(),'DEPART')]"))
				.getText();
		logger.info("The text is querired");
		Assert.assertEquals("DEPART", pagetext);

		// Depart flight
		WebElement dep_flight = driver.findElement(By.xpath("//input[@value='Pangea Airlines$362$274$9:17']"));
		if (dep_flight.isDisplayed() && dep_flight.isEnabled() && dep_flight.isSelected()) {
			logger.info("The departure fligt is selected");
		} else {
			logger.info("Select the depart flight");
			dep_flight.click();
		}

		// Return flight
		WebElement arr_flight = driver.findElement(By.xpath("//input[@value='Pangea Airlines$632$282$16:37']"));
		if (arr_flight.isDisplayed() && arr_flight.isEnabled() && arr_flight.isSelected()) {
			logger.info("The arrival fligt is selected");
		} else {
			logger.info("Select the arrival flight");
			arr_flight.click();
		}

		// click continue
		driver.findElement(By.name("reserveFlights")).click();
		logger.info("The continue button is clicked");

		// passenger info
		driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("viji");
		driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("senthilkumar");
		Select meal = new Select(driver.findElement(By.xpath("//select[@name='pass.0.meal']")));
		meal.selectByValue("HNML");
		logger.info("The mel is selected");

		// card info

		Select card = new Select(driver.findElement(By.xpath("//select[@name='creditCard']")));
		String cardname = card.getFirstSelectedOption().getText();
		if (card.getFirstSelectedOption().isDisplayed() && card.getFirstSelectedOption().isEnabled()
				&& card.getFirstSelectedOption().isSelected()) {
			if (cardname.equals("Visa")) {
				logger.info("The card is selcted");
			}
		} else {
			card.selectByValue("BA");
			logger.info("The card is selected");

		}

		WebElement cardnumber = driver.findElement(By.xpath("//input[@name='creditnumber']"));
		cardnumber.sendKeys("123456789123456");
		logger.info("The creadit number is entered");

		Select expiry_month = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']")));
		expiry_month.selectByVisibleText("09");
		logger.info("expiration month is set");

		Select expiry_year = new Select(driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']")));
		expiry_year.selectByVisibleText("2010");
		logger.info("The expiration year is set");

		// Billing info
		WebElement address = driver.findElement(By.xpath("//input[@name='billAddress1']"));
		address.clear();
		address.sendKeys("760 buroak ave markham");
		logger.info("The address is given");

		WebElement city = driver.findElement(By.xpath("//input[@name='delCity']"));
		city.clear();
		city.sendKeys("markham");
		logger.info("he city is set");

		WebElement state = driver.findElement(By.xpath("//input[@name='delState']"));
		state.clear();
		state.sendKeys("canada");
		logger.info("The state is set");

		WebElement zip = driver.findElement(By.xpath("//input[@name='delZip']"));
		zip.clear();
		zip.sendKeys("MR 004r");
		logger.info("The Pin code is set");

		Select country = new Select(driver.findElement(By.xpath("//select[@name='delCountry']")));
		country.selectByVisibleText("CANADA");
		logger.info("The country is set");

		driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
		logger.info("The secure purhase button is clicked");
		String currenturl = "http://newtours.demoaut.com/mercurypurchase.php";
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(currenturl, driver.getCurrentUrl());

	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
		logger.info("the tear down method is calld");

	}

}
