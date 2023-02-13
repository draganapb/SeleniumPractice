package Selenium_zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) throws InterruptedException {
        //login to site"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wordpress.com/");

        System.out.println(driver.getCurrentUrl());
        WebElement login = driver.findElement(By.linkText("Log In"));
        login.click();

        Thread.sleep(3000);
        WebElement inputLogin = driver.findElement(By.id("usernameOrEmail"));
        inputLogin.sendKeys("maraiskljucenja@gmail.com");

        WebElement continueButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        continueButton.click();

        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("passwordmara");

        WebElement loginButton = driver.findElement(By.cssSelector(".button.form-button.is-primary"));
        loginButton.click();

        Thread.sleep(7000);

        String expectedURL = "https://wordpress.com/read";
        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(actualURL, expectedURL);
        Thread.sleep(10000);

        WebElement image = driver.findElement(By.cssSelector(".empty-content__illustration"));
        Assert.assertTrue(image.isDisplayed());

        //System.out.println(driver.getCurrentUrl());

        WebElement title = driver.findElement(By.cssSelector(".empty-content__title"));
        String expectedTitle = "Добродошли у Читалац";
        Assert.assertEquals(title.getText(), expectedTitle);
    }
}
