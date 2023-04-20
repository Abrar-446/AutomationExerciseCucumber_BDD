Feature: Logout user Test

  Scenario: Logout user
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    Then Verify Login to your account is visible
    Then Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    Then Click Logout button
    Then Verify that user is navigated to login page
    And close browser
