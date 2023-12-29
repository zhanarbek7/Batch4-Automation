package tests.bookstore;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import pages.demoQABooks.BookPage;
import pages.demoQABooks.BookStoreBooksPage;
import utilities.Config;
import utilities.Driver;

public class BookStoreBooksTest {

    BookPage bookPage = new BookPage(Driver.getDriver());
    BookStoreBooksPage booksPage = new BookStoreBooksPage(Driver.getDriver());


    @Test
    public void add1stBookToCollection() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("demoQA.bookstore.url")+"login");
        booksPage.usernameBox.sendKeys(Config.getValue("demoQA.bookstore.username"));
        booksPage.passwordBox.sendKeys(Config.getValue("demoQA.bookstore.password"));
        booksPage.loginButton.click();
        Thread.sleep(5000);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView();",booksPage.bookStoreButton);
        booksPage.bookStoreButton.click();
        booksPage.books.get(0).click();
//        Thread.sleep(2500);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView();",bookPage.addToCollectionButton);
        bookPage.addToCollectionButton.click();
        Thread.sleep(5000);
    }

    @AfterClass
    public void cleanUp(){
        Driver.getDriver().quit();
    }

}
