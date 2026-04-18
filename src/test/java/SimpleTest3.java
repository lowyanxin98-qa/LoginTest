import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleTest3 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/login");
    }

   // @Test(priority = 1)
    //public void login() {
    //    driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
    //    driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
    //    driver.findElement(By.xpath("//button[@type='submit']")).click();
   // }

   // @Test(priority = 2)
    //public void SuccessMessage(){

            //must store text into something to print
     //       WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash")));
    //        String messageText = message.getText();
     //       System.out.println(messageText);
      //      Assert.assertTrue(messageText.contains("You logged into a secure area!"));



    //}

    //@Test(priority = 3)
    //public void logOut(){
    //    driver.findElement(By.cssSelector(".button")).click();

    //}

    @Test(priority = 2)
    public void loginInvalidCredential() {

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#username")));
        username.sendKeys("hello");
        driver.findElement(By.cssSelector("#password")).sendKeys("password!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#flash")));
        String errorText = errorMessage.getText();
        System.out.println(errorText);
        Assert.assertTrue(errorText.contains("Your username is invalid!"));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }




}
