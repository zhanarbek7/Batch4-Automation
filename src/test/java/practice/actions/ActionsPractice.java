package practice.actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.Driver;

import java.time.Duration;

public class ActionsPractice {
    public static void main(String[] args) throws InterruptedException {
        actionsMoveByOffset();
    }


    public static void scrollToElement(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)");
        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
    }

    public static void actionsMoveToElement(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)");
        WebElement table = driver.findElement(By.xpath("//table[@class='wikitable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
        Actions actions = new Actions(driver);
        WebElement betaLink = driver.findElement(By.linkText("Beta"));
        actions.moveToElement(betaLink).perform();
    }

    public static void actionsScrollByAmount(){
//        You are using the scrollByAmount method of the Actions class to scroll the web page vertically.
//        The method takes two parameters: x (horizontal scroll) and y (vertical scroll).
//        In this case, you are scrolling vertically by 3000 pixels (0 for horizontal scroll, and 3000 for vertical scroll).
        WebDriver driver = Driver.getDriver();
        driver.get("https://en.wikipedia.org/wiki/Java_(programming_language)");
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,3000).perform();
    }

    public static void actionsClickAndHold(){
        // In this example, first we move cursor to the location of title C
        // then click and hold title C
        // then when we move mouse it moves title C also
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);

        // Locate the element C by By.xpath.
        WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']"));

        // Create an object of actions class and pass reference of WebDriver as a parameter to its constructor.
        Actions actions = new Actions(driver);
        // Move the cursor to the position of element C.
        actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation.
        actions.clickAndHold().perform();
    }

    public static void actionsClickAndHoldExercise(){
        //
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);
        // Locate the element C by By.xpath.
        WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']"));
        WebElement titleB = driver.findElement(By.xpath("//li[text()= 'B']"));
        // Create an object of actions class and pass reference of WebDriver as a parameter to its constructor.
        Actions actions = new Actions(driver);
        // Move the cursor to the position of element C.
        actions.moveToElement(titleC); // Call clickAndHold() method to perform click and hold operation.
        actions.clickAndHold().moveToElement(titleB).release().perform();
    }

    public static void actionsDoubleClick(){
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.id("doubleClickBtn"));
        actions.doubleClick(heading).perform();
    }

    public static void actionsRightClick(){
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.id("rightClickBtn"));
        actions.doubleClick(heading).perform();
    }

    public static void actionsDragAndDrop(){
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);

        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropTo = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(dragElement,dropTo).perform();
    }

    public static void actionsDragAndDropBy(){
        // copy heading and pase it in the search box
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dragabble");
        Actions actions = new Actions(driver);
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggableExample-tabpane-simple']/div"));
        actions.dragAndDropBy(dragElement, 0,300).perform();
    }

    public static void actionsKeys() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Karate");
        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.xpath("//h1[@id='firstHeading']/span"));
        // copying heading
        actions.doubleClick(heading).keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        WebElement searchBox = driver.findElement(By.xpath("//form[@id='searchform']//input[@class='cdx-text-input__input']"));
        // sending keys
        Thread.sleep(1000);
        actions.keyDown(Keys.COMMAND).sendKeys(searchBox, "v").keyUp(Keys.COMMAND).sendKeys(Keys.ENTER).perform();
    }

    public static void actionsCopyWholeTextOfPage() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://en.wikipedia.org/wiki/Karate");
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        actions.keyDown(Keys.COMMAND).sendKeys("a").sendKeys("c")
                .keyUp(Keys.COMMAND)
                .perform();
    }

    public static void actionsMoveByOffset(){
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/dragabble");
        Actions actions = new Actions(driver);
        WebElement elementToHold = driver.findElement(By.id("dragBox"));
        actions.clickAndHold(elementToHold).moveByOffset(100,200).perform();
    }

    

}

