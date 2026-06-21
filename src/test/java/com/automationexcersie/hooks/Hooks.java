package com.automationexcersie.hooks;

import com.automationexcersie.base.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
	public void tearDown() {
		driverFactory.closeBrowser();

	}

}
