Feature: Add products to cart Feature

  Scenario: Add products to cart scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Hover over first product and click Add to cart
    Then Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click View Cart button
    Then Verify both products are added to Cart
    Then Verify their prices, quantity and total price
    And close browser
