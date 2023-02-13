package Selenium_domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Domaci4 {
    //Prethodni zadatak za dodavanje knjiga uraditi koristeci Anotacije.
    // Da jedan test bude sa dodavanjem jedne knjige, drugi test sa dodavanjem dve knjige, treci sa tri itd.
    WebDriver driver;
    WebDriverWait wdwait;
    JavascriptExecutor js;
    WebElement notificationNoBooks;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @BeforeMethod
    public void setUpPage() throws InterruptedException {
        driver.manage().window().maximize();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
        driver.navigate().to("https://demoqa.com/login");
        Cookie userID = new Cookie("userID", "c1b7cae6-0c9f-474d-93d5-22ae2e049e9c");
        Cookie expires = new Cookie("expires", "2023-01-23T13%3A16%3A45.484Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmEiLCJwYXNzd29yZCI6IlBhc3N3b3JkbWFyYTEhIiwiaWF0IjoxNjczODc1MDA1fQ.RMCe-XuSb6gh1GdSmYBKhR26K9e1b2DXzNpUb6dI5i4");
        Cookie username = new Cookie("userName", "Mara");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);
        driver.manage().addCookie(username);
        driver.navigate().refresh();
        WebElement profilLink = driver.findElement(By.linkText("profile"));
        profilLink.click();
        WebElement notificationNoBooks = driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(notificationNoBooks.isDisplayed());
    }

    @Test
    public void dodavanjeJedneKnjige() throws InterruptedException {

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
        Thread.sleep(3000);


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

        Thread.sleep(2000);

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
//////////////////////////////////////////////////////////////////////////////////////////
        js.executeScript("window.scrollBy(0,500)");
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
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
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
        Thread.sleep(2000);

        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();


        List<WebElement>IDprofile = driver.findElements(By.id("item-3"));
        for(int i = 0; i<IDprofile.size(); i++){
            if(IDprofile.get(i).getText().equalsIgnoreCase("Profile")){
                IDprofile.get(i).click();
            }
            Thread.sleep(3000);
            boolean notification = false;
            try{
                notificationNoBooks = driver.findElement(By.className("rt-noData"));
                notification = notificationNoBooks.isDisplayed();
            }catch (org.openqa.selenium.NoSuchElementException ex){
                Assert.assertFalse(notification);
            }
        }
        int brojac = 0;
        List<WebElement>brojKnjiga = driver.findElements(By.className("rt-tbody"));
        for(int i = 0; i<brojKnjiga.size(); i++){
            System.out.println("===============");
            System.out.println(brojKnjiga.get(i).getText());
//            System.out.println(brojKnjiga.get(i).findElements(By.className(".rt-tr.-odd")));
            System.out.println("===============");
            if(brojKnjiga.get(i).findElements(By.className(".rt-tr.-odd")) != null){
                brojac = brojac + 1;
            }
            if(brojKnjiga.get(i).findElements(By.className(".rt-tr.-even")) != null){
                brojac = brojac + 1;
            }
        }
        Assert.assertEquals(2, brojac);
    }
}

















