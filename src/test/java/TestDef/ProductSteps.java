package TestDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductSteps extends BaseTest {

    public int prodSum;
    public static final String addToStr = "add-to-cart-";
    public static final String removeStr = "remove-";
    public static final String productName = "sauce-labs-backpack";

    @Given("Verify product can be added")
    public void there_are_produces_in_the_catalog_to_add_cart() {
        Assert.assertTrue(productActions.isButtonDisplayedInProducts(addToStr + productName),
                "Product can't be added");
    }

    @Given("Check number of products in the cart")
    public void Check_number_of_products_in_the_cart() {
        prodSum = productActions.CheckNumOfProdInCart();
    }

    @When("I add product to cart")
    public void i_add_product_to_cart() {
        productActions.clickOnAddToCart(addToStr + productName);
    }

    @And("Verify Button changed in product page")
    public void verify_button_changed_in_products() {
        productActions.goToProductsPage();
        Assert.assertTrue(productActions.isButtonChanged(removeStr + productName, addToStr + productName));
    }

    @And("Verify Button changed in cart page")
    public void verify_button_changed_in_cart() {
        productActions.goToCartPage();
        Assert.assertTrue(productActions.isButtonChanged(removeStr + productName, addToStr + productName));
    }

    @Given("Given There are produces more then {int} products in the list")
    public void verify_number_Of_Products(int i) {
        Assert.assertTrue(productActions.checkNumOfProductsInList() > i);
    }

    @Given("Verify products are not sorting")
    public void verifyProductsAreNotSorting() {
        Assert.assertFalse(productActions.isProductSortedByPrice());
    }

    @When("Select sorting by price from high to low")
    public void selectSortingByPriceFromHighToLow() {
        productActions.selectSortHighToLow();
    }

    @Then("Verify products are sorting")
    public void verifyProductsAreSorting() {
        Assert.assertTrue(productActions.isProductSortedByPrice());
    }
}
