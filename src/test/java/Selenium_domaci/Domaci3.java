package Selenium_domaci;

import com.github.dockerjava.api.model.WaitResponse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Duration;
import java.util.List;

public class Domaci3 {
    public static void main(String[] args) throws InterruptedException {
        //Ulogujte se na demoqa preko cookies-a, dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
        //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/login");

        Cookie userID = new Cookie("userID", "c1b7cae6-0c9f-474d-93d5-22ae2e049e9c");
        Cookie expires = new Cookie("expires", "2023-01-24T09%3A41%3A16.682Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmEiLCJwYXNzd29yZCI6IlBhc3N3b3JkbWFyYTEhIiwiaWF0IjoxNjczOTQ4NDc2fQ.WegIjpx8wQbZNAaxTBNlAV3P-YdrA8qFsPntnr1Q1eo");
        Cookie username = new Cookie("userName", "Mara");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);
        driver.manage().addCookie(username);

        driver.navigate().refresh();

        WebElement profilLink = driver.findElement(By.linkText("profile"));
        profilLink.click();

        js.executeScript("window.scrollBy(0,450)");
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();

        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("see-book-Git Pocket Guide"))).click();

        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,450)");

      wdwait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        List<WebElement> buttonAdd = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < buttonAdd.size(); i++) {
            if (buttonAdd.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                buttonAdd.get(i).click();
            }
        }
        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
        try {
            List<WebElement> buttonBackToStore = driver.findElements(By.id("addNewRecordButton"));

            for (int i = 0; i < buttonBackToStore.size(); i++) {

                if (buttonBackToStore.get(i).getText().equalsIgnoreCase("Back To Book Store")) {

                    buttonBackToStore.get(i).click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> buttonBackToStore = driver.findElements(By.id("addNewRecordButton"));

            for (int i = 0; i < buttonBackToStore.size(); i++) {

                if (buttonBackToStore.get(i).getText().equalsIgnoreCase("Back To Book Store")) {

                    buttonBackToStore.get(i).click();
                }
            }
        }

        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,450)");

        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-buttons")));
        try {
            List<WebElement> knjiga2 = driver.findElements(By.cssSelector(".action-buttons"));
            for (int i = 0; i < knjiga2.size(); i++) {
                if (knjiga2.get(i).getText().equalsIgnoreCase("Learning JavaScript Design Patterns")) {
                    knjiga2.get(i).click();

                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> knjiga2 = driver.findElements(By.cssSelector(".action-buttons"));
            for (int i = 0; i < knjiga2.size(); i++) {
                if (knjiga2.get(i).getText().equalsIgnoreCase("Learning JavaScript Design Patterns")){
                    knjiga2.get(i).click();
                }
            }
        }
        js.executeScript("window.scrollBy(0,450)");

        try{
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for(int i =0 ; i< addToCollectionButton.size(); i++){
                if(addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")){
                    addToCollectionButton.get(i).click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex){
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for(int i =0 ; i< addToCollectionButton.size(); i++){
                if(addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")){
                    addToCollectionButton.get(i).click();
                }
            }
        }

        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        js.executeScript("window.scrollBy(0,450)");


        List<WebElement>login  = driver.findElements(By.id("item-0"));
        for(int i = 0; i< login.size(); i++){
            if(login.get(i).getText().equalsIgnoreCase("Login")){
                login.get(i).click();
            }
        }

        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("mara");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Passwordmara1!");
        js.executeScript("window.scrollBy(0,450)");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-buttons")));
        try {
            List<WebElement> knjigaTitle = driver.findElements(By.cssSelector(".action-buttons"));
            System.out.println(knjigaTitle);
            String expectedKnjigaTitle = "Git Pocket Guide";
            for (int i = 0; i < knjigaTitle.size(); i++) {
                if (knjigaTitle.get(i).getText().equalsIgnoreCase("Git Pocket Guide")) {
                    Assert.assertEquals(knjigaTitle.get(i).getText(), expectedKnjigaTitle);
                }
            }
        }
        catch (org.openqa.selenium.StaleElementReferenceException ex){
            List<WebElement> knjigaTitle = driver.findElements(By.cssSelector(".action-buttons"));
            System.out.println(knjigaTitle);
            String expectedKnjigaTitle = "Git Pocket Guide";
            for (int i = 0; i < knjigaTitle.size(); i++) {
                if (knjigaTitle.get(i).getText().equalsIgnoreCase("Git Pocket Guide")) {
                    Assert.assertEquals(knjigaTitle.get(i).getText(), expectedKnjigaTitle);
                }
            }
        }

        List<WebElement>knjigaTitle2 = driver.findElements(By.cssSelector(".action-buttons"));
        String expectedTitle2 = "Learning JavaScript Design Patterns";
        try{

        for(int i = 0; i<knjigaTitle2.size(); i++ ){
            if( knjigaTitle2.get(i).getText().equalsIgnoreCase("Learning JavaScript Design Patterns")){
        Assert.assertEquals(knjigaTitle2.get(i).getText(), expectedTitle2);
            }
        }
        }
catch(org.openqa.selenium.StaleElementReferenceException ex) {
    for (int i = 0; i < knjigaTitle2.size(); i++) {
        if (knjigaTitle2.get(i).getText().equalsIgnoreCase("Learning JavaScript Design Patterns")) {
            Assert.assertEquals(knjigaTitle2.get(i).getText(), expectedTitle2);

        }
    }
}
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
    }
}
