package Selenium_zadaci;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

    public class Zadatak7_cas {
        public static void main(String[] args) {

            //Zadatak 7 - Ulogovati se na sajt https://demoqa.com/ preko kolacica,
            // izlogovati se i asertovati da je korisnik izlogovan

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://demoqa.com/login");

            Cookie userID = new Cookie("userID", "362c8c84-7846-4bcd-9625-ef0df047ff54");
            Cookie expires = new Cookie("expires", "2023-01-19T19%3A47%3A40.307Z");
            Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImRyYWdvbGp1YnFhIiwicGFzc3dvcmQiOiJRd2VydHkxMjMhQCMiLCJpYXQiOjE2NzM1NTI4NjB9.EYUPze9bhpl69bWwaZMy9dQGwF8IzAwtDlnMZAT1hVE");

            driver.manage().addCookie(userID);
            driver.manage().addCookie(expires);
            driver.manage().addCookie(token);

            driver.navigate().refresh();

            WebElement profileButton = driver.findElement(By.linkText("profile"));
            profileButton.click();

            WebElement profileName = driver.findElement(By.id("userName-value"));
            Assert.assertEquals(profileName.getText(), "dragoljubqa");

            List<WebElement> button = driver.findElements(By.id("submit"));
            for (int i = 0; i < button.size(); i++) {
                if (button.get(i).getText().equals("Log out")) {
                    button.get(i).click();
                    break;
                }
            }

            boolean logOutButtonIsDisplayed = false;
            boolean usernameIsDisplayed = false;
            try {
                logOutButtonIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
            } catch (Exception e) {

            }

            try {
                usernameIsDisplayed = driver.findElement(By.id("submit")).isDisplayed();
            } catch (Exception e) {

            }

            Assert.assertFalse(logOutButtonIsDisplayed);
            Assert.assertFalse(usernameIsDisplayed);





        }
    }
