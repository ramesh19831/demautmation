package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String pageUrl() {
		return driver.getCurrentUrl();
	}

	// Page Objects
	static By gendermalerb = By.id("gender-male");
	static By firstnametxt = By.id("FirstName");
	static By lastnametxt = By.id("LastName");
	static By emailtxt = By.id("Email");
	static By passwordtxt = By.id("Password");
	static By confpwdtxt = By.id("ConfirmPassword");
	static By registerbtn = By.id("register-button");
	static By logout = By.cssSelector("a.ico-logout");

	static By wrongemailmsg = By.xpath("//span[@for='Email']");
	static By passwordnotmatchmsg = By.xpath("//span[@for='ConfirmPassword']");

	static By firstnameErrormsg = By.xpath("//span[@for='FirstName']");
	static By lastnameErrormsg = By.xpath("//span[@for='LastName']");
	static By emailErrormsg = By.xpath("//span[@for='Email']");
	static By passwordErrormsg = By.xpath("//span[@for='Password']");
	static By confPwdErrormsg = By.xpath("//span[@for='ConfirmPassword']");

	public void clickMaleRadioBtn() {
		driver.findElement(gendermalerb).click();
	}

	public void enterFirstName(String fname) {
		driver.findElement(firstnametxt).sendKeys(fname);
	}

	public void enterLastName(String lname) {
		driver.findElement(lastnametxt).sendKeys(lname);
	}

	public void enterEmail(String email) {
		driver.findElement(emailtxt).sendKeys(email);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordtxt).sendKeys(pwd);
	}

	public void enterConfPwd(String cfpwd) {
		driver.findElement(confpwdtxt).sendKeys(cfpwd);
	}

	public void clickRegisterbtn() {
		driver.findElement(registerbtn).click();
	}

	public String getWrongEmailMsg() {
		return driver.findElement(wrongemailmsg).getText();
	}

	public String getPasswordDoesntMatchMsg() {
		return driver.findElement(passwordnotmatchmsg).getText();
	}

	public void clickLogout() {
		driver.findElement(logout).click();
	}

	public String FirstnameErrorMsg() {

		String FErroeMsg = driver.findElement(firstnameErrormsg).getText();
		return FErroeMsg;
	}

	public String LastnameErrorMsg() {
		String LErrorMsg = driver.findElement(lastnameErrormsg).getText();
		return LErrorMsg;
	}

	public String EmailErrorMsg() {
		String EErrorsg = driver.findElement(emailErrormsg).getText();
		return EErrorsg;
	}

	public String PasswordErrorMsg() {
		String PErrorMsg = driver.findElement(passwordErrormsg).getText();
		return PErrorMsg;
	}

	public String ConfirmPwdErrorMsg() {
		String CPErrorMsg = driver.findElement(confPwdErrormsg).getText();
		return CPErrorMsg;
	}

}
