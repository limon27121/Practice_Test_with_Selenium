import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Browser_windows {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open a website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(1000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        //approach 1
        //using list
        Set<String>webelements=driver.getWindowHandles();
        //convert set to list
        List<String>web_ids=new ArrayList(webelements);
//        String Parent_id=web_ids.get(0);
//        String child_id=web_ids.get(1);
//        driver.switchTo().window(child_id);
//        String title01=driver.getTitle();
//        System.out.println(title01);
//        driver.switchTo().window(Parent_id);
//        String title02= driver.getTitle();
//        System.out.println(title02);

        //approach 2

        for (String web_id:web_ids){
            String title=driver.switchTo().window(web_id).getTitle();
            if (title.equals("OrangeHRM")){
                System.out.println(driver.getCurrentUrl());
            }
        }

    }
}
