package AuthenticationTests;

import AuthenticationBase.AuthenticationBaseTest;
import AuthenticationPages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class AuthenticationLoginTest extends AuthenticationBaseTest {
    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver, wdwait);



    @BeforeMethod
    public void pageSetUp(){

        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/");

    }
    @Test
    public void userCanLogin(){
    //homePage.clickOnBasicAuthButton();
    }

}
