package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartPage extends GeneralPage{

    @FindBy(xpath = "//div[@class='cart_list']//div[@class='cart_item']")
    private List<WebElement> cartList;

    public CartPage(WebDriver driver) {
        super(driver);
        url = "https://www.saucedemo.com/cart.html";
    }

    public int getNumOfCartProdInList(){
        return cartList.size();
    }

    public List<WebElement> getProductsCartList(){
        return cartList;
    }
}
