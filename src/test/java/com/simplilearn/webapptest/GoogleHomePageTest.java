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

class GoogleHomePageTest {
	
	String siteurl = "https://www.google.com/";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(siteurl);
		
	}
	
	@AfterEach
	void tearDown() {
		driver.close();
	}
	
	@Test
	@DisplayName("Google HomePage Test")
	public void testGoogleHomePage() {
		String url = "Google";
		String actual = driver.getTitle();
		assertEquals(url, actual);
	}
	
	@Test
	@DisplayName("Google HomePage title")
	public void googleTitle() {
		assertEquals(siteurl, driver.getCurrentUrl());
	}
	
	@Test
	@DisplayName("Google searchbox Test")
	public void searchboxTest() {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Wipro");
		searchbox.submit();
		
		String expected = "Wipro - Google Search";
		String acutal = driver.getTitle();
		assertEquals(expected, acutal);
	}

}
