package javascript_excution;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class uplaod_file {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        //choose the file from the pc
        driver.findElement(By.xpath("(//input[@id='singleFileInput'])[1]")).sendKeys("/home/limon/Pictures/Screenshots/");
        driver.findElement(By.xpath("//button[normalize-space()='Upload Single File']")).click();

    }
}
