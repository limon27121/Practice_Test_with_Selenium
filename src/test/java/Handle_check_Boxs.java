import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Handle_check_Boxs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        //--specific checkbox select--
//        driver.findElement(By.xpath("//input[@id='sunday']")).click();


        //-----check all checkboxes------

        List<WebElement>checkboxs=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        System.out.println(checkboxs.size());
//        for (WebElement element:checkboxs){
//            element.click();
//        }

        //-----check specific checkbox--------
//        for (int i=4;i<checkboxs.size();i++){
//            checkboxs.get(i).click();
//        }

        //---unselected the boxes if they are selected

        for(int i = 0; i<3; i++){
            checkboxs.get(i).click();
        }
        Thread.sleep(500);
        for (WebElement check:checkboxs){
            if (check.isSelected()){
                check.click();
            }
        }

    }
}
