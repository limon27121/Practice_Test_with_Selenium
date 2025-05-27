package KeyBoard_Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class handle_tabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        Actions action=new Actions(driver);
        WebElement elem =driver.findElement(By.xpath("//a[normalize-space()='Udemy Courses']"));
        action.keyDown(Keys.CONTROL).click(elem).keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(200);
        List<String>id=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(id.get(1));
        Thread.sleep(200);
        boolean res=driver.findElement(By.xpath("//span[normalize-space()='UDEMY COURSES']")).isDisplayed();
        System.out.println(res);
    }
}
