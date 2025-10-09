import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class demoJava {

    public static void main(String[] args) {

        // Step 1: Launch Chrome
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
       

        // Step 2: Open DemoQA Practice Form
        driver.get("https://demoqa.com/automation-practice-form");

        // Step 3: Fill the form
        driver.findElement(By.xpath("(//label[text()='Name']/..//following-sibling::div//input)[1]"))
                .sendKeys("Kishore"); // First Name
        driver.findElement(By.xpath("(//label[text()='Name']/..//following-sibling::div//input)[2]"))
                .sendKeys("SV"); // Last Name
        driver.findElement(By.xpath("//label[text()='Email']/..//following-sibling::div//input"))
                .sendKeys("kishoresv988@gmail.com");
        driver.findElement(By.xpath("//label[text()='Male']")).click();
        // Select Male radio button
        // WebElement maleRadio =driver.findElement(By.xpath("//label[text()='Male']"));
        // maleRadio.click();
        // driver.findElement(By.xpath("//label[text()='Female']/preceding-sibling::input")).click();
        driver.findElement(By.xpath("//label[text()='Mobile']/..//following-sibling::div//input"))
                .sendKeys("9886022333");

        // Select Gender = Male
        /*
         * WebElement genderMale = driver.findElement(
         * By.xpath(
         * "//label[text()='Gender']/following-sibling::div//label[text()='Male']")
         * );
         * genderMale.click();
         */

        // Subjects input (auto-suggest)
        WebElement subjectBox = driver
                .findElement(By.xpath("//label[text()='Subjects']/..//following-sibling::div//input"));
        subjectBox.sendKeys("Maths");
        // subjectBox.sendKeys("\n"); // Press Enter to select suggestion

        // Current Address
        driver.findElement(By.xpath("//label[text()='Current Address']/..//following-sibling::div/textarea"))
                .sendKeys("Bangalore, India");

        //driver.findElement(By.xpath("//button[text()='Submit']")).click();
        // Step 4: Click Submit button
        WebElement submitBtn = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitBtn);

        // Step 5: Close Browser
         //driver.quit();
    }
}
