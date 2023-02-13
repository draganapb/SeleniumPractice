package Selenium_zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collection;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
//Zadatak jeste da se ulogujete i proverite da li ste zaista ulogovani, proveri na videu za assetove jesu li svi tu
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement menuItem = driver.findElement(By.id("menu-item-20"));
        menuItem.click();

        WebElement clickLogin = driver.findElement(By.linkText("Test Login Page"));
        clickLogin.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");

        WebElement searchButton = driver.findElement(By.id("submit"));
        searchButton.click();

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();
        //Assert.assertEquals(driver.getCurrentUrl(), expectedURL); profesor
        Assert.assertEquals(expectedURL, actualURL);

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logoutButton.isDisplayed());

        WebElement pageTitle = driver.findElement(By.cssSelector(".post-title"));
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(expectedTitle,pageTitle.getText() );










      /*  WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        logoutButton.click();

       String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement username1 = driver.findElement(By.id("username"));
        Assert.assertTrue(username1.isDisplayed());

       */







        }


    }

