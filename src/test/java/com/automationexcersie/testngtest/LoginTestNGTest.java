package com.automationexcersie.testngtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationexcersie.base.DriverFactory;
import com.automationexcersie.listeners.RetryAnalyzer;
import com.automationexcersie.pages.LoginPage;
import com.automationexcersie.utils.AssertHelper;
import com.automationexcersie.utils.ConfigReader;
import com.automationexcersie.utils.WaitUtils;

public class LoginTestNGTest {

	private WebDriver driver;
	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private WaitUtils waitUtils;
	AssertHelper assertHelper;

	@BeforeMethod
	public void setup() {
		driverFactory = new DriverFactory();
		driverFactory.openBrowser();
		driver = driverFactory.getDriver();

		waitUtils = new WaitUtils(driver);
		loginPage = new LoginPage(driver);
		assertHelper = new AssertHelper();

	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void validLoginTest() {
		waitUtils.waitForClickable(loginPage.getNavSignupLogin()).click();
		waitUtils.waitForVisibility(loginPage.getUsernameInput()).sendKeys(ConfigReader.getProperty("valid_email"));
		waitUtils.waitForVisibility(loginPage.getPasswordInput()).sendKeys(ConfigReader.getProperty("valid_password"));
		waitUtils.waitForClickable(loginPage.getLoginLink()).click();

		
		WebElement welcomeText = waitUtils.waitForVisibility(loginPage.getWelcomeUserText());
		String expectedUserName = "Partha";
		String actualText = welcomeText.getText();
		assertHelper.softAssertTrue(welcomeText.isDisplayed(), "Welcome text should be visible");
		assertHelper.softAssertEquals(actualText, expectedUserName, "Username mismatch");
		assertHelper.assertAll();
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void InvalidLoginTestWithInvlaidEmail() {
		waitUtils.waitForClickable(loginPage.getNavSignupLogin()).click();
		waitUtils.waitForVisibility(loginPage.getUsernameInput()).sendKeys(ConfigReader.getProperty("invalid_email"));
		waitUtils.waitForVisibility(loginPage.getPasswordInput()).sendKeys(ConfigReader.getProperty("valid_password"));
		waitUtils.waitForClickable(loginPage.getLoginLink()).click();

		WebElement errorText = waitUtils.waitForVisibility(loginPage.getErrorText());
		String errormessage = "Your email or password is incorrect!";
		String actualText = errorText.getText();
		assertHelper.softAssertTrue(errorText.isDisplayed(), "Invalid text should be visible");
		assertHelper.softAssertEquals(actualText, errormessage, "error: Your email or password is incorrect!");

	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void InvalidLoginTestWithInvlaidPassword() {
		waitUtils.waitForClickable(loginPage.getNavSignupLogin()).click();
		waitUtils.waitForVisibility(loginPage.getUsernameInput()).sendKeys(ConfigReader.getProperty("valid_email"));
		waitUtils.waitForVisibility(loginPage.getPasswordInput())
				.sendKeys(ConfigReader.getProperty("invalid_password"));
		waitUtils.waitForClickable(loginPage.getLoginLink()).click();

		WebElement errorText = waitUtils.waitForVisibility((loginPage.getErrorText()));
		String errormessage = "Your email or password is incorrect!";
		String actualText = errorText.getText();
		assertHelper.softAssertTrue(errorText.isDisplayed(), "Invalid text should be visible");
		assertHelper.softAssertEquals(actualText, errormessage, "error: Your email or password is incorrect!");

	}

	@AfterMethod
	public void teardown() {
		if (driverFactory != null) {
			driverFactory.closeBrowser();
		}
	}
}