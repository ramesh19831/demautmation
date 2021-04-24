package com.demowebshop.testscripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.demowebshop.base.BasePage;

public class TC05_MultipleWindowTest extends BasePage {

	@BeforeSuite
	public void invoke() {
		setup("https://demoqa.com/browser-windows");
	}

	@Test(description = "Handling the Multiple Windows in browser")
	public void handlMultipleWindows() throws InterruptedException {
		click(By.id("windowButton"));
		Thread.sleep(1000);
		String mainwindow = driver.getWindowHandle();

		Set<String> allwindows = driver.getWindowHandles();

		Iterator<String> it = allwindows.iterator();
		while (it.hasNext()) {
			String childwindow = it.next();
			if (!mainwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				String newwindowmsg = getText(By.id("sampleHeading"));
				System.out.println("Heading" + newwindowmsg);
				

			}
		}
	}

	@Test
	public void FrameHandle() throws InterruptedException {
		Thread.sleep(1500);
		WebElement framemenu = driver.findElement(By.xpath("//*[@class='text' and text()='Frames']"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", framemenu);
		WebElement framid = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(framid);
		Thread.sleep(500);
		System.out.println(getText(By.id("sampleHeading")));
		driver.switchTo().defaultContent(); // to come out of Frame
	}
	@Test(description = "Handling the Multiple Windows in browser")
	public void handlMultipleWindowsMessage() throws InterruptedException {
		click(By.id("windowButton"));
		click(By.id("messageWindowButton"));
		Thread.sleep(1000);
		String mainwindow = driver.getWindowHandle();

		Set<String> allwindows = driver.getWindowHandles();

		Iterator<String> it = allwindows.iterator();
		while (it.hasNext()) {
			String childwindow = it.next();
			if (!mainwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				String newwindowmsg = getText(By.id("sampleHeading"));
				System.out.println("Heading" + newwindowmsg);
				if (newwindowmsg.trim().contains("This is a sample page")) {
					System.out.println("Heading" + newwindowmsg);
				}

			}
			
		}
	}
}
