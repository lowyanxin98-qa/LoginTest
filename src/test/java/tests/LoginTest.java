package tests;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPO;

public class LoginTest {
    WebDriver driver;
    LoginPO loginPO;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPO = new LoginPO(driver);
    }

    @Test(priority = 1)
    public void Validlogin(){
        loginPO.login("tomsmith","SuperSecretPassword!");
        String msg = loginPO.getMessage();
        System.out.println(msg);
        Assert.assertTrue(msg.contains("You logged into a secure area!"));


    }

    @Test(priority = 2)
    public void InvalidUsername(){
        loginPO.login("fakeName","nopassword!");
        String msg = loginPO.getMessage();
        System.out.println(msg);
        Assert.assertTrue(msg.trim().contains("Your username is invalid!"));

    }

    @Test(priority = 4)
    public void InvalidPassword(){
        loginPO.login("tomsmith","");
        String msg = loginPO.getMessage();
        System.out.println(msg);
        Assert.assertTrue(msg.trim().contains("Your password is invalid!"));

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
