package Infra.ElementsClass;

import org.openqa.selenium.WebElement;

public class Product {
    private final String name;
    private final String price;
    // Constructor to initialize the Product object
    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    // Getters for the fields
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public boolean isIdentical(Product otherProduct) {
        return this.name.equals(otherProduct.getName()) &&
                this.price.equals(otherProduct.getPrice());
    }
}


