import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.itextpdf.text.List;

public class locatorsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// 1. ID Locator Example
        // Website: https://demoqa.com/text-box
        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName")); // Locate by unique ID
        fullName.sendKeys("John Doe");

        // 2. Name Locator Example
        // Website: https://www.google.com/
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q")); // Locate by name attribute
        searchBox.sendKeys("Selenium WebDriver");

        // 3. Class Name Locator Example
        // Website: https://demoqa.com/checkbox
        driver.get("https://demoqa.com/checkbox");
        WebElement expandIcon = driver.findElement(By.className("rct-icon-expand-close")); // Locate by class name
        expandIcon.click();

        // 4. Link Text Locator Example
        // Website: https://demoqa.com/
        driver.get("https://demoqa.com/");
        WebElement link = driver.findElement(By.linkText("Elements")); // Locate hyperlink by exact visible text
        link.click();

        // 5. Partial Link Text Locator Example
        // Website: https://demoqa.com/
        driver.get("https://demoqa.com/");
        WebElement partialLink = driver.findElement(By.partialLinkText("Forms")); // Locate hyperlink by part of text
        partialLink.click();


        // 6. Tag Name Locator Example
        // Website: https://demoqa.com/links
        driver.get("https://demoqa.com/links");
        java.util.List<WebElement> allLinks = driver.findElements(By.tagName("a")); // Locate all 'a' tag hyperlinks
        System.out.println("Total links: " + allLinks.size());

        // 7. XPath Locator Example
        // Website: https://demoqa.com/text-box
        driver.get("https://demoqa.com/text-box");
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']")); // Locate using XPath
        currentAddress.sendKeys("123 Test Street");

        // Cleanup
        driver.quit();
	}
	
}
