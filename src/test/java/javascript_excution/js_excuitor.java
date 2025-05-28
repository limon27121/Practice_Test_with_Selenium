package javascript_excution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class js_excuitor {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        //alter of send_keys
        WebElement elem =driver.findElement(By.xpath("//input[@id='name']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].setAttribute('value','limon')",elem);
        //alter of click() action
        WebElement elem1=driver.findElement(By.xpath("(//input[@id='male'])[1]"));
       js.executeScript("arguments[0].click()",elem1);

    }
}
