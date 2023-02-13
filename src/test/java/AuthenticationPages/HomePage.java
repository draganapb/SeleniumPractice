package AuthenticationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wdwait;

    WebElement BasicAuthButton;
    WebElement title;

    public List<WebElement> getListaLinkova() {
        return (List<WebElement>) driver.findElement(By.xpath("/html/body/div[2]/div/ul"));
    }

    List<WebElement>listaLinkova;

    public WebElement getBasicAuthButton() {
        return driver.findElement(By.linkText("Basic Auth" +"(user and pass: admin)"));
    }

    public WebElement getTitle() {
        return driver.findElement(By.className("heading"));
    }

    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    public void clickOnBasicAuthButton(){
        getBasicAuthButton().click();
    }

    public void list(){

    }
}
