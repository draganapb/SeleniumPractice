package WordPressPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement profileButton;
    WebElement logOutButton;

    public WebElement getProfileButton() {
        return driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me.is-active"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.className(".sidebar__me-signout-text"));
    }

    public LogoutPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    public void clickOnProfile(){
getProfileButton().click();
    }
    public void clickOnLogoutButton(){
        getLogOutButton().click();
    }

}
