package Infra.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends GeneralPage{

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement submit;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        url = "https://www.saucedemo.com/";
    }

    public void sendUserName(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void sendPasswordInput(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
    }
}
