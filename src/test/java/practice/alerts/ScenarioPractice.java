package practice.alerts;

import org.openqa.selenium.*;
import utilities.Driver;

public class ScenarioPractice {
    public static void main(String[] args) throws InterruptedException {
        invalidAlert();
    }


    public static void simpleOKAlert(){
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

    public static void confirmAlert(){
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
            System.out.println("Successfully clicked CANCEL on a alert");
        }
        else{
            System.out.println("Alert wasn't handled");
        }
    }

    public static void promptAlert(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[3]")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("This is an alert text: " + alertText);
        alert.sendKeys("This was entered by Selenium WebDriver");
        alert.dismiss();
        WebElement resultAfterAlert = driver.findElement(By.id("result"));
        if(resultAfterAlert.getText().equals("You entered: This was entered by Selenium WebDriver")){
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



    public static void noAlert(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://google.com");
        try{
            Alert alert = driver.switchTo().alert();
        }
        catch(NoAlertPresentException e){
            System.out.println("Alert was not found!");
        }
    }

    public static void invalidAlert() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("(//ul/li/button)[1]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3500);
        try{
            alert.sendKeys("Sending keys to alert");
        }
        catch (ElementNotInteractableException e){
            System.out.println("You can't call sendKeys on a SIMPLE or CONFIRMATION alert");
        }
    }
}
