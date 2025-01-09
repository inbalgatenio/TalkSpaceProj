package Infra.DriverManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManger {

    protected WebDriver driver;

    public DriverManger(){
        initDriver();
    }
    // Setup WebDriver
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void closeDriver(){
            driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
