package TestDef;

import Infra.DriverManagment.DriverManger;
import Infra.logic.LoginActions;
import Infra.logic.ProductsActions;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver;
    protected static DriverManger driverManger = new DriverManger();
    protected  LoginActions loginActions;
    protected  ProductsActions productActions;

    public BaseTest() {
        driver = driverManger.getDriver();
        loginActions = new LoginActions(driver);
        productActions = new ProductsActions(driver);
    }

    public static void closeBrowser() {
        try {
            if (driver != null) {
                driverManger.closeDriver();
            }
        } catch (Exception e) {
            System.err.println("Error during close browser: " + e.getMessage());
        }
    }
}
