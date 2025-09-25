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

public class scribble {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * TEST CASE TO LOGIN TO SALESFORCE
		 * 1. Launch the Browser (Chrome)
		 * 2. Navigate to URL => .get()
		 * 3. Enter the username => .sendKeys()
		 * 4. Enter the password
		 * 5. Click on Login button
		 * 6. Verify the user is able to see the HOME tab
		 */
		
		//Step 1
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		//Step 2
		//WHAT AND HOW
		driver.get("https://login.salesforce.com/");
			
		//STEP 3
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter5@test.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("automation@12345");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.quit();		

	}
	
}
