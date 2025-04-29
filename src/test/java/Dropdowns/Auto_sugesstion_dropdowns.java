package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Auto_sugesstion_dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open a website
        driver.get("https://www.google.co.uk/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
        List<WebElement>items=driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(items.size());
        for (WebElement item:items){
            String text=item.getText();
            System.out.println(text);

            if (text.equalsIgnoreCase("selenium")) {
                item.click();
                break;
            }
        }
    }
}
