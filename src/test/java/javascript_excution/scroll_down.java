package javascript_excution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class scroll_down {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.worldometers.info/geography/flags-of-the-world/");
        // Configure browser
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor)driver;

        //scroll the page by pixel

//        js.executeScript("window.scrollBy(0,500)");
//        System.out.println("done");

        //scroll the page until the element is visible

//        WebElement elem1= driver.findElement(By.xpath("//span[normalize-space()='Uruguay']"));
//        js.executeScript("arguments[0].scrollIntoView();",elem1);
//        System.out.println("done");

        //scroll the page until the page end

        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        System.out.println("done");
    }
}
