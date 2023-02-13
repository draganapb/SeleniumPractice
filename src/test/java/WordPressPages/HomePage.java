package WordPressPages;

import WordPressBase.WordPressBaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends WordPressBaseTests{
    public WebDriver driver;

    public WebDriverWait wdwait;

     WebElement LogInButton;
    public WebElement getLogInButton() {

        return driver.findElement(By.linkText("Log In"));
    }
    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void logInClick(){
        getLogInButton().click();
    }
}
