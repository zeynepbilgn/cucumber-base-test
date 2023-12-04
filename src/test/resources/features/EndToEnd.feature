@e2e
Feature: End-to-end automation testing for basic functions

  Scenario: Add product to cart testing
    When User goes to home page
    And User accepts cookies
    Then Verify user is on homepage
    And User searches for phone
    And User selects a random product
    Then User adds the product to the cart