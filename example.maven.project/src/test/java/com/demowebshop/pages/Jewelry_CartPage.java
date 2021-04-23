package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jewelry_CartPage {

	WebDriver driver;

	public Jewelry_CartPage(WebDriver rdriver) {
		this.driver = rdriver;
	}

	static By CartLink = By.xpath("//*[@id=\"topcartlink\"]/a/span[1]");

	static By productname = By.className("product-name");

	public void SetCartLink() {
		driver.findElement(CartLink).click();
	}
	
	public static By TextMsg = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1");
	
	public String TestVerify() {
		 String Gettitle = driver.findElement(TextMsg).getText();
		return Gettitle;
	}
	
	public static By Totalamount = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[6]/span[2]");
	
	public String Amount() {
		String Amt = driver.findElement(Totalamount).getText();
		return Amt;
	}
	
	static By EditLink = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div[2]/a");
	
	public void SetEditLink() {
		driver.findElement(EditLink).click();
	}
	
	public static By Verifyproductname = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[3]/a");
	
	public String getproductname() {
		String getproduct = driver.findElement(Verifyproductname).getText();
		return getproduct;
	}
	
	public static By termsofservice = By.name("termsofservice");
	
	public void SetTermsofservices() {
		driver.findElement(termsofservice).click();
	}
	
	public static By Checkoutbtn = By.name("checkout");
	
	public void Setcheckout() {
		driver.findElement(termsofservice).click();
	}
	

	

}