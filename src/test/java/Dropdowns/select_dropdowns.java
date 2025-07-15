package Dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class select_dropdowns {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        WebElement drop_down=driver.findElement(By.xpath("//select[@id='country']"));
        //select option from dropdown
        Select drp=new Select(drop_down);
//        drp.selectByVisibleText("Canada");
//        drp.selectByValue("germany");
//        drp.selectByIndex(2);

        //capture options from the dropdown

        List<WebElement>options=drp.getOptions();
        System.out.println("options are: "+options.size());

        //print the options
        for (int i=0;i<options.size();i++){
            System.out.println(options.get(i).getText());
            String text=options.get(i).getText();
            String text1="Germany";
            if (text.equalsIgnoreCase(text1)){
                drp.selectByIndex(i);
                System.out.println("done");
                break;
            }
//            else {
//                System.out.println("fail");
//                break;
//            }
        }
    }
}
