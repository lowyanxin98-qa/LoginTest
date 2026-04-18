package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPO2;


public class SimpleTest4 extends BaseTest {
    LoginPO2 loginPO2;


    @BeforeMethod
    public void init(){ //create page object
        loginPO2 = new LoginPO2(driver);
    }

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials(){
        loginPO2.login("tomsmith","SuperSecretPassword!");
        String msg = loginPO2.getMessage();
        Assert.assertTrue(msg.contains("You logged into a secure area!"),("Expected success message not found. Actual message: " + msg));
    }

    @Test
    public void shouldShowErrorForInvalidUsername(){
        loginPO2.login("mary","SuperSecretPassword!");
        String msg = loginPO2.getMessage();
        Assert.assertTrue(msg.contains("Your username is invalid!"),("Expected username error success message not found. Actual message: " + msg));

    }

    @Test
    public void shouldShowErrorForInvalidPassword(){
        loginPO2.login("tomsmith","password123!");
        String msg = loginPO2.getMessage();
        Assert.assertTrue(msg.contains("Your password is invalid!"),("Expected password error success message not found. Actual message: " + msg));

    }

}
