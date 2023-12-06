package tests.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.UtilWait;

import java.time.Duration;

public class WaitAutomatic {
    public static void main(String[] args) {
        fluentWait();
    }

    public static void explicitClickable(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[.='Enable']")).click();

        WebElement webElement = UtilWait.waitUntilElementIsClickable(driver, 5, By.xpath("//form[@id='input-example']/input"));
        webElement.sendKeys("Hello");
    }

    public static void fluentWait(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // make button visible
//        driver.findElement(By.id("display-other-button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(11))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("hiden"))).click();


    }

    public static void explicitHiddenButton(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // make button visible
        driver.findElement(By.id("display-other-button")).click();

        // wait until button becomes visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hidden")));

        // check whether button is visible
        WebElement hiddenButton = driver.findElement(By.id("hidden"));
        hiddenButton.click();
    }
}
