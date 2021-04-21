package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JweleryPage {

	WebDriver driver;
	By JewelryLink = By.tagName("a");
	By pendentTyperb = By.xpath("//*[contains(@for,'product_attribute')] ");
	By SelectItem = By.xpath("//img[@alt='Picture of Black & White Diamond Heart']");

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
	
	public void Clickjewelarylink() {
		driver.findElement(JewelryLink).click();
	}

}
