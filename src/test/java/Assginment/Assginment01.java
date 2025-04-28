package Assginment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Assginment01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
//        List<WebElement>links=driver.findElements(By.className("wikipedia-search-results"));
        List<WebElement> links = driver.findElements(By.cssSelector(".wikipedia-search-results a"));

        int link_size= links.size();
        System.out.println("Number of links: " + link_size);
        for (WebElement link : links) {
           link.click();

        }
        Thread.sleep(1000);
        Set<String> webelements = driver.getWindowHandles();
        List<String> web_ids = new ArrayList<>(webelements);

        for (String web_id : web_ids) {
            driver.switchTo().window(web_id);  // switch to each window ID properly
            String title = driver.getCurrentUrl();
            Thread.sleep(200);
           if(title.equals("https://en.wikipedia.org/wiki/Selenium")){
               driver.close();
           }
        }

    }
}
