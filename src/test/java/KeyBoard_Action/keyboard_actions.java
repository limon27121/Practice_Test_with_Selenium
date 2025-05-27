package KeyBoard_Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class keyboard_actions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        Actions action=new Actions(driver);
        //min slider
//        WebElement elem1=driver.findElement(By.xpath("//div[@id='HTML7']//span[1]"));
//        System.out.println(elem1.getLocation());
//        action.dragAndDropBy(elem1,1267,2019).build().perform();
//        Thread.sleep(200);
//        System.out.println(elem1.getLocation());

        //max slider

        WebElement elem2= driver.findElement(By.xpath("//div[@id='HTML7']//span[2]"));
        System.out.println(elem2.getLocation());
         String text1=driver.findElement(By.xpath("//input[@id='amount']")).getAttribute("value");
        System.out.println(text1);
        action.dragAndDropBy(elem2,300,2019);
        Thread.sleep(200);
        String text2=driver.findElement(By.xpath("//input[@id='amount']")).getAttribute("value");
        System.out.println(text2);



    }
}
