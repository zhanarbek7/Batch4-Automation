package tests.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class WaitsManual {
    public static void main(String[] args) {
        explicitElementAddedToDOM();
    }

    public static void explicitInvisibility(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // click remove
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean until = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@label='blah']")));
        System.out.println(until);
    }

    public static void explicitClickable(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[.='Enable']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));
        driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Hello");
    }

    public static void explicitVisibility(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // make element visible in DOM
        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        // otherwise this would cause ElementNotInteractableException
        WebElement element = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        element.click();
        System.out.println(element.getText());
    }

    public static void explicitElementAddedToDOM(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        // make element present in DOM
        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        // otherwise it would cause NoSuchElementException
        WebElement element = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        element.click();
        System.out.println(element.getText());
    }
}
