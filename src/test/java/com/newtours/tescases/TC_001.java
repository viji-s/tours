package com.newtours.tescases;

import java.io.IOException;

import org.testng.annotations.Test;
import com.newtours.PageObjects.LoginPage;

import junit.framework.Assert;

public class TC_001 extends BaseClass {
	@Test(priority=1)
	public void test_Login() throws IOException  {
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("The username is set");	
		lp.setPassword(password);
		logger.info("The password is set");
		lp.btnClick();
		logger.info("The button is clicked");
		String exp = "Find a Flight: Mercury Tours:";
		System.out.println(exp);
		String act = driver.getTitle();
		System.out.println(act);
		captureScreen(driver, "test_Login");
		Assert.assertEquals(exp, act);
			}
	
}