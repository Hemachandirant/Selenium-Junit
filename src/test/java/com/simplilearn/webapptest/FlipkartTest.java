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

class FlipkartTest {

	String siteurl =  "https://www.flipkart.com/";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;
	
	
	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(siteurl);
		
	}
	
	@AfterEach
	void teardown() {
		driver.close();
	}
	
	@Test
	@DisplayName("Flipkart Test :  Source URl")
	void testFlipkartHomeSourceUrl() {
		assertEquals(siteurl, driver.getCurrentUrl());
	}	
	
	@Test
	@DisplayName(value = "Flipkart Test : Title")
	void testHomeTilt() {
		String Excepted = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		String Actual = driver.getTitle();
		assertEquals(Excepted, Actual);
		
	}
	
	@Test
	@DisplayName("Flipkart Test : search product 01")
	void testSearchProduct01() {
			WebElement searchbox = driver.findElement(By.name("q"));
			searchbox.sendKeys("Apple macbook");
			searchbox.submit();
			
			String Excepted = "Apple Macbook- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
			String Actual = driver.getTitle();
			assertEquals(Excepted, Actual);
	}
}
