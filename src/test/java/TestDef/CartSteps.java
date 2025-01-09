package TestDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSteps extends BaseTest{

    @And("Cart products increased by 1")
    public void cart_products_increased_by_one() {
        productActions.checkNumberOfProductsInCart(1);
    }

    @Then("The product was added to cart with the right details")
    public void theProductWasAddedToCart() {

        Assert.assertTrue(productActions.isButtonDisplayedInCart
                        (ProductSteps.removeStr + ProductSteps.productName),
                "Can't find product");

        Assert.assertTrue(productActions.verifyCartAndInventoryProductsIdentical(ProductSteps.removeStr + ProductSteps.productName));
    }
}
