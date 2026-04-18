package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPO2 {
    WebDriver driver;
    WebDriverWait wait;


//constructor - how selenium page receive and share the browser
    public LoginPO2(WebDriver driver){
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

//locator
    By username = By.cssSelector("#username");
    By password = By.cssSelector("#password");
    By loginButton = By.xpath("//button[@class='radius']");
    By flashMessage = By.cssSelector("#flash");




//action
    public void login(String user, String key){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(key);
        driver.findElement(loginButton).click();

    }

    public String getMessage() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return message.getText();

    }
}
