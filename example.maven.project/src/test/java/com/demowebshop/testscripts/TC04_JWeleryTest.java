package com.demowebshop.testscripts;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.base.BasePage;
import com.demowebshop.pages.Jewelry_Black_White_Diamond_HearatPage;
import com.demowebshop.pages.Jewelry_CartPage;
//import com.demowebshop.base.BasePage;
//import com.demowebshop.basePage.BasePage;
//import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.JweleryPage;
//import com.demowebshop.pages.RegisterPage;

public class TC04_JWeleryTest extends BasePage {

	// HomePage homePage;
	// RegisterPage registerPage;
	JweleryPage JewelaryPage;
	Jewelry_Black_White_Diamond_HearatPage BlackWhiteDiamondPage;
	Jewelry_CartPage CartPage;

	@BeforeSuite
	public void invoke() {
		setup("http://demowebshop.tricentis.com/");
		// homePage = new HomePage(driver);
		// registerPage = new RegisterPage(driver);
		JewelaryPage = new JweleryPage(driver);
		BlackWhiteDiamondPage = new Jewelry_Black_White_Diamond_HearatPage(driver);
		CartPage = new Jewelry_CartPage(driver);
	}

	@Test
	public void TC001_VerifytheJewelaryProducts() {
		
		test = extent.createTest("TC001_Validate the Demo Web Shop_Jewelry Prodcuts in Jewelay page");
		test.log(Status.PASS, "Click on Jewelry Link");
		JewelaryPage.Clickjewelarylink();

	}

	@Test
	public void TC002_VerifytheSelectedProducts() {

	}
	
	@Test
	public void TC003_VerifytheProductsinCart() {
		
	}
}
