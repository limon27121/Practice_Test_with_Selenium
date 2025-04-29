package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Bootstrap_dropdowns {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // Open a website
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@title='HTML, CSS']")).click();
        //select one option at a time
//        driver.findElement(By.xpath("//label[normalize-space()='Java']")).click();

        // find the size
        List<WebElement> labels = driver.findElements(By.xpath("//ul[contains(@class, 'multiselect-container')]//label[@class='checkbox']"));
        System.out.println("Total options count: " + labels.size());

        //printing all the options

        for (WebElement op:labels){
            System.out.println(op.getText());
        }

        //select multiple options from dropdowns
        for (WebElement op:labels){
            if (op.getText().equals("Bootstrap")|| op.getText().equals("Angular")){
                op.click();
            }
        }


    }
}
