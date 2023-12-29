package pages.demoQABooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookStoreLoginPage {

    WebDriver driver;

    public BookStoreLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BookStoreLoginPage(){}

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(xpath = "button[@id='submit' and .='Log out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='element-group'][6]")
    public WebElement bookStoreButton;


}
