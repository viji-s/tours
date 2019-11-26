package com.org.learningMaven.mavenProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class Newtest {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		//Taking screenshot of the webelement
		WebElement picture = driver.findElement(By.xpath(
				"//html//body//div//table//tbody//tr//td//table//tbody//tr//td//table//tbody//tr//td//table//tbody//tr//td//p//img"));
		System.out.println(picture.getRect().getDimension().getHeight());
		System.out.println(picture.getRect().getWidth());
		System.out.println(picture.getRect().getDimension().getWidth());
		System.out.println(picture.getSize());
		System.out.println(picture.getRect().x);
		System.out.println(picture.getRect().y);

		/*File file=picture.getScreenshotAs(OutputType.FILE);
		File destn=new File("logo.png");
		FileUtils.copyFile(file, destn);*/
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		String Exptitle = "Find a Flight: Mercury Tours:";
		String acttitle = driver.getTitle();
		if (Exptitle.equals(acttitle)) {
			Assert.assertTrue(true);
			System.out.println("The test is passed");
		} 
		else {
			Assert.assertTrue(false);
			System.out.println("The test case is failed");

		}
		
		driver.quit();
		System.getProperties();


	}

}
