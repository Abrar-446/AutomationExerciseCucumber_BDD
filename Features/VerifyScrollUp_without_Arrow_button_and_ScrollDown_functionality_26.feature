Feature: Verify Scroll Up without 'Arrow' button and Scroll Down functionality Feature

  Scenario: Verify Scroll Up without 'Arrow' button and Scroll Down functionality scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify 'SUBSCRIPTION' text is visible
    Then Scroll up to the top
    Then Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
