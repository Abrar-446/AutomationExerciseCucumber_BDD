Feature: Contact Us Form Tests

  Scenario: Contact Us Form Tests
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Contact Us button
    Then Verify 'GET IN TOUCH' is visible
    Then Enter name, email, subject and message
    Then Upload file
    Then Click Submit button
    Then Click OK buttons
    Then Verify success message 'Success! Your details have been submitted successfully.' is visible
    Then Click Home button and verify that landed to home page successfully
    And close browser
