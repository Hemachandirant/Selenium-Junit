package com.simplilearn.webelementtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class CheckBoxTest {
	
	String siteurl = "file:///C:/Users/hemac/eclipse-workspace/phase-05-selenium-junit-test/static/webelements.html";
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
	@DisplayName("CheckBoxTest01")
	void test01() {
		
		WebElement checkbox1 = driver.findElement(By.id("vehicle1"));
		assertEquals(true, checkbox1.isDisplayed());
		assertEquals(true, checkbox1.isEnabled());
		assertEquals(false, checkbox1.isSelected());
		
		checkbox1.click();
		assertEquals(true, checkbox1.isSelected());
		
		
	}
	
	@Test
	@DisplayName("CheckBoxTest02")
	void test02() {
		
		WebElement checkbox2 = driver.findElement(By.id("vehicle2"));
		assertEquals(true, checkbox2.isDisplayed());
		assertEquals(true, checkbox2.isEnabled());
		assertEquals(false, checkbox2.isSelected());
		
		checkbox2.click();
		assertEquals(true, checkbox2.isSelected());

}
	@Test
	@DisplayName("CheckBoxTest03")
	void test03() {
		
		WebElement checkbox3 = driver.findElement(By.id("vehicle3"));
		assertEquals(true, checkbox3.isDisplayed());
		assertEquals(true, checkbox3.isEnabled());
		assertEquals(false, checkbox3.isSelected());
		
		checkbox3.click();
		assertEquals(true, checkbox3.isSelected());
	}
	}
