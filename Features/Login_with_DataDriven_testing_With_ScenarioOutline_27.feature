#Datadriven testing using scenario outline and examples keyword
Feature: Login with DDT feature

  #
  #Scenario Outline: Successful Login with Valid Credentials DDT
  #Given User Launch Chrome browser
  #When User opens URL "http://automationexercise.com"
  #Then Verify that home page is visible successfully
  #Then Click on Signup_Login button
  #Then Verify Login to your account is visible
  #Then user enters email as "<email>" and Password as "<password>"
  #Then Click login button
  #Then Verify that Logged in as username is visible
  #And close browser
  #
  #Examples:
  #| email             | password |
  #| Test1111@test.com | test@123 |
  #| Test1112@test.com | test@123 |
  #| Test1113@test.com | test@123 |
  #| Test1130@test.com | test@123 |
  
  
  # Simple login with Data table with single parameters
  
  #Scenario: Log-in with valid username and password
  #Given User Launch Chrome browser
  #When User opens URL "http://automationexercise.com"
  #Then Verify that home page is visible successfully
  #Then Click on Signup_Login button
  #Then Verify Login to your account is visible
  #Then Enter correct emailaddress and password with datatable
  #| Test1130@test.com | test@123 |
  #Then Click login button
  #Then Verify that Logged in as username is visible
  #And close browser
  
  
  # Simple login with Data table with Multiple parameters-Header
  Scenario: Log-in with valid username and password
    Given User Launch Chrome browser
    When User opens URL "http://automationexercise.com"
    Then Verify that home page is visible successfully
    Then Click on Signup_Login button
    Then Verify Login to your account is visible
    Then Enter correct emailaddress and password with Multiple data using Datatable Header
      | emailaddress      | password |
      | Test1130@test.com | test@123 |
    Then Click login button
    Then Verify that Logged in as username is visible
    And close browser
