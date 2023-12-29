package pages.demoQABooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;

    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gotoStore")
    public WebElement goToBookStoreButton;

    @FindBy(xpath = "button[@id='submit' and .='Delete Account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "button[@id='submit' and .='Delete All Books']")
    public WebElement deleteAllBooksButton;
}
