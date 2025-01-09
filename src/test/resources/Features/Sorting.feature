Feature: Sorting Management

  Scenario: Sort products list by price

    Given I login with username "standard_user" and password "secret_sauce"
    Given Given There are produces more then 3 products in the list
    Given Verify products are not sorting
    When  Select sorting by price from high to low
    Then Verify products are sorting