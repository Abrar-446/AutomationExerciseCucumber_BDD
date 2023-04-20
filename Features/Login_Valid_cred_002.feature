Feature: Valid Login user test

  Scenario: Login with valid Email and password
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    Then Verify Login to your account is visible
    Then Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    Then Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible
    And close browser
