Feature: Cart Management

  Scenario: Adding a new product to cart from inventory page

    Given I login with username "standard_user" and password "secret_sauce"
    Given Verify product can be added
    Given Check number of products in the cart
    When  I add product to cart
    And   Verify Button changed in product page
    And   Verify Button changed in cart page
    And   Cart products increased by 1
    Then  The product was added to cart with the right details