import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://www.uiu.ac.bd/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       boolean visible=driver.findElement(By.className("department-logo")).isDisplayed();
        System.out.println(visible);
        driver.findElement(By.className("search-field")).sendKeys("research");
        driver.findElement(By.className("search-submit")).click();
        String search_text=driver.findElement(By.className("search-title")).getText();
        System.out.println(search_text);
        driver.findElement(By.linkText("Home")).click();
        List<WebElement>size=driver.findElements(By.cssSelector("#menu-departmental-header li"));
        System.out.println(size.size());
//        driver.close();
    }
}
