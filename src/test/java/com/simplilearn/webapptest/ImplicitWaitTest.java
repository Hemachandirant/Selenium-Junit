package com.simplilearn.webapptest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ImplicitWaitTest {
	
	String	siteurl = "https://www.facebook.com/";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get(siteurl);
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	@DisplayName("Facebook Login : Field exists")
	void test() {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		assertEquals(true, email.isDisplayed());
		assertEquals(true, password.isDisplayed());
		assertEquals(true, submit.isDisplayed());
		
		
	}
	
	@Test
	@DisplayName("Facebook Login : Failure Login")
	void failureloginTest() {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		
		email.sendKeys("david@gmail.com");
		password.sendKeys("sda31");
		submit.submit();
		WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		assertEquals("Wrong Credentials", error.getText());
		
		WebElement error2 = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		assertEquals("Invalid username or password", error2.getText());
	}

}
