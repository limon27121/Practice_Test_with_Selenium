package Mouse_action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mouse_hover {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        //mouse hover
        // Mouse hover on "Point Me" button
        WebElement elem1 = driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));

        // Wait for dropdown item to be visible after hover
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize Actions
        Actions action = new Actions(driver);
        action.moveToElement(elem1).perform();
        WebElement mobilesOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='dropdown-content']/a[normalize-space()='Mobiles']")));

        // Click the "Mobiles" dropdown link
        mobilesOption.click();

        System.out.println("Clicked on 'Mobiles' from dropdown.");

    }
}
