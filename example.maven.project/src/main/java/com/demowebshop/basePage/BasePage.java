package com.demowebshop.basePage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


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

	
	public void fluentWait(final By by) {
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)  // default 30 sec.
		       .pollingEvery(5, TimeUnit.SECONDS)  // it will add 5 more seconds to driver = 30+5= 35sec. 
		       .ignoring(NoSuchElementException.class)  // ignoring the exception to avoid the test failed.
		       .ignoring(StaleElementReferenceException.class)
		       .ignoring(NoAlertPresentException.class)
		       .ignoring(AssertionError.class);

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(by);
		     }
		   });
	}
	

	
}
