package Assginment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
public class Assginments03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://blazedemo.com/");
        double minPrice = Double.MAX_VALUE;
        int minPriceRowIndex = -1;
        driver.manage().window().maximize();
        WebElement option=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select opt=new Select(option);
        opt.selectByVisibleText("Portland");
        opt.selectByVisibleText("Paris");
        driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
        Thread.sleep(500);
        List<Double> priceList = new ArrayList<>();

        int row_number=driver.findElements(By.xpath("//table[@class='table']//tr")).size();
        int col_number=driver.findElements(By.xpath("//table[@class='table']//tr//th")).size();
        double minPrice1 = 1;
        for (int row=1;row<row_number;row++){
            WebElement priceElement = driver.findElement(By.xpath("//table[@class='table']//tr["+ row +"]//td[6]"));
            String priceText = priceElement.getText(); // e.g., "$472.56"

            // Remove $ sign and parse as double
            String numeric = priceText.replace("$", "").trim();
            double price = Double.parseDouble(numeric);

            if (price < minPrice) {
                minPrice = price;
                minPriceRowIndex = row;
//                driver.findElement(By.xpath("//tbody/tr["+ row +"]/td[1]/input[1]")).click();
            }
        }
        System.out.println("Minimum price is: $" + minPrice);
        System.out.println(minPriceRowIndex);
        driver.findElement(By.xpath("//tbody/tr["+ minPriceRowIndex +"]/td[1]/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Limon");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Mirpur");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Dhaka");
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Dhaka");
        driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("1216");
        WebElement card_opt=driver.findElement(By.xpath("//select[@id='cardType']"));
        Select card=new Select(card_opt);
        card.selectByVisibleText("American Express");
        driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("27121");
        driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("11");
        driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2020");
        driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Limon");
        driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
        Thread.sleep(1000);
        String actual_text=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
        String expected_text="Thank you for your purchase today!";
        assertEquals(expected_text, actual_text);

    }
}
