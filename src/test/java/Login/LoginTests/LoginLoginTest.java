package Login.LoginTests;

import Login.LoginBase.LoginBaseTest;
import Login.LoginPages.LoginPage;
import Login.LoginPages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginLoginTest extends LoginBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(loginURL);
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @Test
    public void userCanLogIn() {
        String validUsername = excelReader.getStringData("Login", 1, 0);
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.insertUsername(validUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertTrue(profilePage.LogOutButton.isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername() {
        String invalidUsername = excelReader.getStringData("Login", 1, 2);
        String validPassword = excelReader.getStringData("Login", 1,1);
        loginPage.insertUsername(invalidUsername);
        loginPage.insertPassword(validPassword);
        loginPage.clickOnSubmitButton();
        Assert.assertFalse(isDisplayed(profilePage.LogOutButton));
    }



}
