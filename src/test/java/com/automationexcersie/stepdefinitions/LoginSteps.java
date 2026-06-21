package com.automationexcersie.stepdefinitions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.automationexcersie.base.DriverFactory;
import com.automationexcersie.pages.LoginPage;
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
	private SoftAssert softAssert;
	

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {

		driverFactory = new DriverFactory();
		driverFactory.openBrowser();
		driver = driverFactory.getDriver();
		waitUtils = new WaitUtils(driver);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
		String getTitile = driver.getCurrentUrl();
		System.out.println(getTitile);
		softAssert.assertEquals(getTitile, getTitile, "Url not matched");
	}

	
	
	@When("the user clicks the {string} link")
	public void the_user_clicks_the_link(String clickthelink) {
		WebElement loginbutton = waitUtils.waitForClickable(loginPage.getNavSignupLogin());
		softAssert.assertTrue(loginbutton.isDisplayed(), "Login button is not displayed");
		softAssert.assertTrue(loginbutton.isEnabled(), "Login button is not Enabled");
		loginbutton.click();
	}

	
	@When("the user enters a valid email")
	public void the_user_enters_a_valid_email() {

		WebElement enterValidEmail = waitUtils.waitForVisibility((loginPage.getUsernameInput()));
		enterValidEmail.sendKeys(ConfigReader.getProperty("valid_email"));
		HighLighter.highlight(driver, loginPage.getUsernameInput());
	}

	
	@When("the user enters a valid password")
	public void the_user_enters_a_valid_password() {

		WebElement enterValidPasseord = waitUtils.waitForVisibility((loginPage.getPasswordInput()));
		enterValidPasseord.sendKeys(ConfigReader.getProperty("valid_password"));
		HighLighter.highlight(driver, loginPage.getPasswordInput());
	}

	
	@When("the user clicks the Login button")
	public void the_user_clicks_the_login_button() {
		WebElement waitforclick = waitUtils.waitForClickable(loginPage.getLoginLink());
		waitforclick.click();
	}

	
	@Then("the user should be logged in successfully ans see the {string} text should be visible in the header")
	public void the_user_should_be_logged_in_successfully_ans_see_the_text_should_be_visible_in_the_header(
			String Partha) {

		WebElement welcomeText = loginPage.getWelcomeUserText();
		softAssert.assertTrue(welcomeText.isDisplayed(), "Welcome text should be visible ");
		String actualtext = welcomeText.getText();
		softAssert.assertEquals(actualtext, Partha, "username is there " + Partha);
	}

	
	@When("the user enters an invalid password")
	public void the_user_enters_an_invalid_password() {

		WebElement inValidPassword = waitUtils.waitForVisibility((loginPage.getPasswordInput()));
		inValidPassword.sendKeys(ConfigReader.getProperty("invalid_password"));
		HighLighter.highlight(driver, loginPage.getPasswordInput());
	}

	
	@Then("the error message {string} should be displayed")
	public void the_error_message_should_be_displayed(String errormessage) {

		WebElement errorText = waitUtils.waitForVisibility((loginPage.getErrorText()));
		System.out.println(errorText.isDisplayed());
		String actualText = errorText.getText();
		System.out.println(actualText);
		softAssert.assertEquals(actualText, "Your email or password is incorrect!");
	}

	
	@When("the user enters an invalid email")
	public void the_user_enters_an_invalid_email() {

		WebElement inValidEmail = waitUtils.waitForVisibility((loginPage.getUsernameInput()));
		inValidEmail.sendKeys(ConfigReader.getProperty("invalid_email"));
		softAssert.assertAll();
	}

	
	
}
