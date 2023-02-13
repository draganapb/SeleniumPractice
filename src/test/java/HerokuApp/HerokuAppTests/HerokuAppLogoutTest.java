package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLogoutTest extends HerokuAppBaseTest {


    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();

    }

    @Test
    public void userCanLogOut() throws InterruptedException {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Thread.sleep(3000);
        herokuAppLogoutPage.ClickLogOutButton();

        Assert.assertEquals(LoginURL, driver.getCurrentUrl());
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged out of the secure area!\n" + "×");
        Assert.assertTrue(isDisplayed(herokuAppLoginPage.LogInButton));


    }
}
