package com.simplilearn.alertandpopupTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class AlertTest {
	
	String siteurl = "file:///C:/Users/hemac/eclipse-workspace/phase-05-selenium-junit-test/static/alert-web-elements.html";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(siteurl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void test() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Do you really want to proceed ??", alert.getText());
		Thread.sleep(4000);
		alert.accept();
	}
	@Test
	@DisplayName("Alert Popup Test02")
	void test2() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(2) > button")).click();
		Alert alert = driver.switchTo().alert();
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with ok button click
		confirm.accept();
	}
	@Test
	@DisplayName("Confirmation dailog test with cancel")
	public void testConfirmDailogWindowCancel() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(4) > button")).click();
		//switch to sub window alert
		Alert confirm = driver.switchTo().alert();
		assertEquals("Please confirm the action is right ??", confirm.getText());
		Thread.sleep(3000);
		// confirmation with cancel button click
		confirm.dismiss();
	}
	
	
	@Test
	@DisplayName("Prompt  dailog test with accept")
	public void testPromptDailogWindow() throws InterruptedException {
		driver.findElement(By.cssSelector("body > p:nth-child(6) > button")).click();
		//switch to sub window alert
		Alert propmt = driver.switchTo().alert();
		assertEquals("Please enter your name.", propmt.getText());
		propmt.sendKeys("John Smith");
		
		Thread.sleep(3000);		
		// propmt with accept button click
		propmt.accept();
	}


}
