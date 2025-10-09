import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Scribble {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();

        // Step 1: Login
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kishoresv988@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("your-password-here");
        driver.findElement(By.xpath("//input[@name='Login']")).click();

        Thread.sleep(5000);

        // Step 2: Navigate to Accounts
        WebElement wb = driver.findElement(By.xpath("//a/span[text()='Accounts']"));
        js.executeScript("arguments[0].click();", wb);
        Thread.sleep(3000);

        // Step 3: Click New
        driver.findElement(By.xpath("//div[text()='Import']/preceding::div[text()='New']")).click();

        // Step 4: Click Save without entering Account Name
        driver.findElement(By.xpath("//button[@name='CancelEdit']/following::button[@name='SaveEdit']")).click();

        // Step 5: Capture the error message (Account Name required)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='Account Name']/following-sibling::div//span")));

        String actualError = errorMsg.getText();
        String expectedError = "Complete this field.";

        // Step 6: Assert
        Assert.assertEquals(actualError, expectedError, "The error message is not as expected!");

        System.out.println("✅ Test Passed! Error message verified: " + actualError);

        driver.quit();
    }
}
