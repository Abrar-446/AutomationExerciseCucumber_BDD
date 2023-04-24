Feature: Place Order: Login before Checkout Feature
	@End2End-LoginBeforeCheckout
  Scenario: Place Order: Login before Checkout scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    #Login 
    Then Verify Login to your account is visible
    Then Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    #Add products to cart
    Then Click on Products button
    Then Hover over first product and click Add to cart
    Then Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click Continue Shopping button
    Then Click Cart button
    Then Verify that Cartpage is displayed
    Then Click Proceed To Checkout
    Then Verify Address Details and Review Your Order
    Then Enter description in comment text area and click Place Order
    Then Verify payment page is Displayed
    Then Enter payment details: Name on Card, Card Number, CVC, Expiration date
    Then Click Pay and Confirm Order button
    Then Verify success message 'Congratulations! Your order has been confirmed!'
    Then Click Delete Account button
    Then Verify that ACCOUNT DELETED! is visible
    Then Click on continue button
    And close browser
