package Infra.ElementsClass;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManage {

    public List<Product> setProductsList(List<WebElement> prodElemList) {
        List<Product> prodList = new ArrayList<>();
        for (WebElement elemProd : prodElemList) {
            Product prod = new Product(elemProd);
            prod.setProduct();
            prodList.add(prod);
        }
        return prodList;
    }

    public List<Product> sortProductsByPriceDesc(List<Product> prodElemList) {
        prodElemList.sort(new Comparator<>() {
            @Override
            public int compare(Product p1, Product p2) {
                try {
                    // Parse price from string to double, removing "$"
                    double price1 = Double.parseDouble(p1.getPrice().replace("$", "").trim());
                    double price2 = Double.parseDouble(p2.getPrice().replace("$", "").trim());

                    // Compare prices in descending order
                    return Double.compare(price2, price1);
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing price: " + e.getMessage());
                    return 0; // Treat as equal if parsing fails
                }
            }
        });
        return prodElemList;
    }

    public boolean areProductListIdentical(List<WebElement> prodEleList, List<Product> sortedProdList){
        List<Product> prodList = setProductsList(prodEleList);
        if (sortedProdList == null) return false;
        try {
            for (int i = 0; i < prodList.size(); i++) {
                if (!areProductsIdentical(prodList.get(i), sortedProdList.get(i))) return false;
            }
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean areProductsIdentical(Product product1, Product product2) {
        if (product1 == null || product2 == null) {
            return false;
        }
        return product1.getName().equals(product2.getName()) &&
                product1.getPrice().equals(product2.getPrice()) &&
                product1.getButtonId().equals(product2.getButtonId());
    }
}
