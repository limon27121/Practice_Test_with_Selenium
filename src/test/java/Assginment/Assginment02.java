package Assginment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assginment02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@id='productTable']//input[@type='checkbox']"));

        // Loop through each checkbox and click it
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {  // Only click if not already selected
                checkbox.click();
            }
        }
    }
}
