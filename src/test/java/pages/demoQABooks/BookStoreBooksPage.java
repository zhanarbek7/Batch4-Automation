package pages.demoQABooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStoreBooksPage extends BookStoreLoginPage{

    WebDriver driver;

    public BookStoreBooksPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='rt-table']//a")
    public List<WebElement> books;









}
