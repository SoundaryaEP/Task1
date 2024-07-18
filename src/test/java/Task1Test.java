import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Task1Test {
    @Test
    public void Test(){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://pastebin.com/");

        String code = "Hello from WebDriver";
        WebElement pasteData = driver.findElement(By.id("postform-text"));
        pasteData.sendKeys(code);


        driver.findElement(By.xpath("(//span[@class='select2-selection__arrow'])[3]")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
        String pasteName = "helloweb";
        WebElement pasteNameElem = driver.findElement(By.id("postform-name"));
        pasteNameElem.sendKeys(pasteName);

        driver.findElement(By.xpath("//button[@class=\"btn -big\"]")).click();


        //checking paste is created or not
        try {
            WebElement element=driver.findElement(By.xpath("//div[@class='notice -success -post-view']"));
            String text = element.getText();
            System.out.println(text);
        } catch (NoSuchElementException e) {
            Assert.fail();
        }


        driver.quit();
    }

}
