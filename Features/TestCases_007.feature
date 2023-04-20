Feature: Test cases test

  Scenario: Verify Test Cases page
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Test Cases button
    Then Verify user is navigated to test cases page successfully
    Then Expand all test cases
    Then Collapse all test cases
    And close browser