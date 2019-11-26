package com.newtours.tescases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.newtours.utils.ReadConfig;

public class BaseClass {
	ReadConfig read = new ReadConfig();
	String Url = read.getURL();
	public String username = read.getUserName();
	public String password = read.getPassword();
	public static Logger logger;
	public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("mavenProject");
		PropertyConfigurator.configure("log4j.properties");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			driver = new ChromeDriver();
			logger.info("The chrome browser is opened");
					}
		
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFireFoxPath());
			driver = new FirefoxDriver();
			logger.info("The firefox browser is opened");
		}

		// driver.get("http://newtours.demoaut.com/");
		// logger.info("the Website is opened");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("The website is closed");

	}
	
	public void captureScreen(WebDriver driver, String testname) throws IOException {
		TakesScreenshot picture = (TakesScreenshot) driver;
		File source = picture.getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("YYYY-MM-DD-HH.mm.ss").format(new Date());
		File destination = new File(System.getProperty("user.dir") + "/screenshot/" + testname +" "+timestamp +".png");
		FileUtils.copyFile(source, destination);

	}

}