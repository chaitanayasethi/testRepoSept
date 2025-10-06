import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.exception.NotFoundException;
import com.itextpdf.text.List;

public class exceptionHandling {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//driver.get("https://www.google.com/");
		/*
 		EXCEPTION AND EXCEPTION HANDLING
 		
		In Selenium WebDriver, an exception is an 
		event that occurs during the execution of 
		a script that disrupts the normal flow of 
		instructions, usually due to unexpected 
		conditions like missing elements, timeouts,
		 or invalid actions. Exceptions cause the 
		 test to fail unless properly handled.

		Exception handling in Selenium refers to
		coding techniques that anticipate these
		errors and manage them gracefully to keep
		the test running or fail it cleanly with
		useful information.

		Key Points on Exception Handling:
		Try-Catch Blocks: Wrap interactions in
		try-catch to catch exceptions and handle
		them within the catch block, e.g.,

		try {
		    WebElement element = driver.findElement(By.id("sample"));
		    element.click();
		} catch (NoSuchElementException e) {
		    System.out.println("Element not found. Handling gracefully.");
		}
		
		Why Handle Exceptions in Selenium?
		To prevent abrupt script termination.
		To log meaningful messages for debugging.
		To enable recovery such as retries or alternative flows.
		To create reliable and maintainable automation scripts.
		
		Proper exception handling makes Selenium tests more robust, stable, and easier to maintain by accommodating dynamic web conditions and unexpected changes gracefully.	
	*/	
		
		//NoSuchElementException
//		try {
//		    WebElement fakeElement = driver.findElement(By.id("nonExistentElementId"));
//		    fakeElement.click();
//		} catch (Exception e) {
//		    System.out.println("Exception caught: " + e.getMessage());
//		    driver.quit();
//		}

		/*StaleElementReferenceException
		Occurs when an element previously located is no
		longer attached to the DOM, often due to page
		reload or DOM update.
		*/
//		try {
//		    driver.get("http://the-internet.herokuapp.com/dynamic_controls");
//		    WebElement checkbox = driver.findElement(By.id("checkbox"));
//		    driver.findElement(By.xpath("//button[text()='Remove']")).click();
//		    // DOM changes, element becomes stale
//		    checkbox.click();
//		} catch (StaleElementReferenceException e) {
//		    System.out.println("StaleElementReferenceException caught: " + e.getMessage());
//		}
		
		//ElementNotInteractableException
		try {
		    driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		    WebElement input = driver.findElement(By.cssSelector("#input-example input"));
		    input.sendKeys("test"); // Input is initially disabled
		} catch (ElementNotInteractableException e) {
		    System.out.println("ElementNotInteractableException caught: " + e.getMessage());
		}

		//NoSuchFrameException
		try {
		    driver.get("https://www.w3schools.com/html/html_iframe.asp");
		    // Try switching to a frame that does not exist
		    driver.switchTo().frame("nonExistentFrame");
		} catch (NoSuchFrameException e) {
		    System.out.println("NoSuchFrameException caught: The frame was not found on the page.");
		}
		
		//NoSuchSessionException
		try {
            driver.get("https://www.google.com");
            driver.quit();  // Session terminated

            // Trying to interact after quit will cause NoSuchSessionException
            driver.get("https://www.youtube.com");
		}catch (Exception e) {
            System.out.println("Other exception: " + e.getMessage());
        }
        }

	}
	
	
	


