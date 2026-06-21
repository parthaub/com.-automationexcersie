package com.automationexcersie.utils;

import java.time.Duration;

import javax.swing.text.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriverWait wait;
	private  WebDriver driver;

	public WaitUtils(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.driver= driver;
	}

	public WebElement waitForVisibility(WebElement webElement) {
		return wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public WebElement waitForClickable(WebElement webElement) {
		return wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public Alert waitForAlert() {
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	public WebElement waitgetText(WebElement webElement) {
		return wait.until(ExpectedConditions.visibilityOf(webElement));
		
		
	        
	    }
}
