package KeyBoard_Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class keyboard_keys {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");
        // Configure browser
        driver.manage().window().maximize();
        Thread.sleep(300);
        Actions action=new Actions(driver);
        driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("good morning");

        //crtl+a
        action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();

        //crtl+c
        action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();

        //tab
        action.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();

        //crtl+v
        action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build().perform();


    }
}
