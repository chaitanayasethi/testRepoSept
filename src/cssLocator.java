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

public class cssLocator {

	public static void main(String[] args) throws InterruptedException {
		 
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.manage().window().maximize();
		
		//scrollToRequiredElementIssueResolved
		driver.get("https://test.salesforce.com/?locale=in");	
        //IDSelector
		driver.findElement(By.cssSelector("#username")).sendKeys("kishoresv988@gmail.com");
        //ClassSelector
        driver.findElement(By.cssSelector(".password")).sendKeys("Winter@2025");
        //AttributeSelector
        driver.findElement(By.cssSelector("input[id='Login']")).click();
		
        
			}
	
}
