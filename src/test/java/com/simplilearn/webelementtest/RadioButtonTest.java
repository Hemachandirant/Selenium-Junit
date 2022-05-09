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

class RadioButtonTest {
	
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
	@DisplayName("Webelement test : RadioButton-01")
	void test() {
		
		WebElement radiobutton1 = driver.findElement(By.id("male"));
		assertEquals(true, radiobutton1.isDisplayed());
		assertEquals(true, radiobutton1.isEnabled());
		assertEquals(false, radiobutton1.isSelected());
		
		radiobutton1.click();
		assertEquals(true, radiobutton1.isSelected());
		
		
	}
	
	@Test
	@DisplayName("webelement test : RadioButton-02")
	void buttonTwoTest() {
		WebElement radiobutton2 = driver.findElement(By.id("female"));
		assertEquals(true, radiobutton2.isDisplayed());
		assertEquals(true, radiobutton2.isEnabled());
		assertEquals(false, radiobutton2.isSelected());
		
		radiobutton2.click();
		assertEquals(true, radiobutton2.isSelected());
		
	}
	
	@Test
	@DisplayName("webelement test : RadioButton-03")
	void buttonThreetest() {
		
		WebElement radiobutton3 = driver.findElement(By.id("other"));
		assertEquals(true, radiobutton3.isDisplayed());
		assertEquals(true, radiobutton3.isEnabled());
		assertEquals(false, radiobutton3.isSelected());
		
		radiobutton3.click();
		assertEquals(true, radiobutton3.isSelected());
		
	}

}
