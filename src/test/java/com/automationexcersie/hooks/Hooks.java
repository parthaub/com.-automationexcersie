package com.automationexcersie.hooks;

import org.openqa.selenium.WebDriver;

import com.automationexcersie.base.DriverFactory;
import com.automationexcersie.utils.ScreenShot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private DriverFactory driverFactory;

	public Hooks(DriverFactory driverFactory) {
		this.driverFactory = driverFactory;
	}

	@Before
	public void setup() {
		driverFactory.openBrowser();

	}
	@After
	public void tearDown(Scenario scenario) {
	    WebDriver driver = driverFactory.getDriver();

	    if (driver != null) {
	        String name = scenario.getName().replaceAll(" ", "_");

	        if (scenario.isFailed()) {
	            ScreenShot.takeScreenshot(driver, "FAILED_" + name);
	        } else {
	            ScreenShot.takeScreenshot(driver, "PASSED_" + name);
	        }
	        driverFactory.closeBrowser();
	    }
	}
}
