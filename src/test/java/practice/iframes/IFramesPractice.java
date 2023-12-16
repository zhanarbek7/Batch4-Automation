package practice.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class IFramesPractice {
    public static void main(String[] args) throws InterruptedException {

    }

    public static void tablePractice1(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        WebElement table = driver.findElement(By.xpath("//table[@id='customers']"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(".//td"));
            for (WebElement column : columns) {
                System.out.print(column.getText() + " \t");
            }
            System.out.println();
        }

    }

    public static void tablePractice2(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)");

        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", table);

        // Get all rows in the table body
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        // Iterate through each row and print the text content of each cell
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
    }

    public static void simpleIFrameException(){
        // see together example:
        // where you can't locate htmlElement before switching to it
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        WebElement headingInsideFrame = driver.findElement(By.id("sampleHeading"));
        System.out.println("Heading text from inlinedFrame: "+ headingInsideFrame.getText());
    }

    public static void simpleIFrame(){
        // see together example:
        // where you can locate element only when you switch to it
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        WebElement headingInsideFrame = driver.findElement(By.id("sampleHeading"));
        System.out.println("Heading text from inlinedFrame: "+ headingInsideFrame.getText());
    }

    public static void iFrameNumber(){
        // Example: Find the number of IFRAMES
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        int numberOfFrames =
                Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println(numberOfFrames);
    }

    public static void iFrameLocateNumberOfTrainings() throws InterruptedException {
        // PRACTISE
        // GO TO THIS WEBSITE: https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame
        // SWITCH TO THE IFRAME by its name
        // Find WebElements of all 9 trainings
        // And then print in the console following
        // We have these trainings available:
        // Selenium 3.0 Training
        // SAP Hybris Training
        // Mobile Application Testing Training
        // Manual Testing Training
        // JMeter Training
        // HP LoadRunner Training
        // Database Testing Training
        // Calabash Training
        // Appium Training

        WebDriver driver = Driver.getDriver();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        // switching to embedded iframe
        driver.switchTo().frame("globalSqa");
        Thread.sleep(1000);

        WebElement elementToScrollTo = driver.findElement(By.xpath("//div[@id='portfolio_items']"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", elementToScrollTo);

        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='portfolio_items']/div//h3"));
        System.out.println("We have these trainings available:");
        for(WebElement i: elements){
            System.out.println(i.getText());
        }
    }

    public static void iframePractice2() throws InterruptedException {

        // Go to the webpage: "file path of your html document"
        // we have 3 frames in total

        // switch to the 1st frame
        // enter your username and password
        // click log in button
        // verify that you are logged in by clicking log out button

        // ?switch to the 2nd frame
        // find the table where it shows when java versions were released
        // print this table in the output

        WebDriver driver = Driver.getDriver();
        driver.get("file:///Users/zhanarbek/Downloads/myIFramesExample.html");

        driver.switchTo().frame("iframe1");

        WebElement usernameBox = driver.findElement(By.xpath("//input[@name='uname']"));
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='pw']"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='dologin']"));
        usernameBox.sendKeys("zhanarbek.a7@gmail.com");
        passwordBox.sendKeys("4864839993");
        loginButton.click();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");

        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", table);

        // Get all rows in the table body
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Iterate through each row and print the text content of each cell
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
    }



}
