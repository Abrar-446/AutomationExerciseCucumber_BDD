Feature: Place Order: Register while Checkout Feature
	@End2End-RegisterWhileCheckout
  Scenario: Place Order: Register while Checkout scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    #Add products to cart
    Then Click on Products button
    Then Hover over first product and click Add to cart
    Then Click Continue Shopping button
    Then Hover over second product and click Add to cart
    Then Click Continue Shopping button
    Then Click Cart button
    Then Verify that Cartpage is displayed
    Then Click Proceed To Checkout
    Then Click Register_Login button in page
    ##Fill all details in Signup and create account---
    Then Click on Signup_Login button
    Then Verify New User Signup! is visible
    Then Enter name and email address
    Then Click Signup button
    Then Verify that ENTER ACCOUNT INFORMATION is visible
    Then Fill details: Title, Name, Email, Password, Date of birth
    Then Select checkbox Sign up for our newsletter!
    Then Select checkbox Receive special offers from our partners!
    Then Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    Then Click Create Account button
    Then Verify that ACCOUNT CREATED! is visible
    Then Click on continue button
    Then Verify that Logged in as username is visible
    Then Click Cart button
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
