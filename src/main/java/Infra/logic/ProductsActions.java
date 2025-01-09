package Infra.logic;

import Infra.ElementsClass.Product;
import Infra.Pages.CartPage;
import Infra.Pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsActions {

    int prodSum;
    ProductPage prodPage;
    CartPage cartPage;
    Product product;
    Product productCart;

    public ProductsActions(WebDriver driver) {
        prodPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }


    public int CheckNumOfProdInCart() {
        goToCartPage();
        prodSum = cartPage.getNumOfCartProdInList();
        return prodSum;
    }

    public void goToCartPage() {
        prodPage.clickOnCartLink();
    }

    public void checkNumberOfProductsInCart(int i) {
        assert prodPage.getCartProductsSum() == prodSum + i;
    }

    public int checkNumOfProductsInList() {
        return prodPage.getProductsList().size();
    }

    public boolean isProductSortedByPrice(boolean ascending) {
        // Extract prices as a list of doubles
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : prodPage.getPrices()) {
            String priceText = priceElement.getText().replace("$", "").trim(); // Remove "$" if present
            prices.add(Double.parseDouble(priceText));
        }

        // Create a copy of the original list to avoid modifying it
        List<Double> sortedPrices = new ArrayList<>(prices);

        // Sort the copied list in the desired order
        if (ascending) {
            Collections.sort(sortedPrices);
        } else {
            Collections.sort(sortedPrices, Collections.reverseOrder());
        }

        // Compare the sorted list with the original list
        return prices.equals(sortedPrices);
    }

    public void selectSortHighToLow(){
        prodPage.selectSortOptionByText(3);
    }

    public boolean isButtonDisplayedInProducts(String buttonId) {
        return isButtonDisplayed(getElementByButtonNameFromProducts(buttonId));
    }

    public boolean isButtonDisplayedInCart(String buttonId) {
        return isButtonDisplayed(getElementByButtonNameFromCart(buttonId));
    }

    public boolean isButtonDisplayed(WebElement button) {
        try {
            return button != null && button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isButtonChanged(String oldButtonId, String newButtonId) {
        return isButtonDisplayedInProducts(oldButtonId) || isButtonDisplayedInProducts(newButtonId);
    }

    public WebElement getElementByButtonNameFromProducts(String buttonId){
        return getElementByButtonName(prodPage.getProductsList(), buttonId);
    }

   public WebElement getElementByButtonNameFromCart(String buttonId){
        return getElementByButtonName(cartPage.getProductsCartList(), buttonId);
    }

    public WebElement getElementByButtonName(List<WebElement> products, String buttonId) {
        for (WebElement element : products) {
            WebElement button = element.findElement(By.xpath(".//button"));
        if (buttonId.equals(button.getAttribute("id"))) {
            return button;
            }
        }
        // Return null if no matching element is found
        return null;
    }

    public Product getProductByButtonId(List<WebElement> products, String buttonId){
        for (WebElement element : products) {
            WebElement button = element.findElement(By.xpath(".//button"));
            if (buttonId.equals(button.getAttribute("id"))) {
                String price = element.findElement(By.xpath(".//div[contains(@class, 'inventory_item_price')]")).getText();
                String name = element.findElement(By.xpath(".//div[contains(@class, 'inventory_item_name')]")).getText();
                return new Product(name, price);
            }
        }
        return null;
    }

    public boolean verifyCartAndInventoryProductsIdentical(String buttonId){
        cartPage.navigateToPage();
        Product productCart  = getProductByButtonId(cartPage.getProductsCartList(), buttonId);
        prodPage.navigateToPage();
        Product productInventory = getProductByButtonId(prodPage.getProductsList(), buttonId);
        return areProductsIdentical(productCart, productInventory);
    }

    public boolean areProductsIdentical(Product product1, Product product2) {
        return product1.isIdentical(product2);
    }

    public void clickOnAddToCart(String id) {
        try {
            prodPage.navigateToPage();
            getElementByButtonNameFromProducts(id).click();
        } catch (Exception e) {
            System.out.println("Can't find button to click");
            assert false;
        }
    }
}
