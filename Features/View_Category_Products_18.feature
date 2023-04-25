Feature: View Category Products Feature

  Scenario: View Category Products scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Verify that categories are visible on left side bar
    Then Click on Women category
    Then Click on any category link under 'Women' category, for example: Dress
    Then Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
    Then On left side bar, click on any sub-category link of Men category
    Then Verify that user is navigated to that category page
