package Selenium_domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2_4 {
    public static void main(String[] args) {
        //valid username, no password
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

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement error = driver.findElement(By.id("error"));
        Assert.assertTrue(error.isDisplayed());

        WebElement notification = driver.findElement(By.id("error"));
        String expectedNotification = "Your password is invalid!";
        Assert.assertEquals(notification.getText(), expectedNotification);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);


    }
}
