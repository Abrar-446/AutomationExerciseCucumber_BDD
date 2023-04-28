Feature: Add to cart from Recommended items feature

  Scenario: Add to cart from Recommended items scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Scroll to bottom of page
    Then Verify 'RECOMMENDED ITEMS' are visible
    Then Click on Add To Cart on Recommended product
    Then Click on View Cart button
    Then Verify that product is displayed in cart page
    And close browser
