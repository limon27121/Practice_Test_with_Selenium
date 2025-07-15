package Mouse_action;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Collections;

public class mouse_action_methods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //-----double click-------

//        driver.get("https://testautomationpractice.blogspot.com/");
//        WebElement elem1=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
//        Thread.sleep(200);
//        Actions action=new Actions(driver);
//        action.doubleClick(elem1).perform();

//        --------right click-------

//        driver.get("https://www.w3schools.com/vue/tryit.php?filename=tryvue_modifiers_rightClick");
//        WebElement elem2= driver.findElement(By.xpath("//p[normalize-space()='Press right mouse button here.']"));
//        Actions action1=new Actions(driver);
//        action1.contextClick(elem2).build().perform();

        // -------drag and drop--------

//       driver.get("https://testautomationpractice.blogspot.com/");
//       WebElement src=driver.findElement(By.xpath("(//p[normalize-space()='Drag me to my target'])[1]"));
//       WebElement target= driver.findElement(By.xpath("//div[@id='droppable']"));
//       Actions action3=new Actions(driver);
//       action3.dragAndDrop(src,target).build().perform();
//        System.out.println("done");


        //click and hold
//
//        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
//
//        WebElement clickable = driver.findElement(By.id("clickable"));
//        new Actions(driver)
//                .clickAndHold(clickable)
//                .perform();
//        Assert.assertEquals("focused", driver.findElement(By.id("click-status")).getText());


        //click and release

//        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
//
//        WebElement clickable = driver.findElement(By.id("click"));
//        new Actions(driver)
//                .click(clickable)
//                .perform();
//
//        Assert.assertTrue(driver.getCurrentUrl().contains("resultPage.html"));
//

        //--back click-----

        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        driver.findElement(By.id("click")).click();
        Assert.assertEquals(driver.getTitle(), "We Arrive Here");

        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerDown(PointerInput.MouseButton.BACK.asArg()))
                .addAction(mouse.createPointerUp(PointerInput.MouseButton.BACK.asArg()));

        ((RemoteWebDriver) driver).perform(Collections.singletonList(actions));

        Assert.assertEquals("BasicMouseInterfaceTest", driver.getTitle());
        System.out.println("done");



    }
}
