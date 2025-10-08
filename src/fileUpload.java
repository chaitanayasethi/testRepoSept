import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.itextpdf.text.List;

public class fileUpload {
	
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor)driver;

		driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        String os = System.getProperty("os.name").toLowerCase();
        String filePath = "";

        //for uploading multiple files
        /*String[] filesToUpload = {
        	    "C:\\path\\to\\file1.jpg",
        	    "C:\\path\\to\\file2.pdf",
        	    "C:\\path\\to\\file3.png"
        	};*/
        	
        if (os.contains("win")) {
            // Windows file path example
            filePath = "C:\\Users\\username\\Documents\\sample.pdf";
        } else if (os.contains("mac")) {
            // Mac file path example
            filePath = "/Users/csethi/Desktop/uploadFile.png";
        } else {
            System.out.println("Unsupported OS: " + os);
            driver.quit();
            return;
        }

        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        uploadInput.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        // Add further verification or assertions here if needed

        driver.close();
	}
	
	
	

}
