Feature: Remove Products From Cart Feature

  @RemoveProducts
  Scenario: Remove Products From Cart scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Hover over first product and click Add to cart
    Then Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click Continue Shopping button
    Then Click Cart button
    Then Verify that Cartpage is displayed
    Then Click X button corresponding to particular product
    Then Verify that product is removed from the cart
    And close browser
