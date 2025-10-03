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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import com.itextpdf.text.List;

public class assertsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		
		/*
		 * assertTrue
			Verify a boolean condition is true.
			Example: Verify if a Checkbox is selected after
			clicking on it.	
		 	This asserts the checkbox selection is true,
		 	else test fails immediately.
		 */
		driver.get("https://www.lambdatest.com/selenium-playground/checkbox-demo");
		WebElement checkbox = driver.findElement(By.xpath("//*[text()='Click on check box']//input"));
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");

		/*
		 * assertFalse
		 * Verify a boolean condition is false.
		 * Example: Check if a previously selected radio button becomes unselected when another is clicked.
		 * It verifies that the male radio button is unselected after selecting female
		 */
		driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");
		WebElement maleRadioBtn = driver.findElement(By.cssSelector("input[value='Male'][name='optradio']"));
		maleRadioBtn.click();
		Assert.assertTrue(maleRadioBtn.isSelected());
		WebElement femaleRadioBtn = driver.findElement(By.cssSelector("input[value='Female'][name='optradio']"));
		femaleRadioBtn.click();
		Assert.assertFalse(maleRadioBtn.isSelected(), "Male radio button is still selected");

		/*
		 * assertEquals
		 * Compare actual and expected values (Strings, numbers, etc).
		 * Example: Check page title on BrowserStack homepage.
		 * This asserts that the title exactly matches the
		 *expected string.
		 */
		driver.navigate().to("https://www.browserstack.com/");
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Most Reliable App & Cross Browser Testing Platform | BrowserStack", "The page title is not as expected");

		/*assertNotNull / assertNull
		 * Check if an element or object is null or not.
		 * For instance, ensure an element is present on a page.
		   If element is null, assertion fails.
		 */
		WebElement element = driver.findElement(By.id("elementID"));
		Assert.assertNotNull(element, "Element should be present on the page");

		/*
		 * Soft Assertions allow tests to continue even if an assertion fails.
		 * This is useful to check multiple conditions in one test method without stopping immediately.
		 */
		driver.get("https://www.lambdatest.com/selenium-playground/radiobutton-demo");

        SoftAssert softAssert = new SoftAssert();

        // Verify the page header text
        String headerText = driver.findElement(By.tagName("h1")).getText();
        softAssert.assertEquals(headerText, "Radio Button Demo", "Header text verification failed");
        // The above soft assert checks the header text, but if it fails, test continues

        // Select male radio button and verify it is selected
        WebElement maleRadioBtn1 = driver.findElement(By.cssSelector("input[name='optradio'][value='Male']"));
        maleRadioBtn.click();
        softAssert.assertTrue(maleRadioBtn1.isSelected(), "Male radio button should be selected");
        // This soft assert verifies that the Male radio button gets selected

        // Select female radio button and verify male radio button is not selected
        WebElement femaleRadioBtn1 = driver.findElement(By.cssSelector("input[name='optradio'][value='Female']"));
        femaleRadioBtn1.click();
        softAssert.assertFalse(maleRadioBtn.isSelected(), "Male radio button should be deselected");
        // This checks that after selecting Female, Male radio button is deselected

        // Check if the Get Checked Value button exists and verify its text
        WebElement getCheckedValueBtn = driver.findElement(By.id("buttoncheck"));
        softAssert.assertEquals(getCheckedValueBtn.getText(), "Get Checked Value", "Button text mismatch");

        // Trigger all soft assertion checks
        softAssert.assertAll();

	}
	
}
