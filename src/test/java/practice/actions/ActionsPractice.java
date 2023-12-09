package practice.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.time.Duration;

public class ActionsPractice {
    public static void main(String[] args) throws InterruptedException {
        actionsKeysExercise();
    }

    public static void scrollToElement(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)#cite_note-40");

        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", table);
    }

    public static void actionsMoveToElement(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)#cite_note-40");

        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", table);

        Actions actions = new Actions(driver);
        WebElement betaLink = driver.findElement(By.partialLinkText("Beta"));

        actions.moveToElement(betaLink).moveToElement(betaLink).release().perform();
    }

    public static void actionsScrollByAmount(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.amazon.com/");

        Actions actions = new Actions(driver);
        // x=0,y=0
        actions.scrollByAmount(0,10000).perform();
    }

    public static void actionsClickAndHold() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");

        Actions actions = new Actions(driver);
        // find the button C
        WebElement buttonC = driver.findElement(By.xpath("//li[@name='C']"));
        // click and hold button C for 10 seconds
        actions.clickAndHold(buttonC).perform();
        Thread.sleep(10000);
        // after 10 seconds release button C
        actions.release().perform();
    }

    public static void actionsClickAndHoldExercise(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        WebElement titleC = driver.findElement(By.xpath("//li[@name='C']"));
        WebElement titleB = driver.findElement(By.xpath("//li[@name='B']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(titleC).moveToElement(titleB).release().perform();
    }

    public static void actionsDoubleClick(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        String expectedText = "You have done a double click";
        String actualText = driver.findElement(By.id("doubleClickMessage")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
    }

    public static void actionsRightClick(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBtn).perform();

        String expectedText = "You have done a right click";
        String actualText = driver.findElement(By.id("rightClickMessage")).getText();
        if(expectedText.equals(actualText)){
            System.out.println("Success");
        }
        else{
            System.out.println("Failed");
        }
    }

    public static void actionsDragAndDrop(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable, droppable).perform();
    }

    public static void actionsDragAndDropBy(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/dragabble");
        // go to this website = https://demoqa.com/draggable
        // move draggable element to the bottom of the webpage
        WebElement dragBox = driver.findElement(By.id("dragBox"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(dragBox, 150,300).perform();
    }

    public static void actionsCopy(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
        Actions actions = new Actions(driver);
        WebElement textBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        actions
                .keyDown(Keys.SHIFT)
                .sendKeys(textBox,"codewise")
                .keyUp(Keys.SHIFT)
                .sendKeys(" academy" + Keys.ENTER)
                .keyUp(Keys.SHIFT)
                .perform();
    }


    public static void actionsKeysExercise(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Karate");
        WebElement heading = driver.findElement(By.xpath("//span[@class='mw-page-title-main']"));
        WebElement searchBox = driver.findElement(By.xpath("//form[@id='searchform']//input[@class='cdx-text-input__input']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(heading)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .keyDown(Keys.COMMAND)
                .click(searchBox)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .pause(Duration.ofMillis(200))
                .sendKeys(" Combat")
                .sendKeys(Keys.ENTER)
                .perform();

    }



}
