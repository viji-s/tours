package com.newtours.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
     ldriver=rdriver;
     PageFactory.initElements(rdriver,this);
		}
	
	@FindBy(name="userName")
	WebElement txtusernam;
		
	@FindBy(name="password")
	WebElement txtpassword;
	
	@FindBy(name="login")
	WebElement btnlogin;
	
	public void setUserName(String Uname) {
		txtusernam.sendKeys(Uname);
	}
	
	public void setPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
		
		public void btnClick()  {
			btnlogin.click();
			btnlogin.click();

			
		}
	}
	
	


