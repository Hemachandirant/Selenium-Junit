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

class AmazonNavigationTest {
	
	String siteurl = "https://www.amazon.in/";
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
	@DisplayName("AmazonTest : BestSeller link")
	void bestSellerTest() {
		WebElement bestLink = driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)"));
		bestLink.click();
		String expected = "Amazon.in Bestsellers: The most popular items on Amazon";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Amazon Test : AmazonPay link")
	void amazonpayTest() {
		WebElement amazonpay = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
		amazonpay.click();
		String excepted = "Amazon Pay";
		String actual = driver.getTitle();
		assertEquals(excepted, actual);
	}

}
