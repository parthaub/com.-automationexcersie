Feature: User Login

  As a registered user
  I want to log in with valid credentials
  So that I can access my account and place orders

  Background:
    Given the user is on the home page
    When the user clicks the "Login" link

  @TC-01 @positive @smoke @regression
  Scenario: Login with valid email and password
    When the user enters a valid email
    And the user enters a valid password
    And the user clicks the Login button
    Then the user should be logged in successfully ans see the "Partha" text should be visible in the header

  @TC-02 @negative @regression
  Scenario: Login with invalid password
    When the user enters a valid email
    And the user enters an invalid password
    And the user clicks the Login button
    Then the error message "Your email or password is incorrect!" should be displayed

  @TC-03 @negative @regression
  Scenario: Login with invalid email
    When the user enters an invalid email
    And the user enters a valid password
    And the user clicks the Login button
    Then the error message "Your email or password is incorrect!" should be displayed

