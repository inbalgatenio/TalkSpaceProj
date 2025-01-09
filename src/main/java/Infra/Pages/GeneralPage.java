package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {

    public WebDriverWait wait;
    protected WebDriver driver;
    protected String url;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initializes all the WebElements declared in the page class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // WebDriverWait for waiting elements to be visible or clickable
    }

    public void navigateToPage() {
        driver.get(url);
    }
}
