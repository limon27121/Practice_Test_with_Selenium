package Date_Pickers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class date_picker_with_submit_Button {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        WebElement startDateInput = driver.findElement(By.id("start-date"));
        startDateInput.sendKeys("11-22-2025");


        WebElement endDateInput = driver.findElement(By.id("end-date"));
        endDateInput.sendKeys("11-22-2026");

        driver.findElement(By.className("submit-btn")).click();
        boolean ans=driver.findElement(By.xpath("//div[@id='result']")).isDisplayed();
        System.out.println(ans);
    }
}
