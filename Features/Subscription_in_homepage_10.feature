Feature: Subscription in Homepage feature

  Scenario: Subscription in Homepage Scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Scroll down to footer
    Then Verify text 'SUBSCRIPTION'
    Then Enter email address in input and click arrow button
    Then Verify success subscribe message 'You have been successfully subscribed!' is visible
    And close browser
