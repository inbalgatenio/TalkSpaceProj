package Infra.logic;

import Infra.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginActions {

    private final LoginPage loginPage;

    public LoginActions(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    // Login method
    public void login(String username, String password) {
        loginPage.navigateToPage();
        loginPage.sendUserName(username);
        loginPage.sendPasswordInput(password);
        loginPage.clickSubmit();
    }
}
