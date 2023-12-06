package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectPractice {
    public static void main(String[] args) throws InterruptedException {
        completeWebForm();
    }

    public static void selectMenu1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        // dropdown 1
        WebElement selectElement1 =
                driver.findElement(By.xpath("//select[@id='first']"));
        Select selectProducts = new Select(selectElement1);
        selectProducts.selectByIndex(1);

        // dropdown 2
        WebElement selectElement2 =
                driver.findElement(By.xpath("//select[@id='animals']"));
        Select selectAnimals = new Select(selectElement2);
        selectAnimals.selectByValue("babycat");

        // multiple dropdown
        WebElement selectElement3 =
                driver.findElement(By.xpath("//select[@id='second']"));
        Select selectFoods = new Select(selectElement3);
        selectFoods.selectByVisibleText("Pizza");
        selectFoods.selectByVisibleText("Burger");
        Thread.sleep(3000);
        selectFoods.deselectByVisibleText("Pizza");

        List<WebElement> foodItems = selectFoods.getOptions();
        // [webelement1, webelement2, webelement3, webelement4]
        System.out.println(foodItems.get(0).getText());

    }

    public static void selectMenu2(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");

        // from 1st dropdown select Sunday
        WebElement singleSelect = webDriver.findElement(By.id("select-demo"));
        Select select1 = new Select(singleSelect);
        select1.selectByVisibleText("Friday");

        // from 2nd dropdown select California and Texas
        WebElement multipleSelect = webDriver.findElement(By.id("multi-select"));
        Select select2 = new Select(multipleSelect);
        select2.selectByVisibleText("California");
        select2.selectByVisibleText("Texas");




    }

    public static void checkboxes(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://formy-project.herokuapp.com/checkbox");

        WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
        checkbox1.click();
        System.out.println(checkbox1.isSelected());
        System.out.println(checkbox1.isDisplayed());
        System.out.println(checkbox1.isEnabled());
    }

    public static void radioButtons(){
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://formy-project.herokuapp.com/radiobutton");
        webDriver.findElement(By.xpath("//input[@value='option3']")).click();
    }

    public static void completeWebForm() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.id("first-name")).sendKeys("Mike");
        driver.findElement(By.id("last-name")).sendKeys("Thompson");
        driver.findElement(By.id("job-title")).sendKeys("Software Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();

        WebElement selectExperienceElement = driver.findElement(By.id("select-menu"));
        Select select = new Select(selectExperienceElement);
        select.selectByIndex(2);

        driver.findElement(By.id("datepicker")).sendKeys("12/01/2023");
        Thread.sleep(3000);
        driver.findElement(By.linkText("Submit")).click();

    }
}
