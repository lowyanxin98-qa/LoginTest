package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPO2;


public class SimpleTest4 extends BaseTest {
    LoginPO2 loginPage;


    @BeforeMethod
    public void init(){ //create page object
        loginPage = new LoginPO2(driver);

    }

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials(){
        loginPage.login("tomsmith","SuperSecretPassword!");
        String msg = loginPage.getMessage();
        Assert.assertTrue(msg.contains("You logged into a secure area!"),
        ("Expected success message not found. Actual message: " + msg));
    }

    @Test
    public void shouldShowErrorForInvalidUsername(){
        loginPage.login("mary","SuperSecretPassword!");
        String actualMsg = loginPage.getMessage();
        Assert.assertTrue(actualMsg.contains("Your username is invalid!"),
        ("Expected username error success message not found. Actual message: " + actualMsg));

    }

    @Test
    public void shouldShowErrorForInvalidPassword(){
        loginPage.login("tomsmith","password123!");
        String actualMsg = loginPage.getMessage();
        Assert.assertTrue(actualMsg.contains("Your password is invalid!"),("Expected password error success message not found. Actual message: " + actualMsg));

    }

}
