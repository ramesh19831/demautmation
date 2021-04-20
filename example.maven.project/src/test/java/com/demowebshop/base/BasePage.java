package com.demowebshop.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BasePage {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	
	
	static {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String path = System.getProperty("user.dir")+"/testreport/"+formatter.format(cal.getTime())+".html";
		reporter=new ExtentHtmlReporter(path);
		extent = new ExtentReports();
		 extent.attachReporter(reporter);
		 extent.setSystemInfo("URL", "http://demowebshop.tricentis.com/");
		 extent.setSystemInfo("Browser", "Chrome");
		 extent.setSystemInfo("System", "Win10");
		 try {
			extent.setSystemInfo("User", System.getenv(InetAddress.getLocalHost().getHostName()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void setup(String url) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // static wait method
	}
	
	public void click(By xpath) {
		driver.findElement(xpath).click();
	}
	
	public void type(By xpath, String value) {
		driver.findElement(xpath).clear();
		driver.findElement(xpath).sendKeys(value);
	}
	public static int randomNumber() {
		
		 Random rand = new Random();
		  
	        // Generate random integers in range 0 to 999
	        int rand_int1 = rand.nextInt(10000);
		return rand_int1;
	}
	public String Title() {
		return driver.getTitle();
	}

	public static String readExcelFile(int i, int j) throws BiffException, IOException {
		FileInputStream fis = new FileInputStream(new File("C:\\exceldata\\Login.xls"));
		Workbook wb = Workbook.getWorkbook(fis);
		
		Sheet sh  = wb.getSheet("LoginData");
		Cell c = sh.getCell(i,j);
		return c.getContents();
		
	}
	static WebDriverWait wait ;
	public void webdriverWait(By by) {
		 wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	
	
	public  String path = "C:/hanimireddyselenium/screenshots/";
	public  void takeScreenShot(String filename) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path+filename+".png"));
	}
	
	
}
