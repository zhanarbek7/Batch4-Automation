package tests.oldtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("https://google.com");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("hi");
    }

    public static void findTees30dollars() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.linkText("Men")).click();
        driver.findElement(By.linkText("Tees")).click();
        List<WebElement> prices =
                driver.findElements(By.xpath("//span[@data-price-type='finalPrice']"));

        ArrayList<Integer> addToCartProducts = new ArrayList<>();

        for (int j = 0; j < prices.size(); j++) {
            WebElement i = prices.get(j);
            double price = Double.parseDouble(i.getText().substring(1));
            if (price > 30) {
                addToCartProducts.add(j+1);
            }
        }
        System.out.println(addToCartProducts);
        // later we will use this addToCartProducts [1,2,10]
    }

    public static void hello(){
        WebDriver webDriver = Driver.getDriver();
        webDriver.get("https://www.google.com/");
        webDriver.quit();
    }

    public static void bye(){
        WebDriver webDriver = Driver.getDriver();
        webDriver.get("https://www.youtube.com/");
        webDriver.quit();
    }

}
