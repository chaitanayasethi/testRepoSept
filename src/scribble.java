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
		//abc
		//Step 1
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.get("https://login.salesforce.com/");



		//Step 2
		//WHAT AND HOW
		driver.get("https://login.salesforce.com/");
			
		//STEP 3
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hpotter5@test.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("automation@12345");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(5000);
		
		WebElement wb = driver.findElement(By.xpath("//a//span[text()='Accounts']"));
		js.executeScript("arguments[0].click();", wb);
//		
//		Thread.sleep(5000);
//		List<WebElement> webElementList = driver.findElements(By.xpath("//a[contains(text(),'View')]"));
//		System.out.println("COUNT **** " + webElementList.size());
//		for (int i=0; i<webElementList.size();i++){
//			
//
//			System.out.println("findElements displays text of all matching elements, which is, **** " + webElementList.get(i).getText());
//		}

//		driver.get("https://hogwards-dev-ed.develop.lightning.force.com/lightning/r/Lead/00Q2w00000U1CNTEA3/view");
//		Thread.sleep(6000);
//		//getText() method implementation
//		String getTextVaue = driver.findElement(By.xpath("//html//div//h1//slot//lightning-formatted-name")).getText();
//		System.out.println("getTextVaue** " + getTextVaue);
//		
//		String getAttributeVaue = driver.findElement(By.xpath("//html//div//h1//slot//lightning-formatted-name")).getAttribute("slot");
//		System.out.println("getAttributeVaue** " + getAttributeVaue);
//		
//		boolean displayFlag = driver.findElement(By.xpath("//p[text()='Title']//following::p//slot//lightning-formatted-text[text()='CFO']")).isDisplayed();
//		System.out.println("displayFlag** "+ displayFlag);
//	
//		
		driver.quit();		

	}
	
}
