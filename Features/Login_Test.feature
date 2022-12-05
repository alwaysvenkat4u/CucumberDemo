
Feature: Login 

	Background: 
	When User navigate to URL "https://admin-demo.nopcommerce.com/login"

	@Smoke
  Scenario: Successful login with valid Credentials 
   
   // When User navigate to URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on LogOut link
    Then Page title should be "Your store. Login"
   
   @Sanity 
  Scenario Outline: login with DataDriven
   
   // When User navigate to URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on LogOut link
    Then Page title should be "Your store. Login"
    
    Examples:
    | email | password|
    |admin@yourstore.com| admin|
    |admin1@yourstore.com  | admin123 |
    |admin@yourstore.com| admin|
   
   		
