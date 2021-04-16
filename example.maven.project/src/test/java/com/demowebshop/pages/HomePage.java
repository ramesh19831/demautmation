package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}
	// Page Object Creations
	
	By registerlink = By.cssSelector("a.ico-register");
	By loginlink = By.cssSelector("a.ico-login");
	
	
	//Page Methods
	public void clickRegisterLink(){
		driver.findElement(registerlink).click();
	}
	
	public void clickLoginLink() {
		driver.findElement(loginlink).click();
	}
}
