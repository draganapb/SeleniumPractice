package DemoQATests;

import DemoQABase.DemoQABaseTest;
import DemoQAPages.HomePage;
import DemoQAPages.SideBarPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoQABookstore extends DemoQABaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        HomePage = new HomePage(driver, wdwait);
        SideBarPage = new SideBarPage(driver, wdwait);
    }

    public void logIn() {
        Cookie userID = new Cookie("userID", "362c8c84-7846-4bcd-9625-ef0df047ff54");
        Cookie username = new Cookie("userName", "dragoljubqa");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2NzM5MDIxMTh9.ANWhSfME__ZjZkor8DsrtLeTsGaJLc0JnV80EIEQWeU");
        Cookie expires = new Cookie("expires", "2023-01-23T20%3A48%3A38.913Z");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(username);
        driver.manage().addCookie(token);
        driver.manage().addCookie(expires);
        driver.navigate().refresh();
    }
    public void assertNoBooks(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        WebElement notificationNoBooks = driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(notificationNoBooks.isDisplayed());
    }

    @Test
    public void test1() throws InterruptedException {
        scrollIntoView(HomePage.getCards().get(5));
        HomePage.clickOnBookstore();
        logIn();
        scrollIntoView(SideBarPage.getButtons().get(SideBarPage.getButtons().size()-1));
        SideBarPage.clickOnButton("Profile");
        assertNoBooks();
        scrollIntoView(SideBarPage.getButtons().get(SideBarPage.getButtons().size()-1));

    }

}
