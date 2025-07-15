package KeyBoard_Action;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class copy_paste_from_text_filed {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/selenium/web/single_text_input.html");

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        WebElement textField = driver.findElement(By.id("textInput"));
        new Actions(driver)
                .sendKeys(textField, "Selenium!")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xvv")
                .keyUp(cmdCtrl)
                .perform();

        Assert.assertEquals("SeleniumSelenium!", textField.getAttribute("value"));
        System.out.println("done");
    }

}
