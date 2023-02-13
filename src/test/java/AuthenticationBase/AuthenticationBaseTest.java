package AuthenticationBase;

import AuthenticationPages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class AuthenticationBaseTest {
    public  WebDriver driver;
    public  WebDriverWait wdwait;
    public HomePage homePage;
    public String loginUrl ;

    @BeforeClass
    public void pageSetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wdwait);
        loginUrl = "https://the-internet.herokuapp.com/";
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
