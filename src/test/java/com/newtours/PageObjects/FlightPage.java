package com.newtours.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightPage {
	
	WebDriver ldriver;
	public FlightPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath="//input[contains(@value,'roundtrip')]")
	WebElement radbut1;
	
	@FindBy(name="passCount")
	WebElement pngrdrop;
	
	@FindBy(name="fromPort")
	WebElement depfrom;
	
	@FindBy(name="fromMonth")
	WebElement frommonth;
	
	@FindBy(name="fromDay")
	WebElement fromday;
	
	@FindBy(name="toPort")
	WebElement toport;
	
	@FindBy(name="toMonth")
	WebElement tomonth;
	
	@FindBy(name="today")
	WebElement today;
	
	
	
}
