package Selenium_zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak9 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://imgflip.com/memegenerator");
        WebElement uploadButton = driver.findElement(By.id("mm-show-upload"));
        uploadButton.click();

        WebElement uploadButtonFile = driver.findElement(By.id("mm-upload-file"));
        uploadButtonFile.sendKeys("C:\\Users\\Dragana\\Desktop\\77igi3.jpg");

        WebElement uploadButon2 = driver.findElement(By.id("mm-upload-btn"));
        uploadButon2.click();

        WebElement generateButton = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateButton.click();


    }
}
