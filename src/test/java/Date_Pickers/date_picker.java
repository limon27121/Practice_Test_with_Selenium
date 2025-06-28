package Date_Pickers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class date_picker {
    static void select_future_month_year_date(WebDriver driver,String month,String year,String date){
        while (true){
            String current_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String current_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if (current_month.equalsIgnoreCase(month) && current_year.equalsIgnoreCase(year)){
                break;
            }
            // go to next
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }
        List<WebElement>dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dat:dates){
            if(dat.getText().equalsIgnoreCase(date)){
                dat.click();
                break;
            }
        }

    }

    static void select_past_month_year_date(WebDriver driver,String month,String year,String date){
        while (true){
            String current_month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String current_year=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
            if (current_month.equalsIgnoreCase(month) && current_year.equalsIgnoreCase(year)){
                break;
            }
            // go to prev
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
        }
        List<WebElement>dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
        for (WebElement dat:dates){
            if(dat.getText().equalsIgnoreCase(date)){
                dat.click();
                break;
            }
        }

    }



    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://jqueryui.com/datepicker/");
        // Configure browser
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        //method:1
//        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/04/2025");

        //method02
        String year="2023";
        String month="September";
        String date="20";
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();

        //select month,year,date for future
//        select_future_month_year_date(driver,month,year,date);

        //select month,year,date for prev
        select_past_month_year_date(driver,month,year,date);

    }
}
