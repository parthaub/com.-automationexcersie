package com.automationexcersie.stepdefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationexcersie.base.DriverFactory;
import com.automationexcersie.pages.LoginPage;
import com.automationexcersie.utils.AssertHelper;
import com.automationexcersie.utils.ConfigReader;
import com.automationexcersie.utils.HighLighter;
import com.automationexcersie.utils.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {
	private WebDriver driver;
	private DriverFactory driverFactory;
	private LoginPage loginPage;
	private WaitUtils waitUtils;
	private AssertHelper assertHelper;


private static final Logger logger = LogManager.getLogger(LoginSteps.class);


public LoginSteps(DriverFactory driverFactory) {
	this.driverFactory = driverFactory;
	}

	

@Given("the user is on the home page")
public void the_user_is_on_the_home_page() {
	logger.info("===============Open the browser and user in home page================");
		
		driver = driverFactory.getDriver();
		waitUtils = new WaitUtils(driver);
		loginPage = new LoginPage(driver);
		assertHelper = new AssertHelper();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl= ConfigReader.getProperty("base.url");
		assertHelper.softAssertEquals(actualUrl, actualUrl, "Home page URL not matched");
	}

	
@When("the user clicks the {string} link")
public void the_user_clicks_the_link(String clickthelink) {
	logger.info("User clicks in loginlink {}" , clickthelink);

		WebElement loginbutton = waitUtils.waitForClickable(loginPage.getNavSignupLogin());
		HighLighter.highlight(driver, loginPage.getNavSignupLogin());
		assertHelper.softAssertTrue(loginbutton.isDisplayed(), "Login button is not displayed");
		assertHelper.softAssertTrue(loginbutton.isEnabled(), "Login button is not Enabled");
		loginbutton.click();
	}



@When("the user enters a valid email")
public void the_user_enters_a_valid_email() {
		logger.info("User enters email id");

		WebElement enterValidEmail = waitUtils.waitForVisibility((loginPage.getUsernameInput()));
		enterValidEmail.sendKeys(ConfigReader.getProperty("valid_email"));
		HighLighter.highlight(driver, loginPage.getUsernameInput());
	}




@When("the user enters a valid password")
public void the_user_enters_a_valid_password() {

		logger.info("User enters password");
		WebElement enterValidPasseord = waitUtils.waitForVisibility((loginPage.getPasswordInput()));
		enterValidPasseord.sendKeys(ConfigReader.getProperty("valid_password"));
		HighLighter.highlight(driver, loginPage.getPasswordInput());
	}


@When("the user clicks the Login button")
public void the_user_clicks_the_login_button() {
	
		WebElement waitforclick = waitUtils.waitForClickable(loginPage.getLoginLink());
		waitforclick.click();
		HighLighter.highlight(driver, loginPage.getLoginLink());
		logger.info("User clicks login button accorectly");
	}



@Then("the user should be logged in successfully ans see the {string} text should be visible in the header")
public void the_user_should_be_logged_in_successfully_ans_see_the_text_should_be_visible_in_the_header(
		String expectedUserName) {

		WebElement welcomeText = loginPage.getWelcomeUserText();
		assertHelper.softAssertTrue(welcomeText.isDisplayed(), "Welcome text should be visible ");
		String actualtext = welcomeText.getText();
		assertHelper.softAssertEquals(actualtext, expectedUserName, "username is there ");
		assertHelper.assertAll();
		logger.info("========Positive Test: User see scessfull message {}", expectedUserName, "==================");		
}



@When("the user enters an invalid password")
public void the_user_enters_an_invalid_password() {
		
		WebElement inValidPassword = waitUtils.waitForVisibility((loginPage.getPasswordInput()));
		inValidPassword.sendKeys(ConfigReader.getProperty("invalid_password"));
		HighLighter.highlight(driver, loginPage.getPasswordInput());
		logger.info("============User clicks invilade passord correctly==============");
	}


@Then("the error message {string} should be displayed")
public void the_error_message_should_be_displayed(String errormessage) {

		WebElement errorText = waitUtils.waitForVisibility((loginPage.getErrorText()));
		System.out.println(errorText.isDisplayed());
		String actualText = errorText.getText();
		System.out.println(actualText);
		assertHelper.softAssertEquals(actualText, errormessage, "error: Your email or password is incorrect!");
		logger.info("=================Negative Test: The error message in displayed {}", errormessage, "=========================");
	}


@When("the user enters an invalid email")
public void the_user_enters_an_invalid_email() {

		WebElement inValidEmail = waitUtils.waitForVisibility((loginPage.getUsernameInput()));
		inValidEmail.sendKeys(ConfigReader.getProperty("invalid_email"));
		assertHelper.assertAll();
		logger.info("User clicks invilad email id");
	}

}
