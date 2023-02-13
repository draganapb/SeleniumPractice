package HerokuApp.HerokuAppPages;

import HerokuApp.HerokuAppBase.HerokuAppBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppLoginPage extends HerokuAppBaseTest {
    public HerokuAppLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement Username;

    @FindBy(id = "password")
    public WebElement Password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    public WebElement LogInButton;

    //----------------------

    public void insertUsername(String username) {
        Username.clear();
        Username.sendKeys(username);
    }


    public void inserPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    public WebElement getUsername() {
        return Username;
    }

    public WebElement getPassword() {
        return Password;
    }

    public void clickOnLogInButton() {
        LogInButton.click();
    }

}
