package WordPressBase;

import WordPressPages.HomePage;
import WordPressPages.LoginPage;
import WordPressPages.LogoutPage;
import WordPressTests.LoginTest;
import WordPressTests.LogoutTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WordPressBaseTests {

    public WebDriver driver;

    public WebDriverWait wdwait;
    public HomePage homePage;
    public LoginPage loginPage;
    public LogoutPage logoutPage;
    public LoginTest loginTest;
    public LogoutTest logoutTest;


    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver,wdwait);
        loginPage = new LoginPage(driver, wdwait);
        logoutPage = new LogoutPage(driver,wdwait);
        //logoutTest = new LogoutTest();
        loginTest = new LoginTest();
    }
    public void waitForClickability(WebElement element) {
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForVisability(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isDisplayed(WebElement element){
        boolean webelement = false;
        try {
            webelement = element.isDisplayed();
        } catch (Exception e) {

        }
        return webelement;
    }

    @AfterClass
    public void tearDown(){

    }

}


