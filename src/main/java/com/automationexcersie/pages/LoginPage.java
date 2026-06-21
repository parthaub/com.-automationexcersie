package com.automationexcersie.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	
	
// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
// WebElements using Page Factory Locators

	@FindBy(xpath = "//*[text()=' Signup / Login']")
	private WebElement navSignupLogin;

	@FindBy(xpath = "(//*[@name='email'])[1]")
	private WebElement usernameInput;

	@FindBy(xpath = "(//*[@name='password'])[1]")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[text()='Login']")
	private WebElement loginLink;

	@FindBy(xpath = "//*[text()=' Logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//*[text()='Partha' ]")
	private WebElement welcomeUserText;

	@FindBy(xpath = "//*[text()='Your email or password is incorrect!' ]")
	private WebElement errorText;

	
	
	
	
//Getter method

	public WebElement getNavSignupLogin() {
		return navSignupLogin;
	}

	public WebElement getUsernameInput() {
		return usernameInput;
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getWelcomeUserText() {
		return welcomeUserText;
	}

	public WebElement getErrorText() {
		return errorText;
	}

}
