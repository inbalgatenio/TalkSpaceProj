package Tests;

import TestDef.BaseTest;

public class LoginTests extends BaseTest {
    

    public void user_enters_username_and_password(String username, String password) {
        loginActions.login(username, password);
    }
}
