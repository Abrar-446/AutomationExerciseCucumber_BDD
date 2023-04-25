Feature: Search Products and Verify Cart After Login feature

  Scenario: Search Products and Verify Cart After Login scenario
    Given User Launch Chrome browser
    Then User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Products button
    Then Verify user is navigated to ALL PRODUCTS page successfully
		Then Enter product name in search input and click search button
    Then Verify 'SEARCHED PRODUCTS' products is visible
    Then Verify all the products related to search are visible
    Then Add those products to cart
    Then Click Cart button
    Then verify that products are visible in cart
    Then Click on Signup_Login button
    Then Verify Login to your account is visible
    Then Enter correct email address and password
    Then Click login button
    Then Verify that Logged in as username is visible
    #Then Again, go to Cart page
    Then Click Cart button
    Then Verify that those products are visible in cart after login as well
    And close browser
