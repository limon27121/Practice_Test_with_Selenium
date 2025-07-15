package javascript_excution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Scrolldown_dropdown {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        // Click to open dropdown
        WebElement comboBox = driver.findElement(By.id("comboBox"));
        comboBox.click();

        WebElement dropdown = driver.findElement(By.id("dropdown"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Keep scrolling until "Item 30" is found
        for (int i = 0; i < 10; i++) {
            try {
                WebElement item30 = dropdown.findElement(By.xpath(".//div[text()='Item 30']"));
                item30.click();
                System.out.println("✅ Selected Item 30");
                break;
            } catch (NoSuchElementException e) {
                js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", dropdown);
                Thread.sleep(500);
            }
        }

        Thread.sleep(2000); // Just to see result before browser closes
        driver.quit();
    }

}

