package practice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;
import java.util.ArrayList;

public class WaitsA {
    public static void main(String[] args) throws InterruptedException {

    }

    public static void explicitClickable(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        UtilWait.waitUntilElementIsClickable(driver, 10, By.xpath("//form[@id='input-example']/input"))
                .sendKeys("Hello");
    }

    public static void explicitVisibility(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[.='Start']")).click();

        System.out.println(UtilWait.waitUntilElementIsVisible(driver, 5, By.xpath("//h4[.='Hello World!']")).getText());


    }

}
