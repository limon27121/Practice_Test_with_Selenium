package Mouse_action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class mouse_action {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        //mouse hover
        WebElement elem1 =driver.findElement(By.xpath("//div[@class='dropdown']"));
        WebElement elem2=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
        Actions action=new Actions(driver);
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();

    }
}
