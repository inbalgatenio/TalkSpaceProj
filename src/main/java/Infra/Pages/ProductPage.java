package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends GeneralPage{

    @FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']")
    private List<WebElement> producstList;

    @FindBy(xpath = "//div[@class='inventory_list']//div[@class='inventory_item']//button")
    private List<WebElement> productsButtons;

    @FindBy(xpath = "//*[@id='inventory_container']//div[contains(@class, 'inventory_item_price')]")
    List<WebElement> priceElements;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cartLink;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement cartNumIcon;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select")
    private WebElement SortProducts;

    public ProductPage(WebDriver driver) {
        super(driver);
        url = "https://www.saucedemo.com/inventory.html";
    }

    public List<WebElement> getProductsList(){
        return producstList;
    }

    public List<WebElement> getPrices(){
        return priceElements;
    }

    public void selectSortOptionByText(int index) {
        Select select = new Select(SortProducts);
        select.selectByIndex(index);
    }

    public void clickOnCartLink(){
        cartLink.click();
    }

    public int getCartProductsSum(){
        return Integer.parseInt(cartNumIcon.getText());
    }

    public List<WebElement> getAllButtons(){
        return productsButtons;
    }
}
