package com.demowebshop.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.base.BasePage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
/**
 * This is Register Page Scenarios automated with Valid and Invalid
 * @author Ramesh
 *
 */
public class TC02_RegisterTest extends BasePage{

	HomePage homePage;
	RegisterPage registerPage;
	
	@BeforeSuite
	public void invoke() {
		setup("http://demowebshop.tricentis.com/");
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
	}
	
	@DataProvider(name = "register")
	public Object[][] loginData() {
		return new Object[][] { { "Stephen", "Raj", "8768003768234@gmail.com", "Test@112","Test@112" },
			 };
	}
	
	@DataProvider(name = "Invalidregister")
	public Object[][] invalidRegister() {
		return new Object[][] { { "Stephen", "Raj", "8768003768234", "Test@112","Test@" ,"Wrong email","The password and confirmation password do not match."},
			 };
	}
	
	@Test(enabled = false, dataProvider = "register")
	public void TS01_VerifyRegisterWithValidData(String fname, String lname, String email, String pwd, String confpwd) {
		
		homePage.clickRegisterLink();
		registerPage.clickMaleRadioBtn();
		registerPage.enterFirstName(fname);
		registerPage.enterLastName(lname);
		registerPage.enterEmail(email);
		registerPage.enterPassword(pwd);
		registerPage.enterConfPwd(confpwd);
		registerPage.clickRegisterbtn();

	}

	@Test(dataProvider = "Invalidregister")
	public void TS02_VerifyRegisterWithInvaidData(String fname, String lname, String email, String pwd, String confpwd,
			String wrongemailmsg1, String pwdnotmatchmsg) throws InterruptedException{
		homePage.clickRegisterLink();
		registerPage.clickMaleRadioBtn();
		registerPage.enterFirstName(fname);
		registerPage.enterLastName(lname);
		registerPage.enterEmail(email);
		registerPage.enterPassword(pwd);
		registerPage.enterConfPwd(confpwd);
		registerPage.clickRegisterbtn();
		Thread.sleep(2000);
     	String	actualWrongEmailMsg = registerPage.getWrongEmailMsg();
		Assert.assertEquals(actualWrongEmailMsg, wrongemailmsg1);
		
	  	String	actualpwdnotmatchmsg = registerPage.getPasswordDoesntMatchMsg();
	   Assert.assertEquals(actualpwdnotmatchmsg, pwdnotmatchmsg);
	}
}
