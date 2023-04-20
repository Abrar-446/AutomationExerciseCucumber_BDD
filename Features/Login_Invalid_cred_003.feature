Feature: Invalid Login user test

  Scenario: Login with Invalid Email and password
    Given User Launch Chrome browser
    When User opens URL " 'http://automationexercise.com'"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    Then Verify Login to your account is visible
    Then Enter Incorrect email address and password
    Then Click login button
    Then Verify error 'Your email or password is incorrect!' is visible
    And close browser