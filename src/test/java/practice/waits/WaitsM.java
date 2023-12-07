package practice.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class WaitsM {
    public static void main(String[] args) {
        explicitAddedToDOM();
    }

    public static void explicitClickable(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//form[@id='input-example']/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input")));

        driver.findElement(By.xpath("//form[@id='input-example']/input")).sendKeys("Hello");
    }

    public static void explicitInvisible(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[.='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

        WebElement element = driver.findElement(By.xpath("//p[@id='message']"));
        System.out.println(element.getText());
    }

    // explicit Visibility
    public static void explicitVisibility(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        WebElement element = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println(element.getText());
    }

    // explicit ElementAdded to DOM
    public static void explicitAddedToDOM(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.xpath("//button[.='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        WebElement element = driver.findElement(By.xpath("//h4[.='Hello World!']"));
        System.out.println(element.getText());
        System.out.println("Last line");
    }

}
