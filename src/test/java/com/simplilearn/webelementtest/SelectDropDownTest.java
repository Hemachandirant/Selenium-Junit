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
import org.openqa.selenium.support.ui.Select;

class SelectDropDownTest {
	
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
	@DisplayName("Select dropdown exist")
	void test() {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		assertEquals(true, dropdown.isDisplayed());
		assertEquals(true, dropdown.isEnabled());
		assertEquals(false, dropdown.isSelected());
	}
	
	@Test
	@DisplayName("Test first selected from dropdown Menu")
	void dropdown1test() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Bike");
		WebElement selected = select.getFirstSelectedOption();
		assertEquals("Bike", selected.getText());
		Thread.sleep(5000);
		
	}
	@Test
	@DisplayName("Test second selected from dropdown Menu by index")
	void dropdown2test() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("vehicle"));
		Select select = new Select(dropdown);
		select.selectByIndex(3);
		
		WebElement selected = select.getFirstSelectedOption();
		assertEquals("Airplane", selected.getText());
		Thread.sleep(3000);
	}
}
