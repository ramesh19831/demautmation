package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Jewelry_Items_Page {

	WebDriver driver;

	public Jewelry_Items_Page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	static By Cartbtn = By.id("add-to-cart-button-71");

	static By Material = By.name("product_attribute_71_9_15");

	static By LengthInCM = By.id("product_attribute_71_10_16");

	static By pendentTyperb = By.xpath("//*[contains(@for,'product_attribute')] ");

	static By Quantity = By.className("qty-input");

	public void MaterialDropDown(int index) {
		WebElement Mat = driver.findElement(Material);
		Select drop = new Select(Mat);
		drop.selectByIndex(1);
	}

	public void SetLengthInCM() {
		driver.findElement(LengthInCM).sendKeys("10");
	}

	public void clickPendantRadioBtn(String value) {

		List<WebElement> rdbtn = driver.findElements(pendentTyperb);
		for (WebElement webElement : rdbtn) {
			if (webElement.getText().equals(value)) {
				webElement.click();
			}
		}
	}

	public void SetQuantity() {
		driver.findElement(Quantity).clear();
		driver.findElement(Quantity).sendKeys("2");
	}
	
	public void SetCartbtn() {
		driver.findElement(Cartbtn).click();
	}

}
