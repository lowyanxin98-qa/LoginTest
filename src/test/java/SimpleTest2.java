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



public class SimpleTest2 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void
    setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    public void testLogin() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        try {
            WebElement Message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            String successMessage = Message.getText();
            System.out.println(successMessage);

            Assert.assertTrue(successMessage.contains("You logged into a secure area!"));

        } catch (Exception e) {
            Assert.fail("success message not found");
        }


        // Get the actual URL
        String actualUrl = driver.getCurrentUrl();

        // Define the expected URL
        String expectedUrl = "https://the-internet.herokuapp.com/secure";

        // Verify using JUnit or TestNG assertions
        Assert.assertEquals(actualUrl, expectedUrl, "URL verification passed!");


        driver.findElement(By.cssSelector(".button")).click();


        try {
            WebElement message = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
            );

            String logoutMessage = message.getText();
            System.out.println(logoutMessage);

            Assert.assertTrue(logoutMessage.contains("You logged out of the secure area!"));

        } catch (Exception e) {
            Assert.fail("success message not found");
        }
    }
}


