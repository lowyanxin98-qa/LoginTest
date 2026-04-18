import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class SimpleTest1 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void loginPage() {
        // Open Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("wrongusername");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            String messageText = message.getText();
            System.out.println(messageText);

            Assert.assertTrue(messageText.contains("You logged into a secure area!"));

        } catch (Exception e) {
            Assert.fail("Success message not found");
        }



    }

}















