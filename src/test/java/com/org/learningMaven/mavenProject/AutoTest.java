package com.org.learningMaven.mavenProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

import junit.framework.Assert;

public class AutoTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	       driver.get("http://www.practiceselenium.com/practice-form.html");
	    driver.manage().window().maximize();
	    driver.findElement(By.name("firstname")).sendKeys("viji");
	    driver.findElement(By.name("lastname")).sendKeys("senthilkumar");
	   // driver.findElement(By.linkText("Welcome")).click();
	    Select se=new Select(driver.findElement(By.id("continents")));
	    System.out.println(se.getFirstSelectedOption().isSelected());
	     se.selectByVisibleText("North America");
	    driver.findElement(By.id("sex-1")).click();
	    driver.findElement(By.id("tea2")).click();
	    driver.findElement(By.id("submit")).click();
	    String exptitle="Welcome1";
	   // String acttitle=driver.getTitle();
	    try {
	    Assert.assertEquals(exptitle,driver.getTitle());
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	   // public void captureScreen(ITestResult result) {
	    	
	    
	    finally {
		    driver.close();

	    }
	    
	    		/*if(exptitle.equals(acttitle))
	    				{
	    Assert.assertTrue(true);
	    
	    		}
	    		else
	    			Assert.assetTrue(false);*/
    
	   // Thread.sleep(3000);
	    driver.close();
	    }

	
}
