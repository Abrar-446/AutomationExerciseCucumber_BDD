Feature: Search Product feature

  Scenario: Search Product Scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    Then Enter product name in search input and click search button
    Then Verify 'SEARCHED PRODUCTS' products is visible
    Then Verify all the products related to search are visible
    And close browser
