package com.demowebshop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JweleryPage {

	WebDriver driver;
	
	static By JewelryLink = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a");
	
	static By SortBy = By.name("products-orderby");
	static By Display = By.name("products-pagesize");
	static By Grid = By.name("products-viewmode");
	//By PriceRange = By.linkText("500.00 - 700.00");
	static By ClickItem = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a");

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
	
	public void Clickjewelarylink() {
		
		driver.findElement(JewelryLink).click();
	}

	
	public void ItemLink() {
		driver.findElement(ClickItem).click();
	}
}
