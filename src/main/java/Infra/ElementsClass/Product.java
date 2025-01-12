package Infra.ElementsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Product {
    WebElement element;
    private String name;
    private String desc;
    private String price;
    private String buttonId;

    public Product(WebElement element) {
        this.element = element;
    }

    // Getters for the fields
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getPrice() {
        return price;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setProduct(){
        price = element.findElement(By.xpath(".//div[contains(@class, 'inventory_item_price')]")).getText();
        name = element.findElement(By.xpath(".//div[contains(@class, 'inventory_item_name')]")).getText();
        desc = element.findElement(By.xpath(".//div[contains(@class, 'inventory_item_desc')]")).getText();
        buttonId = element.findElement(By.xpath(".//button")).getAttribute("id");
    }
}
