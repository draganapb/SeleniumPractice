package Selenium_domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2_1 {
    public static void main(String[] args) {
        //invalid password
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");

        WebElement menuItem = driver.findElement(By.id("menu-item-20"));
        menuItem.click();

        WebElement linkLogin = driver.findElement(By.linkText("Test Login Page"));
        linkLogin.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());


        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);

    }
}
