import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class SimpleTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Open Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openurl() {
        // Open url
        driver.get("https://the-internet.herokuapp.com/tables");


        //Select table, rows.get(i) is using row element
        List<WebElement> rows = driver.findElements(By.cssSelector("#table1 tbody tr"));
        for (int i = 0; i < rows.size(); i++) {
            System.out.println("Row " + (i + 1) + ": " + rows.get(i).getText());
        }

        List<WebElement> column = driver.findElements(By.cssSelector("#table1 tbody th"));
        for (int i = 0; i < column.size(); i++) {
            System.out.println("column " + (i + 1) + ": " + column.get(i).getText());
        }

        //check if its exist
        boolean found = driver.findElement(By.id("table1")).getText().contains("Smith John");

        Assert.assertTrue(found, "Smith John should be in the table");

        }

        }





