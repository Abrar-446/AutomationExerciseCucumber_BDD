Feature: View and Cart Brand products feature

  Scenario: View and Cart Brand products scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Verify that Brands are visible on left side bar
    Then Click on any brand name
    Then Verify that user is navigated to brand page and brand products are displayed
    Then On left side bar, click on any other brand link
    Then Verify that user is navigated to that brand page and can see products
    And close browser
