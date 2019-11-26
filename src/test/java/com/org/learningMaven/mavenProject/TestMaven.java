package com.org.learningMaven.mavenProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestMaven {

	public static void main(String[] args) throws InterruptedException {
		Logger logger;
		logger=Logger.getLogger("TestMaven");
		PropertyConfigurator.configure("log4j.properties");
    System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.get("http://www.practiceselenium.com/practice-form.html");
    logger.info("The website is opened");
    driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("viji");
    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("senthil");
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    Actions act=new Actions(driver);
    act.sendKeys(Keys.CONTROL+"a").build().perform();
    
    act.doubleClick();
     WebElement list=driver.findElement(By.id("continents"));
    Select se=new Select(list);
    
    /*se.selectByVisibleText("Asia");
    List originalistcountry=new ArrayList();
    List<WebElement>countries=se.getOptions();
    for(WebElement e:countries) {
    	System.out.println(originalistcountry.add(e.getText()));
    	System.out.println(originalistcountry);
    }*/
    
       
        //driver.close();
   // logger.info("The websiteis closed");
	}

}
