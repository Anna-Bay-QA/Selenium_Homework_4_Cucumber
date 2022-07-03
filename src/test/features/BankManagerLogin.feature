@Test
Feature: The Bank manager adds/delete a customer to/from the list of customers

  Scenario: As a Bank manager, I want to login and add customer and then delete it
    Given I open login page
    When  I click Bank Manager Login button
    When  I click Add Customer button
    And   I fill the FirstName LastName PostCode inputs and click Add Customer button
    And   I search new customer on customers list
    And   I check that new customer is added with correct info
    And   I delete the newly created customer
    Then  I check that newly created customer is deleted
