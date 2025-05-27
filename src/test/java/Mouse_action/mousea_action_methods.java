package Mouse_action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class mousea_action_methods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //double click

//        driver.get("https://testautomationpractice.blogspot.com/");
//        WebElement elem1=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
//        Thread.sleep(200);
//        Actions action=new Actions(driver);
//        action.doubleClick(elem1).perform();

//        right click
//        driver.get("https://www.w3schools.com/vue/tryit.php?filename=tryvue_modifiers_rightClick");
//        WebElement elem2= driver.findElement(By.xpath("//p[normalize-space()='Press right mouse button here.']"));
//        Actions action1=new Actions(driver);
//        action1.contextClick(elem2).build().perform();

        // drop down

       driver.get("https://testautomationpractice.blogspot.com/");
       WebElement src=driver.findElement(By.xpath("(//p[normalize-space()='Drag me to my target'])[1]"));
       WebElement target= driver.findElement(By.xpath("//div[@id='droppable']"));
       Actions action3=new Actions(driver);
       action3.dragAndDrop(src,target).build().perform();
        System.out.println("done");



    }
}
