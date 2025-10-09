import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class iFramesDemo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);


		driver.get("https://demoqa.com/frames");
		Thread.sleep(1000);
		//System.out.println("fetched text ** "+driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText());
		
		//switch to iFrame using iFrame name or ID
		driver.switchTo().frame("frame100");
		System.out.println("fetched text ** "+driver.findElement(By.xpath("//h1[text()='This is a sample page']")).getText());

		//switch to iFrame using iFrame index
		//driver.switchTo().frame(4);
		
		//switch back to default window
		driver.switchTo().defaultContent();
		System.out.println("fetched text ** "+driver.findElement(By.xpath("//h1[text()='Frames']")).getText());

		driver.quit();
	    
		

	}
}











