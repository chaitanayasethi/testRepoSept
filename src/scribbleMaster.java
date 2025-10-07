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

public class scribbleMaster {

	public static void main(String[] args) throws InterruptedException {
		 
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.manage().window().maximize();
		
		//scrollToRequiredElementIssueResolved
		driver.get("https://demoqa.com/automation-practice-form");	
		WebElement element = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(200);
	    element.click();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, October 23rd, 2025']"));
	
	    //
	}
	
}
