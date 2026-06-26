package com.automationexcersie.base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationexcersie.utils.ConfigReader;

public class DriverFactory {

private WebDriver driver;	


	public void openBrowser() {
		if (driver == null) {
			driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		driver.get(ConfigReader.getProperty("base.url"));
		
	}
	
	public  WebDriver getDriver() {
		return driver;
	}

	
	public void closeBrowser() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
}

