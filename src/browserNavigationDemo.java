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

public class browserNavigationDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// Navigate to the first URL
        driver.get("https://www.example.com");
        System.out.println("First Page Title: " + driver.getTitle());

        // Navigate to a second URL
        driver.navigate().to("https://www.selenium.dev");
        System.out.println("Second Page Title: " + driver.getTitle());

        // Go back to the previous page
        driver.navigate().back();
        System.out.println("After Back, Title: " + driver.getTitle());

        // Go forward in browser history
        driver.navigate().forward();
        System.out.println("After Forward, Title: " + driver.getTitle());

        // Refresh the current page
        driver.navigate().refresh();
        System.out.println("After Refresh, Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
	}
	
}
