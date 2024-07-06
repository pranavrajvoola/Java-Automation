
@tag
Feature:ErrorValidations
  I want to use this template for my feature file
Background:
Given I landed on Ecommerce Page
  
  @ErrorValidations
  Scenario Outline: ErrorValidations
  Given loggedin with username <name> and password <password>
  Then  <string>message is displayed
  Examples: 
      | name                         | password    | productName  |string |
      | pranavrajvola@gmail.com     | Vtu@12344   | ZARA COAT 3  |Incorrect email r password.|
  

 
    
    @ProductErrorValidations
  Scenario Outline: Product ErrorValidations
 
    Given loggedin with username <name> and password <password>
    When I add product <productName> to cart and verify the match
    
   
        Examples: 
      | name                     | password    | productName  |
      | pranavrajvoola@gmail.com | Vtu@12344   | ADIDAS ORIGINAL |
     
