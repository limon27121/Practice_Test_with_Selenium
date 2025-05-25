package Webtables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Dynamic_webtable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        // Configure browser
        driver.manage().window().maximize();

        // 1. Read table headers into list
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='taskTable']//thead//th"));
        List<String> headerNames = new ArrayList<>();
        for (WebElement header : headers) {
            headerNames.add(header.getText().trim());
        }
        // Example: ["Name", "Memory (MB)", "CPU (%)", "Disk (MB/s)", "Network (Mbps)"]

        // 2. Prepare list of checks: [processName, columnName, displayValueCssClass]
        // This connects table cell to displayed value's class for assertion
        List<List<String>> checks = Arrays.asList(
                Arrays.asList("Chrome", "CPU (%)", "chrome-cpu"),
                Arrays.asList("Firefox", "Memory (MB)", "firefox-memory"),
                Arrays.asList("Chrome", "Network (Mbps)", "chrome-network"),
                Arrays.asList("Firefox", "Disk (MB/s)", "firefox-disk")
        );

        for (List<String> check : checks) {
            String processName = check.get(0);
            String columnName = check.get(1);
            String displayClass = check.get(2);

            // Find column index for this header
            int colIndex = headerNames.indexOf(columnName) + 1;

            // Find the table row where first cell = processName
            WebElement row = driver.findElement(By.xpath("//table[@id='taskTable']//tbody//tr[td[1]='" + processName + "']"));
            // Find the cell in that row at colIndex
            WebElement cell = row.findElement(By.xpath("td[" + colIndex + "]"));
            String tableValue = cell.getText().trim();

            // Find the displayed value by CSS class
            WebElement displayValueElem = driver.findElement(By.cssSelector("strong." + displayClass));
            String displayedValue = displayValueElem.getText().trim();

            System.out.println("Comparing " + processName + " " + columnName);
            System.out.println("Table value:     " + tableValue);
            System.out.println("Displayed value: " + displayedValue);

            // Assert they are equal
            assertEquals("Value mismatch for " + processName + " " + columnName, tableValue, displayedValue);
        }

        System.out.println("All dynamic assertions passed!");
        }
    }
