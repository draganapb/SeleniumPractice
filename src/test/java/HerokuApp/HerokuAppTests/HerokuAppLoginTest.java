package HerokuApp.HerokuAppTests;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HerokuAppLoginTest extends HerokuAppBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(LoginURL);
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();
    }
    public void assertInvalidLogin(){
        Assert.assertEquals(LoginURL, driver.getCurrentUrl());
        Assert.assertNotEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
        Assert.assertFalse(isDisplayed(herokuAppLogoutPage.LogOutButton));
    }
    @Test (priority = 10)
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        Assert.assertEquals(herokuAppLogoutPage.getNotificationText(), "You logged into a secure area!\n" + "×");
        Assert.assertEquals(driver.getCurrentUrl(), LogoutURL);
    }
    @Test (priority = 20)
    public void userCannotLoginWithInvalidPassword(){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String invalidPassword = excelReader.getStringData("Login", 1, 3);

        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
    @Test (priority = 30)
    public void userCannotLoginWithInvalidUsername(){
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1, 1);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
    @Test (priority = 40)
    public void userCannotLoginWithInvalidUsernameAndPassword(){
        String invalidUsername = excelReader.getStringData("Login", 2, 2);
        String invalidPassword = excelReader.getStringData("Login", 2, 3);

        herokuAppLoginPage.insertUsername(invalidUsername);
        herokuAppLoginPage.inserPassword(invalidPassword);
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
    @Test (priority = 50)
    public void userCannotLoginWithoutUsername(){
        String validPassword = excelReader.getStringData("Login", 1, 1);
        herokuAppLoginPage.getUsername().clear();
        herokuAppLoginPage.inserPassword(validPassword);
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
    @Test (priority = 60)
    public void userCannotLoginWithoutPassword(){
        String validUsername = excelReader.getStringData("Login", 1, 0);
        herokuAppLoginPage.insertUsername(validUsername);
        herokuAppLoginPage.getPassword().clear();
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
    @Test (priority = 70)
    public void userCannotLoginWithoutUsernameAndPassword(){
        herokuAppLoginPage.getUsername().clear();
        herokuAppLoginPage.getPassword().clear();
        herokuAppLoginPage.clickOnLogInButton();
        assertInvalidLogin();
    }
}
