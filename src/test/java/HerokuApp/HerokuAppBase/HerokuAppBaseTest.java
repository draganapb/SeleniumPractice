package HerokuApp.HerokuAppBase;

import HerokuApp.HerokuAppPages.HerokuAppLoginPage;
import HerokuApp.HerokuAppPages.HerokuAppLogoutPage;
import HerokuApp.HerokuAppTests.HerokuAppLoginTest;
import HerokuApp.HerokuAppTests.HerokuAppLogoutTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class HerokuAppBaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String LoginURL;
    public String LogoutURL;

    public HerokuAppLoginPage herokuAppLoginPage;
    public HerokuAppLogoutPage herokuAppLogoutPage;
    public HerokuAppLoginTest herokuAppLoginTest;
    public HerokuAppLogoutTest herokuAppLogoutTest;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/HerokuApp/TestData.xlsx");
        LoginURL = excelReader.getStringData("URL", 1, 0);
        LogoutURL = excelReader.getStringData("URL",1, 1 );
        herokuAppLoginPage = new HerokuAppLoginPage();
        herokuAppLogoutPage = new HerokuAppLogoutPage();

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
    public void TearDown(){

    }
}
