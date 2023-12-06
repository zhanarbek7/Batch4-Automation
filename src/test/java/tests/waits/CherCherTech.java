package tests.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CherCherTech {
    public static void explicitTextToBePresent(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        driver.findElement(By.id("populate-text")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(11));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"),"Selenium Webdriver"));

        // it would create NoSuchElementException exception
        WebElement element = driver.findElement(By.xpath("//h2[.='Selenium Webdriver']"));
        System.out.println(element.getText());
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
