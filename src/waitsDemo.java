import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.itextpdf.text.List;

public class waitsDemo {
//abcd

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// Open a Website
        driver.get("https://www.google.com");
        
		// IMPLICIT WAIT Example
        // Applies to all element searches globally
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Will wait up to 10 seconds for the element to appear before throwing an exception
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium Implicit Wait Example");

        // EXPLICIT WAIT Example
        // Applies to specific element and condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement firstResult = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='selenium implicit wait example']"))
        );
        firstResult.click();
        /*
         * Other Explicit Wait Methods
         * elementToBeClickable
         * textToBePresentInElementLocated
         * alertIsPresent
         */

        // THREAD.SLEEP Example
        // Pauses execution statically (not recommended for dynamic waits!)
        Thread.sleep(5000);  // Wait for 5 seconds

        // Close the browser
        //driver.quit();
        
        
        /*
         * Implicit Wait: Sets a default wait time for every element search until the WebDriver session ends. Useful for simple web pages, but can slow down test execution if misused.
         * Explicit Wait: Waits for specified conditions (like element visibility, clickability) for certain elements. Use for dynamic elements and finer control.
         * Thread.sleep: Pauses code regardless of web page status. Use only when other waits can't solve the problem, as it can unnecessarily slow tests.
         */
	}
	
}
