package wait_methods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class  explicit_wait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Explicit wait setup (wait up to 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //use explicit waits
        WebElement user_name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']"))
        );
        user_name.sendKeys("Admin");

        //use explicit wait
        WebElement password=wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));

        password.sendKeys("admin123");

        //use explicit wait
        WebElement click=wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));

        click.click();

    }

}
