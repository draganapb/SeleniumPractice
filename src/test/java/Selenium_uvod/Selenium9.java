package Selenium_uvod;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class Selenium9 {

        WebDriver driver;

        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        @BeforeMethod
        public void pageSetUp(){
            driver.manage().window().maximize();
            driver.navigate().to("https://practicetestautomation.com/");
        }

        @Test
        public void userCanLogIn() {
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password123");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement logOutButton = driver.findElement(By.linkText("Log out"));
            Assert.assertTrue(logOutButton.isDisplayed());
            WebElement notification = driver.findElement(By.className("post-title"));
            Assert.assertEquals(notification.getText(), "Logged In Successfully");
            Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/logged-in-successfully/");
        }

        @Test
        public void userCanLogOut() {

        }

        @Test
        public void userCantLoginWithInvalidUsername (){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("studenti");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password123");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            WebElement notification = driver.findElement(By.id("error"));
            Assert.assertEquals(notification.getText(), "Your username is invalid!");
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");

        }

        @Test
        public void userCantLoginWithInvalidPassword(){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password12");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            Assert.assertEquals(error.getText(), "Your password is invalid!");
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");

        }
        @Test
        public void userCantLoginWithEmptyFields(){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");


        }
        @Test
        public void userCantLoginWithInvalidPasswordAndInvalidUsername(){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("studen");
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Password12");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");
        }
        @Test
        public void userCantLoginWithValidPasswordNoUsername(){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("studen");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            Assert.assertEquals(error.getText(), "Your username is invalid!");
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");

        }

        @Test
        public void userCantLoginWithNoPasswordValidUsername(){
            WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
            practiceButton.click();
            WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
            testLoginPageButton.click();
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("student");
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();
            WebElement error = driver.findElement(By.id("error"));
            Assert.assertTrue(error.isDisplayed());
            Assert.assertEquals(error.getText(), "Your password is invalid!");
            Assert.assertEquals(driver.getCurrentUrl(),"https://practicetestautomation.com/practice-test-login/");

        }
    }

