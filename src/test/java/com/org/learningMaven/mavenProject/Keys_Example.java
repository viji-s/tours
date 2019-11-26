package com.org.learningMaven.mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Keys_Example {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	       driver.get("http://www.google.com");
	    driver.manage().window().maximize();
	    WebElement serach=driver.findElement(By.name("q"));
	    serach.sendKeys("Billgates");
	    serach.sendKeys(Keys.ENTER);
	}
	

}
