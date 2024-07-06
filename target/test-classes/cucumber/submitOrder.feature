
@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file


Background:
Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: test to submit the order
    Given loggedin with username <name> and password <password>
    When I add product <productName> to cart
    When checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name                         | password    | productName  |
      | pranavrajvoola@gmail.com     | Vtu@12344   | ZARA COAT 3  |
      
