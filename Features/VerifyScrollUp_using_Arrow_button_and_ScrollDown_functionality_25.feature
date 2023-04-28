Feature: Verify Scroll Up using 'Arrow' button and Scroll Down functionality Feature

  Scenario: Verify Scroll Up using 'Arrow' button and Scroll Down functionality scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify 'SUBSCRIPTION' text is visible
    Then Click on arrow at bottom right side to move upward
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
