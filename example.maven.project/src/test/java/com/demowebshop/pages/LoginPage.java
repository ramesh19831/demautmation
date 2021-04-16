package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String pageUrl() {
		return driver.getCurrentUrl();
	}
}
