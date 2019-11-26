package com.newtours.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()  {
		File src = new File("./Configuration//config.properties");
				try {
					FileInputStream fi = new FileInputStream(src);
					pro = new Properties();
			pro.load(fi);
		} catch (Exception e) {

			System.out.println("The exception is:" + e.getMessage());
		}

	}

	public String getURL() {
		String url = pro.getProperty("BaseURL");
		return url;

	}

	public String getUserName() {
		String usrname = pro.getProperty("username");
		return usrname;

	}

	public String getPassword() {
		String paswrd = pro.getProperty("password");
		return paswrd;
	}

	public String getChromePath() {
		String Chrome = pro.getProperty("chromepath");
		return Chrome;
	}

	public String getFireFoxPath() {
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
	}
}

