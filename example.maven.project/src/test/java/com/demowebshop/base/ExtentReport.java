package com.demowebshop.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public WebDriver driver;

	public void invoke(WebDriver driver) {
		this.driver = driver;
	}

	public ExtentHtmlReporter Extenthtmlreporter;
	public ExtentReports Extentreporter;
	public ExtentTest test;

	@BeforeTest
	public void SetExtentHtmlReport() {
		Extenthtmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myrepoty.html");
		Extenthtmlreporter.config().setDocumentTitle("");
		Extenthtmlreporter.config().setReportName("");
		Extenthtmlreporter.config().setTheme(Theme.DARK);

		Extentreporter = new ExtentReports();
		Extentreporter.attachReporter(Extenthtmlreporter);

		Extentreporter.setSystemInfo("Hostname", "LocalHost");
		Extentreporter.setSystemInfo("OS", "Windows 10 Pro");
		Extentreporter.setSystemInfo("Tester Name", "Hanimi Reddy");
		Extentreporter.setSystemInfo("Browser", "Chrome");

	}

	@AfterTest
	public void EndReport() {
		Extentreporter.flush();
	}

	@BeforeMethod
	public void Setup() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "E:\\C drive Backup\\chromedriver_win32 (1).chromedriver.exe");
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

	}

	@Test
	public void TitleTest() {
		test = Extentreporter.createTest("nopcommerce Title Test");

		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "eCommenrce demo store");

	}

	@Test
	public void LogoTest() {
		test = Extentreporter.createTest("eCommence Logo Test");

		boolean Status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertTrue(Status);

	}
	
	@Test
	public void LoginTest()
	{
		test=Extentreporter.createTest("Ecommence Login test");
		Assert.assertTrue(true);
		
	}
	
//	@AfterMethod
//	public void TearDown(ITestResult result) {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "Test Case is Failed" + result.getName());
//			test.log(Status.FAIL, "Test case is Failed" + result.getThrowable());
//			
//			String Scrrenshotpath = NopCommerceTest.getScreenshot(driver, result.getName());
//			
//			test.addScreenCaptureFromPath(Scrrenshotpath);
//			
//		} else if (result.getStatus() == ITestResult.SKIP){
//			test.log(Status.FAIL, "Test case is Skipped" +result.getName());
//		}
//		else if(result.get) {
//			
//			test.log(Status.FAIL, "Test case is skipped" +result.getThrowable());
//			
//		}
//			

		//}
	//}
}
