package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JweleryPage {
	
	WebDriver driver;
	
	By pendentTyperb = By.xpath("//*[contains(@for,'product_attribute')] ");
	
	
	public JweleryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public String getTitle() {

		return driver.getTitle();
	}
	
	public String pageUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public void clickPendantRadioBtn(String value) {
		List<WebElement> rdbtn = driver.findElements(pendentTyperb);
		for (WebElement webElement : rdbtn) {
			if (webElement.getText().equals(value)) {
				webElement.click();
			}
		}
	}
	
	
}
