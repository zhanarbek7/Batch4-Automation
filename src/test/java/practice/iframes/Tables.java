package practice.iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import java.util.List;

public class Tables {
    public static void main(String[] args) {
        test();
    }

    public static void table1(){
        // go to this website: https://www.w3schools.com/html/html_tables.asp
        // find the table
        // print all rows and columns
        // Alfreds  Maria Anders    Germany
        // ...
        //
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // 1st way - easy way
//        WebElement element = driver.findElement(By.xpath("//table[@class='ws-table-all']"));
//        System.out.println(element.getText());

        // 2nd way
//        List<WebElement> element = driver.findElements(By.xpath("//table[@class='ws-table-all']/tbody/tr/td"));
//        int k = 1;
//
//        for(int i =0; i < element.size();i++) {
//            k++;
//            System.out.print(element.get(i).getText() + " ");
//
//            if(k==3){
//                System.out.println();
//                k=1;
//            }
//        }

        // 3rd way
        WebElement table = driver.findElement(By.id("customers"));
        List<WebElement> tRows = table.findElements(By.xpath("./tbody/tr"));

        for (int i = 1; i < tRows.size(); i++) {
            WebElement row = tRows.get(i);
            List<WebElement> tCells = row.findElements(By.xpath(".//td"));
            for(WebElement cell: tCells){
                System.out.print(cell.getText()+ " ");
            }
            System.out.println();
        }
    }

    public static void test(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://demoqa.com/frames");
        WebElement element = driver.findElement(By.id("sampleHeading"));
    }
}
