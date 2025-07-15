import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_alert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(200);

        //------normal alert with ok button--------

//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//        Alert alert=driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();


        //--------alert with ok and cancel button----------

//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
          //for accept the alert
//        driver.switchTo().alert().accept();
        //for dismiss the alert
//        driver.switchTo().alert().dismiss();
//        Thread.sleep(300);
//        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
//        if (result.contains("Ok")) {
//
//                System.out.println("you clicked ok button");
//        }

        //---------prompt alert-----------
//        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("Welcome");
//        alert.accept();
    }
}
