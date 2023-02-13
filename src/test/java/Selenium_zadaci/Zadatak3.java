package Selenium_zadaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) {
//Zadatak 3
//Otici na Google
//Zatim ukucati "Wikipedia" u polje za pretragu
//Odraditi pretragu i otvoriti stranicu
//Na stranici Wikipedia pretraziti "Nikola Tesla"

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        WebElement searchbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        searchbox.sendKeys("Wikipedia");
        searchbox.sendKeys(Keys.ENTER);

        WebElement website = driver.findElement(By.xpath("/html/body/div[7]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div[1]/a/h3"));
        website.click();

        WebElement searchWikiBox = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/input"));
        searchWikiBox.sendKeys("Nikola Tesla");
        searchWikiBox.sendKeys(Keys.ENTER);
      //  WebElement listedItem = driver.findElement(By.xpath("/html/body/div[3]/form/fieldset/div/div[2]/div/a[1]"));
       // listedItem.click();


    }
}
