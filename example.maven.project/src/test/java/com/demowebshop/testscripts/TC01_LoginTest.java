package com.demowebshop.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.basePage.BasePage;

/**
 * Login Page Scenarios
 * @author Ramesh
 *
 */
public class TC01_LoginTest extends BasePage{

	@BeforeClass /// this is pre-condition - not a test or scenarios
	public void setupMethod() {
//		1. Open the Chrome Browser
//		2. Navigate to Demo web shop url
		setup("http://demowebshop.tricentis.com/");
	}

	@DataProvider(name = "login")
	public Object[][] loginData() {
		return new Object[][] { { "Demo Web Shop", "Demo Web Shop. Login", "8768768234@gmail.com", "Test@112" },
				{ "Demo Web Shop", "Demo Web Shop. Login", "stephenHok@gmail.com", "Gmail@112" },
				{ "Demo Web Shop", "Demo Web Shop. Login", "Billgates@yahoo.com", "Yahoo@112" }, };
	}

	@Test(dataProvider = "login")
	public void LoginDemoWebShopWithDataProviderWithStandardCode(String homePageTitle, String loginPageTitle,
			String emailaddress, String password) throws InterruptedException {
//		3. Verify the title of the home Page "Demo Web Shop"
		String actualHomePageTitle = Title();
		Assert.assertEquals(actualHomePageTitle, homePageTitle);
//		4. Click on Login link
		click(By.className("ico-login"));

		Thread.sleep(1000);
//		5. Verify the Title of Login pAge  " Demo Web Shop. Login"
		String loginPageActualTitle = Title();
		Assert.assertEquals(loginPageActualTitle, loginPageTitle);

//		6. Enter the valid Login credentials with username and password
		type(By.id("Email"), emailaddress);
		Thread.sleep(1000);
		type(By.id("Password"), password);

//		7. Click on Login button
		click(By.cssSelector("input.button-1.login-button"));
		
		Thread.sleep(1000);
//		8. Verify the Successfull message after Login
		String loginAccount = driver.findElement(By.cssSelector("div.header-links ul li a.account")).getText();
		Assert.assertEquals(loginAccount, emailaddress);
		click(By.className("ico-logout"));
		
		Thread.sleep(2000);
	}

	
	@Test
	public void LoginwithInvalidData() {
		System.out.println("Login with invalid Credentials");
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	

}
