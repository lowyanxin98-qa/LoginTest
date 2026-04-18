package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPO {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
        public LoginPO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //locator
        By username = By.cssSelector("#username");
        By password = By.cssSelector("#password");
        By loginBtn = By.xpath("//button[@type='submit']");
        By flashMsg = By.cssSelector("#flash");
        By logoutBtn = By.cssSelector(".button");

    //actions
    public void login(String user, String pass){
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public String getMessage(){
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(flashMsg));
        return errorMessage.getText();

    }
    public void logout(){
        driver.findElement(logoutBtn).click();
    }
}
