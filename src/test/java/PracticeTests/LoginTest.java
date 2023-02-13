package PracticeTests;

import PracticeBase.PracticeBaseTest;
import PracticeBase.PracticeBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends PracticeBaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

    }

    public void assertInvalidUsername(){
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement username1 = driver.findElement(By.id("username"));
        WebElement password1 = driver.findElement(By.id("password"));
        WebElement submitButton1 = driver.findElement(By.id("submit"));

        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(password1.isDisplayed());
        Assert.assertTrue(submitButton1.isDisplayed());
    }

    public void assertInvalidPassword(){
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your password is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    public void assertInvalidUsernameAndPassword(){
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }
    public void assertEmptyFields(){
        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        boolean logOut = false;
        try {
            logOut = driver.findElement(By.linkText("Log out")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(logOut);

        WebElement errorNotification = driver.findElement(By.className("show"));
        String expectedNotification = "Your username is invalid!";
        wdwait.until(ExpectedConditions.textToBePresentInElement(errorNotification, expectedNotification));
        Assert.assertEquals(errorNotification.getText(), expectedNotification);
    }

    public void emptyFieldUsername(){
        practiceLoginPage.getUsernameField().clear();
    }
    public void emptyFieldPassword(){
        practiceLoginPage.getPasswordField().clear();

    }
    @Test
    public  void userCanLogIn() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("student");
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
        Assert.assertTrue(practiceProfilePage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsername(){
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("studen");
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
        assertInvalidUsername();
    }

    @Test
    public void userCannotLogInWithInvalidPassword() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("student");
        practiceLoginPage.insertPassword("Password");
        practiceLoginPage.clickOnSubmitButton();
        assertInvalidPassword();

    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        practiceLoginPage.insertUsername("studen");
        practiceLoginPage.insertPassword("Password");
        practiceLoginPage.clickOnSubmitButton();
        assertInvalidUsernameAndPassword();

    }

    @Test
    public void userCannotLogInWithEmptyFields() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        emptyFieldUsername();
        emptyFieldPassword();
        practiceLoginPage.clickOnSubmitButton();
        assertEmptyFields();

    }
    @Test
    public void userCannotLogInWithEmptyUsernameField() {
        practiceSidebarPage.clickOnPracticeButton();
        practicePracticePage.clickOnTestLoginPageButton();
        emptyFieldUsername();
        practiceLoginPage.insertPassword("Password123");
        practiceLoginPage.clickOnSubmitButton();
        assertInvalidUsernameAndPassword();


    }
}