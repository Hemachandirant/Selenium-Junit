package com.simplilearn.screenshots;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.logging.FileHandler;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshot {
	String url = "https://www.facebook.com/";
	String driverpath = "driver/windows/chromedriver.exe";
	WebDriver driver;
	
	@BeforeEach
	void setup() {
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.get(url);
		
	}
	
	@AfterEach
	void teardown() {
		driver.close();
		
	}
	@Test
	@DisplayName("Facebook Login : Failure login.")
	public void testFailureLogin() throws IOException {
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		
		email.sendKeys("abc@gmail.com");
		password.sendKeys("abc@123");
		submit.submit();
		
		takeScreenShot("facebook-data-entry.png");
		
		// Conditional timeouts
		// WebElement error = driver.findElement(By.cssSelector("#error_box > div.fsl.fwb.fcb"));
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div.fsl.fwb.fcb")));
		assertEquals("Wrong Credentials", error.getText());
		
		// WebElement error2 = driver.findElement(By.cssSelector("#error_box > div:nth-child(2)"));
		WebElement error2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#error_box > div:nth-child(2)")));
		assertEquals("Invalid username or password", error2.getText());
		
		takeScreenShot("facebook-invalid-creds.png");
	}
	
	@Test
	@DisplayName("Facebook : Take screenshot")
	void takeScreenshot() {
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement submit = driver.findElement(By.name("login"));
		
		assertEquals(true, email.isDisplayed());
		assertEquals(true, pass.isDisplayed());
		assertEquals(true, submit.isDisplayed());
	}

	private void takeScreenshots(String filename) {
		// type cast driver object to take screen shot
		TakesScreenshot screenshot =  (TakesScreenshot) driver;		
		// take screen shot by getScreenshotAs method as file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		//copy file as src
		FileHandler.copy(src, new File("/home/wahidkhan74gmai/upload/"+filename));
	}
}
