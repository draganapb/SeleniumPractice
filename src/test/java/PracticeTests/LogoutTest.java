package PracticeTests;

import PracticeBase.PracticeBaseTest;
import PracticePages.PracticeLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends LoginTest {
    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");
    }
    public void assertLogOut(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/");
        boolean buttonLogOut = false;
        try{
            buttonLogOut = practiceProfilePage.getLogOutButton().isDisplayed();
        }catch (Exception e){

        }Assert.assertFalse(buttonLogOut);
    }

    @Test
    public void userCanLogOut(){
       userCanLogIn();
       practiceProfilePage.clickOnLogOutButton();
       assertLogOut();
    }

}
