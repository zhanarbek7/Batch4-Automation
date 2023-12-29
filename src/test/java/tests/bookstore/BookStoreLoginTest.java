package tests.bookstore;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import pages.demoQABooks.BookStoreLoginPage;
import utilities.Config;
import utilities.Driver;

public class BookStoreLoginTest {

    BookStoreLoginPage bookStoreMainPage = new BookStoreLoginPage(Driver.getDriver());

    @Test
    public void successfulLogin() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("demoQA.bookstore.url")+"login");
        bookStoreMainPage.usernameBox.sendKeys(Config.getValue("demoQA.bookstore.username"));
        bookStoreMainPage.passwordBox.sendKeys(Config.getValue("demoQA.bookstore.password"));
        bookStoreMainPage.loginButton.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://demoqa.com/profile");
    }

    @Test
    public void noCredentialsLogin() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("demoQA.bookstore.url")+"login");
        bookStoreMainPage.loginButton.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(actualUrl, "https://demoqa.com/profile");
    }

    @Test
    public void noUsernameLogin() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("demoQA.bookstore.url")+"login");
        bookStoreMainPage.passwordBox.sendKeys(Config.getValue("demoQA.bookstore.password"));
        bookStoreMainPage.loginButton.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(actualUrl, "https://demoqa.com/profile");
    }

    @Test
    public void noPasswordLogin() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("demoQA.bookstore.url")+"login");
        bookStoreMainPage.usernameBox.sendKeys(Config.getValue("demoQA.bookstore.username"));
        bookStoreMainPage.loginButton.click();
        Thread.sleep(1000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertNotEquals(actualUrl, "https://demoqa.com/profile");
    }

    @AfterClass()
    public void cleanUp(){
        Driver.getDriver().quit();
    }



}
