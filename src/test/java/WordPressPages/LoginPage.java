package WordPressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage{
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement usernameEmailField;
    WebElement continueButton;
    WebElement passwordField;
    WebElement loginButton;
    WebElement errorValidationNotification;

    public WebElement getErrorValidationNotification() {
        return driver.findElement(By.cssSelector(".form-input-validation.is-error"));
    }

   // public void setDriver(WebDriver driver) {
   //     this.driver = driver;
   // }

    public WebElement getUsernameEmailField() {
        return driver.findElement(By.id("usernameOrEmail"));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".button.form-button.is-primary"));
    }

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    public void emailOrUsernameEntry(String email){
        getUsernameEmailField().clear();
        getUsernameEmailField().sendKeys(email);
    }

    public void clickOnContinueButton(){
        getContinueButton().click();
    }
    public void passwordEntry(String password){
        getPasswordField().clear();
        getPasswordField().sendKeys(password);
    }
    public void clickLogInButton(){
        getLoginButton().click();
    }


}
