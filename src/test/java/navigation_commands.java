import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class navigation_commands {
    public static void main(String[] args) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        URL new_Url= new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // Open a website
        driver.get("https://www.uiu.ac.bd/");
        driver.navigate().to(new_Url);
        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println(driver.getCurrentUrl());

    }
}
