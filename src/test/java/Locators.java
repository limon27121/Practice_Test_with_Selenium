import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {
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

        driver.findElement(By.xpath("//input[@placeholder='Search …']")).sendKeys("research");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        String test=driver.findElement(By.xpath("//h1[@class='search-title']")).getText();
        System.out.println(test);
        driver.findElement(By.xpath("//h1[normalize-space()='Research Grants 2016']")).click();
        boolean dis=driver.findElement(By.xpath("(//img[@alt='banner'])[1]")).isDisplayed();
        System.out.println(dis);
    }
}
