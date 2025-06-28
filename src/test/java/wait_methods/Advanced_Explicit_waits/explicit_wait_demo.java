package wait_methods.Advanced_Explicit_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class explicit_wait_demo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        WebElement user_name=Wait_helper.waitForElementVisible(driver, By.xpath("//input[@placeholder='Username']"),10);
        user_name.sendKeys("Admin");
        WebElement password=Wait_helper.waitForElementVisible(driver,By.xpath("//input[@placeholder='Password']"),10);
        password.sendKeys("admin123");
        WebElement button=Wait_helper.waitForElementClickable(driver,By.xpath("//button[normalize-space()='Login']"),10);
        button.click();


    }

}
