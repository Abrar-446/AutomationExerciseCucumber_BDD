Feature: Register user Test with existing email

  Scenario: Register User with existing email
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    Then Verify New User Signup! is visible
    Then Enter name and already registered email address
    Then Click Signup button
    Then Verify  signup error 'Email Address already exist!' is visible
    And close browser
