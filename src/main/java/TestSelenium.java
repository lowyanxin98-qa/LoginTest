import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestSelenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationexercise.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                .sendKeys("abc@hotmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("lalalala");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")))
                .click();
    }
}