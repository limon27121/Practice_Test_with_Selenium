package Webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Pagination_table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        //loop through each pagination
        List<WebElement>page_link =driver.findElements(By.xpath("//ul[@id='pagination']//li//a"));
//        System.out.println(page_link.size());
        int pagination_size=page_link.size();
        for (int i=1;i<=pagination_size;i++){
            driver.findElement(By.xpath("//a[normalize-space()="+i+"]")).click();
            try { Thread.sleep(1000); } catch (InterruptedException e) {}

            System.out.println("Checking Page: " + (i));

           //check all columns
            List<WebElement>headers=driver.findElements(By.xpath("//table[@id='productTable']//thead//tr//th"));
//            System.out.println(headers.size());
            if (headers.size() != 4) {
                System.out.println("Page " + (i) + " does not have 4 columns!");
                continue;
            }
            //verify atleast 1 row is found in every page
            List<WebElement>row=driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
            if (row.size()==0){
                System.out.println("No rows found on page \" + (i)");
                continue;
            }
            //check that all checkboxes are clickable
            for (int j=1;j<=row.size();j++){
                WebElement check_box=driver.findElement(By.xpath("//body[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/table[1]/tbody[1]/tr["+j+"]/td[4]"));
                if (!check_box.isDisplayed()){
                    System.out.println("Checkbox not visible on row.");
                }
                else {
                    check_box.click();
                    System.out.println("Checkbox clicked successfully.");
                }
            }

        }

    }
}
