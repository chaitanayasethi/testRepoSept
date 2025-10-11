import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.itextpdf.text.List;

public class webElementsInteractionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;

		//Text Box
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium WebDriver tutorials");
		searchBox.submit();
		
		//Button
		driver.get("https://www.youtube.com");
		WebElement searchBox1 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		searchBox1.sendKeys("Automation testing");
		WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
		searchButton.click();
		
		//Link
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		WebElement featuredArticleLink = driver.findElement(By.linkText("Featured content"));
		featuredArticleLink.click();

		//Checkbox
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox1 = driver.findElement(By.xpath("//input[1]"));
		if (!checkbox1.isSelected()) {
		    checkbox1.click();
		}

		//RadioButton
		driver.get("https://demoqa.com/radio-button");
		WebElement yesRadio = driver.findElement(By.cssSelector("label[for='yesRadio']"));
		yesRadio.click();

		//Dropdown
		driver.get("https://demoqa.com/select-menu");
		WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(dropdown);
		abcdselect.selectByVisibleText("Green");

		//FileUpload
		driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        // Use the Mac full file path here, for example /Users/username/Documents/sample.pdf
        uploadInput.sendKeys("/Users/csethi/Desktop/uploadFile.png");
        driver.findElement(By.id("file-submit")).click();

		//Alert
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//Table
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		for (WebElement row : rows) {
		    System.out.println(row.getText());
		}



		//Auto-Suggestion
		driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
        // Locate the search box and type text
        WebElement searchBox2 = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox2.sendKeys("selenium");
        Thread.sleep(2000); // Wait for autosuggestions to appear (use explicit waits for production)
        // Arrow down to first suggestion and hit Enter
        searchBox2.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000); // Optional wait
        searchBox2.sendKeys(Keys.ENTER);
	}
	
}
