package Date_Pickers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class date_picker_with_condition {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='txtDate']")).click();

        //select date,month,year

//        Select month=new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
//        month.selectByVisibleText("Nov");
//        Select date=new Select(driver.findElement(By.xpath("//select[@aria-label='Select year']")));
//        date.selectByVisibleText("2015");
//        driver.findElement(By.xpath("//a[normalize-space()='22']")).click();
//        Thread.sleep(200);
//        String value = driver.findElement(By.xpath("//input[@id='txtDate']")).getAttribute("value");
//        System.out.println(value);
//        assertEquals("22/11/2015", value);

        //check previous and next button
        String current_month=driver.findElement(By.className("ui-datepicker-month")).getAttribute("value");
        String current_year=driver.findElement(By.xpath("//select[@aria-label='Select year']")).getAttribute("value");
        System.out.println("current year:"+current_year);
        System.out.println("current month"+current_month);
        //click to next button
        driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        String chnge_month=driver.findElement(By.className("ui-datepicker-month")).getAttribute("value");
        String chnge_year=driver.findElement(By.xpath("//select[@aria-label='Select year']")).getAttribute("value");

        System.out.println("chnge year:"+chnge_year);
        System.out.println("chnge month"+chnge_month);

    }
}
