package com.demowebshop.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.demowebshop.base.BasePage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;

/**
 * This is Register Page Scenarios automated with Valid and Invalid
 * 
 * @author Ramesh
 *
 */
public class TC02_RegisterTest extends BasePage {

	HomePage homePage;
	RegisterPage registerPage;

//	@BeforeSuite
//	public void invoke() {
//		setup("http://demowebshop.tricentis.com/");
//		homePage = new HomePage(driver);
//		registerPage = new RegisterPage(driver);
//	}

	@DataProvider(name = "register", parallel = true)
	public Object[][] loginData() {
		return new Object[][] { { "Stephen", "Raj", "test", "Test@112", "Test@112" }, };
	}

	@DataProvider(name = "Invalidregister",  parallel = true)
	public Object[][] invalidRegister() {
		return new Object[][] { { "Stephen", "Raj", "8768003768234", "Test@112", "Test@", "Wrong email",
				"The password and confirmation password do not match." }, };
	}

	@DataProvider(name = "EmptyData",  parallel = true)
	public Object[][] EmptyData() {
		return new Object[][] { { "First name is required.", "Last name is required.", "Email is required.", 
			"Password is required.", "Password is required." }, };
	}

	@Test(enabled = false, dataProvider = "register")
	public void TS01_VerifyRegisterWithValidData(String fname, String lname, String email, String pwd, String confpwd)
			throws InterruptedException {
		test = extent.createTest("TC01_Validate the Demo Web Shop RegistrationScreen with Valid Data");
		test.log(Status.PASS, "Click on Register Link");
		homePage.clickRegisterLink();
		test.log(Status.PASS, "Click on Male Radio button");
		registerPage.clickMaleRadioBtn();
		test.log(Status.PASS, "Enter the First Name : " + fname);
		registerPage.enterFirstName(fname);
		test.log(Status.PASS, "Enter the Last Name : " + lname);
		registerPage.enterLastName(lname);
		email = email + randomNumber() + "@gmail.com";
		test.log(Status.PASS, "Enter the Email Address : " + email);
		registerPage.enterEmail(email);
		test.log(Status.PASS, "Enter the Password  : " + pwd);
		registerPage.enterPassword(pwd);
		test.log(Status.PASS, "Enter the Confirm Passwd : " + confpwd);
		registerPage.enterConfPwd(confpwd);
		test.log(Status.PASS, "Click on Register Button");
		registerPage.clickRegisterbtn();

		registerPage.clickLogout();

	}

	@Test(enabled = false, dataProvider = "Invalidregister")
	public void TS02_VerifyRegisterWithInvaidData(String fname, String lname, String email, String pwd, String confpwd,
			String wrongemailmsg1, String pwdnotmatchmsg) throws InterruptedException {
		Thread.sleep(1000);
		test = extent.createTest("TC02_Validate the Demo Web Shop RegistrationScreen with Invalid Data");
		test.log(Status.PASS, "Click on Register Link");
		homePage.clickRegisterLink();
		test.log(Status.PASS, "Click on Male Radio button");
		registerPage.clickMaleRadioBtn();
		test.log(Status.PASS, "Enter the First Name : " + fname);
		registerPage.enterFirstName(fname);
		test.log(Status.PASS, "Enter the Last Name : " + lname);
		registerPage.enterLastName(lname);
		test.log(Status.PASS, "Enter the Email Address : " + email);
		registerPage.enterEmail(email);
		test.log(Status.PASS, "Enter the Password  : " + pwd);
		registerPage.enterPassword(pwd);
		test.log(Status.PASS, "Enter the Confirm Passwd : " + confpwd);
		registerPage.enterConfPwd(confpwd);
		test.log(Status.PASS, "Click on Register Button");
		registerPage.clickRegisterbtn();
		Thread.sleep(2000);
		String actualWrongEmailMsg = registerPage.getWrongEmailMsg();
		Assert.assertEquals(actualWrongEmailMsg, wrongemailmsg1);
		test.log(Status.PASS, "Wrong Email Address is : " + wrongemailmsg1);
		String actualpwdnotmatchmsg = registerPage.getPasswordDoesntMatchMsg();

		Assert.assertEquals(actualpwdnotmatchmsg, pwdnotmatchmsg);
		test.log(Status.PASS, "Password not macth : " + pwdnotmatchmsg);
	}

	@Test(dataProvider = "EmptyData")
	public void TS02_VerifyRegisterWithEmptyData(String Errormsgfirstname, String Errormsglastname,
			String Errormsgemail, String Errormsgpassword, String ErrormsgconfPwd) throws InterruptedException {
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		Thread.sleep(1000);
		test = extent.createTest("TC02_Validate the Demo Web Shop RegistrationScreen with Empty Data");

		test.log(Status.PASS, "Click on Register Link");
		homePage.clickRegisterLink();

		test.log(Status.PASS, "Click on Register Button");
		registerPage.clickRegisterbtn();
		Thread.sleep(2000);

		test.log(Status.PASS, "Verify First name error mesgae : " + Errormsgfirstname);
		Assert.assertEquals(Errormsgfirstname, registerPage.FirstnameErrorMsg());

		test.log(Status.PASS, "Verify Last name error mesgae :  " + Errormsglastname);
		Assert.assertEquals(Errormsglastname, registerPage.LastnameErrorMsg());

		test.log(Status.PASS, "Verify Email error mesgae :  " + Errormsgemail);
		Assert.assertEquals(Errormsgemail, registerPage.EmailErrorMsg());

		test.log(Status.PASS, "Verify Password error mesgae :  " + Errormsgpassword);
		Assert.assertEquals(Errormsgpassword, registerPage.PasswordErrorMsg());

		test.log(Status.PASS, "Verify Confirm Password error mesgae :  " + ErrormsgconfPwd);
		Assert.assertEquals(ErrormsgconfPwd, registerPage.ConfirmPwdErrorMsg());
   	
	}

	@AfterSuite
	public void closeBrowser() {
		test.log(Status.PASS, "Closing the Browser");
		extent.flush();
	}
}
