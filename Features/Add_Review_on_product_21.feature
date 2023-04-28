Feature: Add review on product feature

  Scenario: Add review on product scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
    #Then The products list is visible
    Then Click on View Product of first product
    Then User is landed to product detail page
    Then Verify 'Write Your Review' label information  is visible
    Then Enter name, email and review
    Then Click Submit button in Product Details page
    Then Verify success message with 'Thank you for your review.' is visible
    And close browser
