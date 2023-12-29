package pages.demoQABooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookPage extends BookStoreLoginPage{

    WebDriver driver;

    public BookPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // element at the index 0 in the list will always be logout button
    @FindBy(xpath = "//label[@id='userName-value']")
    public List<WebElement> bookDetails;

    @FindBy(id = "addNewRecordButton")
    public WebElement addToCollectionButton;

}
