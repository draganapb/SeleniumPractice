package WordPressTests;

import WordPressBase.WordPressBaseTests;
import WordPressPages.HomePage;
import WordPressPages.LoginPage;
import WordPressPages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends WordPressBaseTests {
    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");
        loginPage = new LoginPage(driver, wdwait);
        logoutPage = new LogoutPage(driver,wdwait);
        //loginTest = new LoginTest();
        //homePage = new HomePage(driver, wdwait);
    }

    @Test
    public void userCanLogout() throws InterruptedException {
        loginTest.userCanLogIn();
    }
}
