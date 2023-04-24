Feature: Verify Product quantity in Cart Feature

  Scenario: Verify Product quantity in Cart scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Click on View Product of first product
    Then User is landed to product detail page
    Then Increase quantity to 4
    Then Click Add to cart button
    Then Click View Cart button
    Then Verify that product is displayed in cart page with exact quantity
    Then Verify the total price
    And close browser
