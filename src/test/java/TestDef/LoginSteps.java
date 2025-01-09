package TestDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;


public class LoginSteps extends BaseTest {

    @Given("I login with username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginActions.login(username, password);
    }

    @AfterAll
    public static void closePage(){
        closeBrowser();
    }

}
