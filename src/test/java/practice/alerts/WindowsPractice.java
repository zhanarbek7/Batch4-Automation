package practice.alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.util.List;
import java.util.Set;

public class WindowsPractice {
    public static void main(String[] args) throws InterruptedException {
        multipleWindowsAlerts();
    }

    public static void windows2Exception(){
        // this code will throw exception because our focus is still on previous webpage
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("1. Focus is at " + driver.getWindowHandle());

        WebElement element = driver.findElement(By.xpath("//div[@class='example']/a"));
        element.click();

        System.out.println("2. Focus is at " + driver.getWindowHandle());

        WebElement textOnNewWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(textOnNewWindow.getText());
    }

    public static void windows2Valid(){
        // this code won't throw an exception because we switched to child window
        // and then only we can interact with webElements of child window
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("1. Focus is at " + parentWindowHandle);

        WebElement element = driver.findElement(By.xpath("//div[@class='example']/a"));
        element.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);

        for(String i: windowHandles){
            if(!i.equals(parentWindowHandle)){
                driver.switchTo().window(i);
            }
        }

        System.out.println("2. Focus after opening new window is at " + driver.getWindowHandle());

        WebElement textOnNewWindow = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(textOnNewWindow.getText());
    }

    public static void multipleWindowsAlertsClickException() throws InterruptedException {
        // here we won't be able to click alertBoxButton because it is in child window
        // but our focus is on parent window
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window handle ID: " + parentWindowHandle);

        WebElement newTabs = driver.findElement(By.id("newTabsBtn"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", newTabs);

        Thread.sleep(2500);
        newTabs.click();
        System.out.println("Window handle ID: " + driver.getWindowHandle());

        WebElement alertBoxButton = driver.findElement(By.id("alertBox"));
        alertBoxButton.click();
    }

    public static void multipleWindowsAlerts() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("Parent window handle ID: " + parentWindowHandle);

        WebElement newTabs = driver.findElement(By.id("newTabsBtn"));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", newTabs);

        Thread.sleep(2500);
        newTabs.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String i: windowHandles){
            if(!i.equals(parentWindowHandle)){
                driver.switchTo().window(i);
                if(driver.getTitle().contains("Alerts")){
                    break;
                }
            }
        }

        System.out.println("Window handle ID: " + driver.getWindowHandle());

        WebElement alertBoxButton = driver.findElement(By.id("alertBox"));
        alertBoxButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }






}
