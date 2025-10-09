import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class XpathSalesforceLeadFlow {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            driver.manage().window().maximize();
            driver.get("https://test.salesforce.com/?locale=in");

            // --- LOGIN using XPath ---
            driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kishoresv988@ggmail.com");
            driver.findElement(By.xpath("//input[@id='password']']")).sendKeys("Winter@2025");
            driver.findElement(By.xpath("//input[@id='Login' or @name='Login']")).click();

            // wait for App Launcher (waffle) to be clickable
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='App Launcher']")),
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'slds-button')]"))
            ));

            // --- OPEN APP LAUNCHER ---
            try {
                driver.findElement(By.xpath("//button[@aria-label='App Launcher']")).click();
            } catch (Exception e) {
                driver.findElement(By.xpath("(//button[contains(@class,'slds-button')])[1]")).click();
            }

            // optionally click "View All" if present
            try {
                WebElement viewAll = driver.findElement(By.xpath("//button[normalize-space()='View All' or normalize-space()='View all']"));
                if (viewAll.isDisplayed()) viewAll.click();
            } catch (Exception ignored) {}

            // --- SEARCH "Leads" in App Launcher (XPath) ---
            try {
                WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[contains(@placeholder,'Search apps') or @type='search']")));
                searchBox.clear();
                searchBox.sendKeys("Leads");
            } catch (Exception e) {
                // fallback: any search input
                WebElement s = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='search']")));
                s.clear();
                s.sendKeys("Leads");
            }

            // short pause for results to render
            Thread.sleep(1000);

            // click the "Leads" tile/result using XPath
            boolean clicked = false;
            List<WebElement> candidates = driver.findElements(By.xpath("//*[(name()='a' or name()='button' or name()='p' or name()='span' or name()='div') and normalize-space(text())='Leads']"));
            for (WebElement el : candidates) {
                try {
                    if (el.isDisplayed()) { el.click(); clicked = true; break; }
                } catch (Exception ignored) {}
            }
            if (!clicked) {
                // fallback: tile by title
                driver.findElement(By.xpath("//a[@title='Leads' or .//*[normalize-space()='Leads']]")).click();
            }

            // --- CLICK "New" on Leads list view ---
            WebElement newBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='New' or @title='New' or @aria-label='New']")));
            newBtn.click();

            // --- FILL LEAD FORM (XPath) ---
            // Last Name
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//label[normalize-space()='Last Name']/following::input[1] | //input[@name='LastName'] | //input[contains(@placeholder,'Last Name')]")));
            lastName.clear();
            lastName.sendKeys("AutomationTester");

            // Company (required)
            WebElement company = null;
            try {
                company = driver.findElement(By.xpath("//label[normalize-space()='Company']/following::input[1] | //input[@name='Company']"));
                company.clear();
                company.sendKeys("Acme Corporation");
            } catch (Exception ex) {
                // fallback to first input that looks like company
                driver.findElement(By.xpath("//input[contains(@placeholder,'Company')]")).sendKeys("Acme Corporation");
            }

            // optional email/phone
            try { driver.findElement(By.xpath("//input[@type='email']")).sendKeys("auto.tester@example.com"); } catch (Exception ignored) {}
            try { driver.findElement(By.xpath("//input[@type='tel' or contains(@placeholder,'Phone')]")).sendKeys("9999999999"); } catch (Exception ignored) {}

            // --- SAVE LEAD ---
            try {
                driver.findElement(By.xpath("//button[normalize-space()='Save' or @title='Save' or @aria-label='Save']")).click();
            } catch (Exception e) {
                // footer save fallback
                List<WebElement> footBtns = driver.findElements(By.xpath("//footer//button"));
                for (WebElement b : footBtns) {
                    if ("Save".equalsIgnoreCase(b.getText().trim())) { b.click(); break; }
                }
            }

            // wait for record page to load / Convert button visible
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Convert' or @title='Convert']")),
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class,'toastMessage') or contains(text(),'Lead converted')]"))
            ));

            // --- CLICK CONVERT ---
            try {
                driver.findElement(By.xpath("//button[normalize-space()='Convert' or @title='Convert' or @aria-label='Convert']")).click();
            } catch (Exception e) {
                // fallback: button by text
                List<WebElement> btns = driver.findElements(By.xpath("//button"));
                for (WebElement b : btns) {
                    if ("Convert".equalsIgnoreCase(b.getText().trim())) { b.click(); break; }
                }
            }

            // try to enable opportunity checkbox in modal (best-effort)
            try {
                List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
                for (WebElement cb : checkboxes) {
                    if (!cb.isSelected()) {
                        // check label text near checkbox
                        try {
                            WebElement lbl = cb.findElement(By.xpath("./ancestor::label"));
                            if (lbl != null && lbl.getText().toLowerCase().contains("opportunity")) {
                                cb.click();
                                break;
                            }
                        } catch (Exception ignored) {}
                    }
                }
            } catch (Exception ignored) {}

            // click Convert in modal
            try {
                WebElement convertModalBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Convert' or normalize-space()='Save & Convert' or @title='Convert']")));
                convertModalBtn.click();
            } catch (Exception e) {
                // footer fallback
                List<WebElement> foot = driver.findElements(By.xpath("//footer//button"));
                for (WebElement b : foot) {
                    String t = b.getText().trim();
                    if ("Convert".equalsIgnoreCase(t) || "Save & Convert".equalsIgnoreCase(t)) { b.click(); break; }
                }
            }

            // --- CAPTURE TOAST AND ASSERT EQUALS ---
            WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(text(),'Lead converted') or contains(@class,'toastMessage') or contains(@class,'forceToastText')]")));
            String toastText = toast.getText().trim();
            System.out.println("Toast: " + toastText);

            // exact equality assert
            Assert.assertEquals(toastText, "Lead converted", "Toast did not match expected text.");

            System.out.println("SUCCESS: Lead created and converted.");

        } catch (AssertionError ae) {
            System.err.println("ASSERTION FAILED: " + ae.getMessage());
            throw ae;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
