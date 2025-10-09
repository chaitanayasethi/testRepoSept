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
		
		driver.get("file:///C:/Users/Sai%20Kishore%20SV/Downloads/!--%20multi.html%20--.html");
        driver.manage().window().maximize();

        String os = System.getProperty("os.name").toLowerCase();
        String filePath = "";

        //for uploading multiple files
        /*String[] filesToUpload = {
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\A.jpg",
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\B.jpg",
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\C.jpg"
        	};*/
        	
        if (os.contains("win")) {
            // Windows file path example
            String[] filesToUpload = {
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\A.jpg",
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\B.jpg",
        	    "C:\\Users\\Sai Kishore SV\\OneDrive\\Pictures\\C.jpg"
        	};
        } else if (os.contains("mac")) {
            // Mac file path example
            filePath = "/Users/csethi/Desktop/uploadFile.png";
        } else {
            System.out.println("Unsupported OS: " + os);
            driver.quit();
            return;
        }

        WebElement uploadInput = driver.findElement(By.id("file-upload"));
        uploadInput.sendKeys(filesToUpload);

        driver.findElement(By.id("file-submit")).click();

        // Add further verification or assertions here if needed

        driver.quit();
	}
	
	
	

}
