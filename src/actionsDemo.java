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

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		
		//testabcchanges
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
        Actions actions = new Actions(driver);

		driver.manage().window().maximize();

		 // Example 1: Mouse Hover (moveToElement)
        // Real site: https://www.browserstack.com/
        driver.get("https://www.browserstack.com/");
        WebElement liveTab = driver.findElement(By.cssSelector("a[title='Live']"));
        // Move mouse to the "Live" tab to trigger dropdown menu
        actions.moveToElement(liveTab).perform(); // Mouse hover[web:1]

        // Example 2: Click Action
        WebElement getStartedBtn = driver.findElement(By.linkText("Get started free"));
        // Click "Get started free" button using Actions
        actions.moveToElement(getStartedBtn).click().perform(); // Click[web:1]
       
        // Example 3: Double Click (doubleClick)
        // Real site: https://api.jquery.com/dblclick/ (Demo link)
        driver.get("https://api.jquery.com/dblclick/");
        WebElement dblClickBox = driver.findElement(By.cssSelector(".dbl"));
        // Perform double click on element
        actions.doubleClick(dblClickBox).perform(); // Double Click[web:24]

        // Example 4: Right Click (contextClick)
        // Real site: https://demo.guru99.com/test/simple_context_menu.html
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement rightClickBtn = driver.findElement(By.cssSelector(".context-menu-one"));
        // Perform right-click to open context menu
        actions.contextClick(rightClickBtn).perform(); // Right Click[web:2]

        // Example 5: Drag and Drop
        // Real site: https://demoqa.com/droppable
        driver.get("https://demoqa.com/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        // Drag element and drop to target location
        actions.dragAndDrop(source, target).perform(); // Drag and Drop[web:22]

        // Example 6: Click and Hold, Release
        // Drag using low-level events
        actions.clickAndHold(source) // Click and hold source
            .moveToElement(target)     // Move to target
            .release(target)           // Release mouse button
            .perform();                // Sequence done[web:22]

        // Example 7: Keyboard Actions (sendKeys, keyDown, keyUp)
        // Real site: https://www.google.com/
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        // Type text into search box (with SHIFT for uppercase)
        actions.moveToElement(searchBox)
            .click()
            .keyDown(Keys.SHIFT)
            .sendKeys("selenium actions class")
            .keyUp(Keys.SHIFT)
            .sendKeys(Keys.ENTER) // Press Enter
            .perform();           // Keyboard actions[web:8]

        // Clean up
        driver.quit();
	}
	
}
