package com.demowebshop.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class BasePage {
	public static WebDriver driver;
	public  void setup(String url) {
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse\\chromedriver.exe");
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
