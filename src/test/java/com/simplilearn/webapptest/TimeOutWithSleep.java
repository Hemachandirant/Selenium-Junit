package com.simplilearn.webapptest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TimeOutWithSleep {
	
	String siteurl =  "https://www.amazon.in/";
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
	@DisplayName("Amazon test : Gift card Test")
	void test() throws InterruptedException {
		WebElement custLink = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[3]"));
		custLink.click();
		Thread.sleep(5000);
		String expected = "Help - Amazon Customer Service";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

}
