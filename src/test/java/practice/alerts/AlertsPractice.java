package practice.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class AlertsPractice {
    public static void main(String[] args) throws InterruptedException {
        scenario5();
    }

    public static void scenario1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[1]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("This is an alert text: " + alertText);
        alert.accept();
        WebElement resultAfterAlert = driver.findElement(By.id("result"));
        if(resultAfterAlert.getText().equals("You successfully clicked an alert")){
            System.out.println("Successfully handled simple alert");
        }
        else{
            System.out.println("Alert wasn't handled");
        }
    }

    public static void scenario2(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[2]")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        System.out.println("This is an alert text: " + alertText);
        alert.dismiss();

        WebElement resultAfterAlert = driver.findElement(By.id("result"));
        if(resultAfterAlert.getText().equals("You clicked: Ok")){
            System.out.println("Successfully clicked OK on a confirm alert");
        }
        else if(resultAfterAlert.getText().equals("You clicked: Cancel")){
            System.out.println("Successfully clicked CANCEL on an alert");
        }
        else{
            System.out.println("Alert wasn't handled");
        }
    }

    public static void scenario3() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[3]")).click();

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();

        System.out.println("This is an alert text: " + alertText);
        Thread.sleep(2000);
        alert.sendKeys("hello");
        Thread.sleep(2000);
        alert.accept();
        WebElement resultAfterAlert = driver.findElement(By.id("result"));
        if(resultAfterAlert.getText().equals("You entered: hello")){
            System.out.println("You clicked ok");
            System.out.println(resultAfterAlert.getText());
        }
        else if(resultAfterAlert.getText().equals("You entered: null")){
            System.out.println("You clicked cancel");
            System.out.println(resultAfterAlert.getText());
        }
        else{
            System.out.println("Alert wasn't handled");
        }
    }

    public static void scenario4(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://google.com");

        Alert alert = driver.switchTo().alert();
    }


    public static void scenario5(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[1]")).click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello");
    }

}
