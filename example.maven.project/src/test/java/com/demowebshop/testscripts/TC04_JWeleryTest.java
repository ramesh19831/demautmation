package com.demowebshop.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.base.BasePage;
import com.demowebshop.pages.Jewelry_Items_Page;
import com.demowebshop.pages.Jewelry_CartPage;
import com.demowebshop.pages.JweleryPage;

public class TC04_JWeleryTest extends BasePage {

	JweleryPage JewelaryPage;
	Jewelry_Items_Page ItemsPage;
	Jewelry_CartPage CartPage;

	@BeforeSuite
	public void invoke() {
		setup("http://demowebshop.tricentis.com/");

		JewelaryPage = new JweleryPage(driver);
		ItemsPage = new Jewelry_Items_Page(driver);
		CartPage = new Jewelry_CartPage(driver);
	}

	@Test
	public void TC001_VerifytheJewelaryProducts() throws InterruptedException {

		test = extent.createTest("TC001_Validate the Demo Web Shop_Jewelry Prodcuts in Jewelay page");
		test.log(Status.PASS, "Click on Jewelry Link");
		JewelaryPage.Clickjewelarylink();

		test.log(Status.PASS, "Click on Create your own jewelary item");
		JewelaryPage.ItemLink();

		test.log(Status.PASS, "Select the value form drop down");
		ItemsPage.MaterialDropDown(1);

		test.log(Status.PASS, "Enter the Length of in centimeters");
		ItemsPage.SetLengthInCM();

		test.log(Status.PASS, "Select the Heart radio button");
		ItemsPage.clickPendantRadioBtn("Heart");
		Thread.sleep(2000);
		
		test.log(Status.PASS, "Enter the quantity value");
		ItemsPage.SetQuantity();
		Thread.sleep(2000);
		
		test.log(Status.PASS, "Click on AddCart button");
		ItemsPage.SetCartbtn();

		test.log(Status.PASS, "Click on the Shopping Cart link from menu bar");
		CartPage.SetCartLink();

		test.log(Status.PASS, "Verify the Shopping Cart message after alick on shoppingCart link");
		Assert.assertEquals(CartPage.TestVerify(), "Shopping cart");
		Thread.sleep(2000);
		
		test.log(Status.PASS, "Verify the product we added in cart");
		Assert.assertEquals(CartPage.getproductname(), "Create Your Own Jewelry" );
		Thread.sleep(2000);
//		test.log(Status.PASS, "Verify the amount of product what we added in cart");
//		Assert.assertEquals(Jewelry_CartPage.Totalamount, CartPage.Amount());

		test.log(Status.PASS, "Select the Terms and Conditions check box");
		CartPage.SetTermsofservices();
		Thread.sleep(2000);
		test.log(Status.PASS, "Click on CheckOut button");
		CartPage.Setcheckout();
		Thread.sleep(2000);
	}

	@AfterSuite
	public void closeBrowser() {
		test.log(Status.PASS, "Closing the Browser");

		extent.flush();
		driver.close();
	}

}
