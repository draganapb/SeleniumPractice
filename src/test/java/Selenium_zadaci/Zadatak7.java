package Selenium_zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {
        //Zadatak 7 - Ulogovati se na sajt https://demoqa.com/ preko kolacica,
        //izlogovati se i asertovati da je korisnik izlogovan
        //kad se ulogujemo proveriti koje cookijeve mozemo da dodamo

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        Cookie cookie = new Cookie("userName", "Mara");
        Cookie cookie1 = new Cookie("userID", "c1b7cae6-0c9f-474d-93d5-22ae2e049e9c");
        Cookie cookie2 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmEiLCJwYXNzd29yZCI6IlBhc3N3b3JkbWFyYTEhIiwiaWF0IjoxNjczNTUwNjQzfQ.lt5JxOZp4ZXCKNHHVv6LzcOp_U_7saAvuyvLfu4j59Y");
        Cookie cookie3 = new Cookie("panoramaId_expiry", "1673636780667");
        Cookie cookie4 = new Cookie("_cc_id", "901f621b9b4ef2d151a17230772a5dae");
        Cookie cookie5 = new Cookie("_lr_retry_request", "true");
        Cookie cookie6 = new Cookie("_lr_env_src_ats", "false");
        Cookie cookie7 = new Cookie("expires", "2023-01-19T19%3A10%3A43.174Z");

        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.manage().addCookie(cookie5);
        driver.manage().addCookie(cookie6);
        driver.manage().addCookie(cookie7);
        driver.navigate().refresh();













    }
}
