package practice.windows;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Set;

public class WindowsPractice {
    public static void main(String[] args) throws InterruptedException {
        multipleWindows5();
    }

    public static void windows2Exception(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("1. Parent window handle: " + parentWindowHandle);

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("2. Window handle: " + driver.getWindowHandle());

        WebElement textOnNewTab = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(textOnNewTab);
    }

    public static void windows2Valid(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("1. Parent window handle: " + parentWindowHandle);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();

        for(String i: windowHandles){
            if(!i.equals(parentWindowHandle)){
                driver.switchTo().window(i);
            }
        }

        System.out.println("2. Window handle: " + driver.getWindowHandle());

        WebElement textOnNewTab = driver.findElement(By.xpath("//h3[.='New Window']"));
        System.out.println(textOnNewTab.getText());
    }

    public static void multipleWindows(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parentWindowHandle = driver.getWindowHandle();
        driver.findElement(By.id("newWindowBtn")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String i: windowHandles){
            if(!i.equals(parentWindowHandle)){
                driver.switchTo().window(i);
            }
        }

        driver.findElement(By.id("firstName")).sendKeys("Zhanarbek");
    }

    public static void multipleWindows5() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parentWindowHandle = driver.getWindowHandle();
        WebElement multipleTabsBtn = driver.findElement(By.id("newTabsBtn"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",multipleTabsBtn);

        multipleTabsBtn.click();
        multipleTabsBtn.click();
        multipleTabsBtn.click();

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> list = new ArrayList<>(windowHandles);

        System.out.println(list);

        for(int i = 0; i < list.size(); i++){
            Thread.sleep(2000);
            driver.switchTo().window(list.get(i));
            if(i==list.size()-1){
                Thread.sleep(2000);
                i=0;
                driver.switchTo().window(parentWindowHandle);
            }
        }
    }
}
