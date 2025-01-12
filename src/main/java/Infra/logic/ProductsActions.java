package Infra.logic;

import Infra.ElementsClass.Product;
import Infra.ElementsClass.ProductManage;
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

    public void goToProductsPage() {
        prodPage.navigateToPage();
    }

    public void checkNumberOfProductsInCart(int i) {
        assert prodPage.getCartProductsSum() == prodSum + i;
    }

    public int checkNumOfProductsInList() {
        return prodPage.getProductsList().size();
    }

    public boolean isProductSortedByPrice() {
        ProductManage productManage = new ProductManage();
        List<Product> prodList = productManage.setProductsList(prodPage.getProductsList());
        return productManage.areProductListIdentical(prodPage.getProductsList(),
                productManage.sortProductsByPriceDesc(prodList));
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
        return (isButtonDisplayedInProducts(oldButtonId) || isButtonDisplayedInProducts(newButtonId));
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
            String butId = button.getAttribute("id");
            if (buttonId.equals(butId)) {
                Product product = new Product(element);
                product.setProduct();
                return product;
            }
        }
        return null;
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

    public boolean verifyCartAndInventoryProductsIdentical(String buttonId){
        ProductManage productManag = new ProductManage();
        cartPage.navigateToPage();
        Product product1 = getProductByButtonId(cartPage.getProductsCartList(), buttonId);
        prodPage.navigateToPage();
        Product product2 = getProductByButtonId(prodPage.getProductsList(), buttonId);
        return productManag.areProductsIdentical(product1, product2);
    }

}
