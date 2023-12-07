package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class Test1 {

    public static void main(String[] args) {
        WebDriver driver = Driver.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hi")));



    }
}
