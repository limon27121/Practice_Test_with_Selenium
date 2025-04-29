package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Hidden_dropdows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        //implicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        usernameField.sendKeys("Admin");

        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        WebElement pimMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='PIM']")));
        pimMenu.click();

        // Click to expand dropdown
        WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[7]//div[1]//div[2]//div[1]//div[1]//div[1]")));
        dropdownIcon.click();

                        //**select a single options**

// Wait for options to appear

//        WebElement financeOption = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@role='listbox']//span[text()='Finance']")));
//
//        try {
//            financeOption.click(); // Regular Selenium click
//        } catch (ElementClickInterceptedException e) {
//            // Fallback if standard click fails
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", financeOption);
//        }



                           //**count number of options**

// Wait for the listbox to appear

        Thread.sleep(1000);

        List<WebElement> options = driver.findElements(
                By.xpath("//div[@role='listbox']//span"));

       // Print number of options
        System.out.println("Number of dropdown options: " + options.size());


                         //**print all the options


        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        

        }
    }

