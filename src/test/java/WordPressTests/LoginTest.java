package WordPressTests;

import WordPressBase.WordPressBaseTests;
import WordPressPages.HomePage;
import WordPressPages.LoginPage;
import WordPressPages.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends WordPressBaseTests {

    @BeforeMethod
    public void pageSetup(){
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/");
        loginPage = new LoginPage(driver, wdwait);
        logoutPage = new LogoutPage(driver, wdwait);

    }
    public void assertLogin(){
        String expectedURL = "https://wordpress.com/read";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);

        WebElement title = driver.findElement(By.cssSelector(".empty-content__title"));
        String expectedTitle = "Добродошли у Читалац";
        Assert.assertEquals(title.getText(), expectedTitle);
    }
    public void assertInvalidLogin() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
        Assert.assertTrue(isDisplayed(loginPage.getContinueButton()));
        Assert.assertTrue(isDisplayed(loginPage.getErrorValidationNotification()));
    }

    @Test
    public void userCanLogIn() throws InterruptedException {
        String validEmail = "maraiskljucenja@gmail.com";
        String validPassword = "passwordmara";
     homePage.logInClick();
     Thread.sleep(3000);
     waitForClickability(loginPage.getUsernameEmailField());
     loginPage.emailOrUsernameEntry(validEmail);
     loginPage.clickOnContinueButton();
     waitForClickability(loginPage.getPasswordField());
     loginPage.passwordEntry(validPassword);
     loginPage.clickLogInButton();
     Thread.sleep(9000);
     assertLogin();
    }
    @Test
    public void userCannotLogInWithInvalidEmail() throws InterruptedException {
        String invalidEmail = "maraiskljucenjagmail.com";

        homePage.logInClick();
        Thread.sleep(3000);
        waitForClickability(loginPage.getUsernameEmailField());
        loginPage.emailOrUsernameEntry(invalidEmail);
        loginPage.clickOnContinueButton();
        Thread.sleep(4000);
        assertInvalidLogin();
    }
    @Test
    public void userCannotLogInWithoutEmail() throws InterruptedException {
        String invalidEmail = "maraiskljucenjagmail.com";

        homePage.logInClick();
        Thread.sleep(3000);
        loginPage.getUsernameEmailField().clear();
        loginPage.clickOnContinueButton();
        Thread.sleep(4000);
        assertInvalidLogin();
    }
    @Test
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        String validEmail = "maraiskljucenja@gmail.com";
        String invalidPassword = "password";
        homePage.logInClick();
        Thread.sleep(3000);
        waitForClickability(loginPage.getUsernameEmailField());
        loginPage.emailOrUsernameEntry(validEmail);
        loginPage.clickOnContinueButton();
        waitForClickability(loginPage.getPasswordField());
        loginPage.passwordEntry(invalidPassword);
        loginPage.clickLogInButton();
        assertInvalidLogin();
    }
    @Test
    public void userCannotLogInWithoutPassword() throws InterruptedException {
        String validEmail = "maraiskljucenja@gmail.com";
        homePage.logInClick();
        Thread.sleep(3000);
        waitForClickability(loginPage.getUsernameEmailField());
        loginPage.emailOrUsernameEntry(validEmail);
        loginPage.clickOnContinueButton();
        waitForClickability(loginPage.getPasswordField());
        loginPage.getPasswordField().clear();
        loginPage.clickLogInButton();
        assertInvalidLogin();
    }

}
