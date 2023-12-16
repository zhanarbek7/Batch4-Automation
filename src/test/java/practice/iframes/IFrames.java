package practice.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class IFrames {
    public static void main(String[] args) throws InterruptedException {
        iframePractice1();
    }

    public static void simpleIFrameException(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        WebElement element = driver.findElement(By.id("sampleHeading"));
    }

    public static void simpleIFrame() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");

        // 1. name or id
//        driver.switchTo().frame("frame1");

        // 2. webElement
        WebElement frame1 = driver.findElement(By.xpath("(//iframe)[1]"));
//        driver.switchTo().frame(frame1);

        // 3. index


        WebElement headingInsideFrame = driver.findElement(By.id("sampleHeading"));
        System.out.println(headingInsideFrame.getText());
    }

    public static void iframePractice1() throws InterruptedException {
        // PRACTICE
        // 1. Go to this website: https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame
        // 2. Switch to the iframe
        // 3. Find all 9 trainings webElements using xpath
        // 4. And then print in the console training names

        // We have these training available:
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

}
