
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class salesforceAccountNew {

    public static void verifyAccountNameError() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://login.salesforce.com/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kishoresv988@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Winter@2025");
        driver.findElement(By.xpath("//input[@name='Login']")).click();
        Thread.sleep(5000);

        // Navigate to Accounts
        WebElement wb = driver.findElement(By.xpath("//a/span[text()='Accounts']"));
        js.executeScript("arguments[0].click();", wb);
        Thread.sleep(3000);

        // Click New button
        driver.findElement(By.xpath("//div[text()='Import']/preceding::div[text()='New']")).click();

        // Try Save without Account Name
        driver.findElement(By.xpath("//button[@name='CancelEdit']/following::button[@name='SaveEdit']")).click();

        // Capture error message
        String actualTitle = driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div//span")).getText();

        // Assert
        Assert.assertEquals(actualTitle, "Complete this field.", "The error message is not as expected");

        System.out.println("✅ Test Passed! Error verified: " + actualTitle);

        driver.quit();
    }

    
}
