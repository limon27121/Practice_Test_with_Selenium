package Webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Static_table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Open a website
        driver.get("https://testautomationpractice.blogspot.com/");

        //find the number of row
       int rows_number=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        System.out.println(rows_number);
        //find the number of column
        int colums_number=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
        System.out.println(colums_number);
        //extract the table header name
        List<WebElement>header_text=driver.findElements(By.xpath("//table[@name='BookTable']//tr//th"));
        for (WebElement text:header_text){
            System.out.println(text.getText());
        }

        //read specific row and column value
        String value=driver.findElement(By.xpath("//table[@name='BookTable']//tr[6]//td[1]")).getText();
        System.out.println("specific value:"+value);

        //read all data from table
//        for (int r=2;r<=rows_number;r++){
//            for (int c=1;c<=colums_number;c++){
//                //dynamic xpath
//                String value1=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//                System.out.print(value1+"\t");
//            }
//            System.out.println();
//        }

        //find specific value based on condition
        int total=0;
        for (int r1 = 2; r1 <= rows_number; r1++) {
            String author_name = driver.findElement(By.xpath("//tbody/tr[" + r1 + "]/td[2]")).getText();
            if (author_name.equalsIgnoreCase("Amit")) {

                WebElement book = driver.findElement(By.xpath("//tbody/tr[" + r1 + "]/td[1]"));
                System.out.println(book.getText());
                WebElement price=driver.findElement(By.xpath("//tbody/tr[" + r1 + "]/td[4]"));
                String ind_price=price.getText();
                total=total+Integer.parseInt(ind_price);
            }
        }
        System.out.println("price of total books: "+total);




    }
}
