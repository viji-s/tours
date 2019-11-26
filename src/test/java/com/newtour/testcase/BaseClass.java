package com.newtour.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public WebDriver driver;
	public static Logger logger;
	String BaseUrl = "http://newtours.demoaut.com/";

	@Parameters("browser")
	@BeforeTest
	public void setUp(String br) {
		System.out.print("base class setup called");
		logger = Logger.getLogger("mavenProject");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers//chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("The chrome browser is opened");
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("The firefox browser is opened");
		}
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
