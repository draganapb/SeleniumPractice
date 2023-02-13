package Selenium_domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Domaci4Proba {
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
    }
    public void login(){
        Cookie userID = new Cookie("userID", "c1b7cae6-0c9f-474d-93d5-22ae2e049e9c");
        Cookie expires = new Cookie("expires", "2023-01-24T11%3A29%3A36.666Z");
        Cookie token = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Im1hcmEiLCJwYXNzd29yZCI6IlBhc3N3b3JkbWFyYTEhIiwiaWF0IjoxNjczOTU0OTc2fQ.AwQoFXBfHrriQdx3RcmUUdy0A1D7xwt59k0U1d3KFxw");
        Cookie username = new Cookie("userName", "Mara");
        driver.manage().addCookie(userID);
        driver.manage().addCookie(expires);
        driver.manage().addCookie(token);
        driver.manage().addCookie(username);
        driver.navigate().refresh();
    }
    public void profileNoBooks(){
    WebElement profilLink = driver.findElement(By.linkText("profile"));
    profilLink.click();
    notificationNoBooks = driver.findElement(By.className("rt-noData"));
    Assert.assertTrue(notificationNoBooks.isDisplayed());
}
    public void callingAddingBook() throws InterruptedException {
    login();
    profileNoBooks();
    js.executeScript("window.scrollBy(0,450)");
    wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();
    wdwait.until(ExpectedConditions.elementToBeClickable(By.id("see-book-Git Pocket Guide"))).click();
    js.executeScript("window.scrollBy(0,450)");
    wdwait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton")));
    List<WebElement> buttonAdd = driver.findElements(By.id("addNewRecordButton"));
    for (int i = 0; i < buttonAdd.size(); i++) {
        if (buttonAdd.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
            wdwait.until(ExpectedConditions.elementToBeClickable(buttonAdd.get(i))).click();
            //buttonAdd.get(i).click();
        }
    }
    wdwait.until(ExpectedConditions.alertIsPresent());
    Alert alert = driver.switchTo().alert();
    alert.accept();
    js.executeScript("window.scrollBy(0,450)");
    List<WebElement> IDprofile = driver.findElements(By.id("item-3"));
    for (int i = 0; i < IDprofile.size(); i++) {
        if (IDprofile.get(i).getText().equalsIgnoreCase("Profile")) {
            IDprofile.get(i).click();
        }
        boolean notification = false;
        try {
            notificationNoBooks = driver.findElement(By.className("rt-noData"));
            notification = notificationNoBooks.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException ex) {
            Assert.assertFalse(notification);
        }
    }
    int brojac = 0;
    List<WebElement> brojKnjiga = driver.findElements(By.className("rt-tr-group"));
    for (int i = 0; i < brojKnjiga.size(); i++) {
        System.out.println("===============");
        List<WebElement> brojKnjigaRow = brojKnjiga.get(i).findElements(By.className("rt-td"));
        System.out.println(brojKnjigaRow.size());
        for (int j = 0; j < brojKnjigaRow.size(); j++) {
            try {
                WebElement thereIsImage = brojKnjigaRow.get(i).findElement(By.tagName("img"));
                System.out.println(thereIsImage);
                if (thereIsImage != null) {
                    brojac = brojac + 1;
                    break;
                }
            }
            catch (org.openqa.selenium.NoSuchElementException ex) {
                Assert.assertEquals(1, brojac);

            }
        }
    }
    driver.navigate().refresh();
    //Assert.assertEquals(1, brojac);
    Thread.sleep(5000);
}
    public void callingAdded2books() throws InterruptedException {
    callingAddingBook();
    js.executeScript("window.scrollBy(0,450)");
    wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();
    Thread.sleep(3000);
    js.executeScript("window.scrollBy(0,300)");
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
    try {
        List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addToCollectionButton.size(); i++) {
            if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                addToCollectionButton.get(i).click();
            }
        }
    } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
        for (int i = 0; i < addToCollectionButton.size(); i++) {
            if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                addToCollectionButton.get(i).click();
            }
        }
    }
    wdwait.until(ExpectedConditions.alertIsPresent());
    Alert alert1 = driver.switchTo().alert();
    alert1.accept();
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
    Thread.sleep(2000);
    int brojac = 0;
    List<WebElement>brojKnjiga = driver.findElements(By.className("rt-tr-group"));
    for(int i = 0; i<brojKnjiga.size(); i++) {
        System.out.println("===============");
        List<WebElement> brojKnjigaRow = brojKnjiga.get(i).findElements(By.className("rt-td"));
        System.out.println(brojKnjigaRow.size());
        for (int j = 0; j < brojKnjigaRow.size(); j++) {
            try {
                WebElement thereIsImage = brojKnjigaRow.get(j).findElement(By.tagName("img"));
                System.out.println(thereIsImage);
                if (thereIsImage != null) {
                    brojac = brojac + 1;
                    System.out.println(brojac);
                }
            }
            catch (org.openqa.selenium.NoSuchElementException ex){

            }
        }
    }
    Assert.assertEquals(2, brojac);
}
public void brisanjeKnjiga(){
   try{
       WebElement deleteButton1 = driver.findElement(By.id("delete-record-undefined"));
    List<WebElement>delete = driver.findElements(By.id("delete-record-undefined"));
    for(int i = 0; i<delete.size(); i++){
        delete.get(i).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));
        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();
        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
   }
catch(org.openqa.selenium.StaleElementReferenceException ex){
    WebElement deleteButton1 = driver.findElement(By.id("delete-record-undefined"));
    List<WebElement>delete = driver.findElements(By.id("delete-record-undefined"));
    for(int i = 0; i<delete.size(); i++){
        delete.get(i).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("closeSmallModal-ok"))));
        WebElement okButton = driver.findElement(By.id("closeSmallModal-ok"));
        okButton.click();
        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }
}
}
    @Test (priority = 10)
    public void dodavanjeJedneKnjige() throws InterruptedException {
        login();
        profileNoBooks();
        js.executeScript("window.scrollBy(0,450)");
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();
        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("see-book-Git Pocket Guide"))).click();
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
        js.executeScript("window.scrollBy(0,450)");
        List<WebElement> IDprofile = driver.findElements(By.id("item-3"));
        for (int i = 0; i < IDprofile.size(); i++) {
            if (IDprofile.get(i).getText().equalsIgnoreCase("Profile")) {
                IDprofile.get(i).click();
            }
            boolean notification = false;
            try {
                notificationNoBooks = driver.findElement(By.className("rt-noData"));
                notification = notificationNoBooks.isDisplayed();
            } catch (org.openqa.selenium.NoSuchElementException ex) {
                Assert.assertFalse(notification);
            }
        }
        int brojac = 0;
        List<WebElement> brojKnjiga = driver.findElements(By.className("rt-tr-group"));
        for (int i = 0; i < brojKnjiga.size(); i++) {
            System.out.println("===============");
            List<WebElement> brojKnjigaRow = brojKnjiga.get(i).findElements(By.className("rt-td"));
            System.out.println(brojKnjigaRow.size());
            for (int j = 0; j < brojKnjigaRow.size(); j++) {
                try {
                    WebElement thereIsImage = brojKnjigaRow.get(i).findElement(By.tagName("img"));
                    System.out.println(thereIsImage);
                    if (thereIsImage != null) {
                        brojac = brojac + 1;
                        break;
                    }
                }
                catch (org.openqa.selenium.NoSuchElementException ex) {
                }
            }
        }
        Assert.assertEquals(1, brojac);
        Thread.sleep(5000);
        brisanjeKnjiga();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        notificationNoBooks = driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(notificationNoBooks.isDisplayed());

    }


    @Test (priority = 20)
    public void dodavanjeDveKnjige() throws InterruptedException {
        callingAddingBook();
        js.executeScript("window.scrollBy(0,450)");
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,300)");
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
        try {
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for (int i = 0; i < addToCollectionButton.size(); i++) {
                if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                    addToCollectionButton.get(i).click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for (int i = 0; i < addToCollectionButton.size(); i++) {
                if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                    addToCollectionButton.get(i).click();
                }
            }
        }
        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
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
        Thread.sleep(2000);
        int brojac = 0;
        List<WebElement>brojKnjiga = driver.findElements(By.className("rt-tr-group"));
        for(int i = 0; i<brojKnjiga.size(); i++) {
            System.out.println("===============");
            List<WebElement> brojKnjigaRow = brojKnjiga.get(i).findElements(By.className("rt-td"));
            System.out.println(brojKnjigaRow.size());
            for (int j = 0; j < brojKnjigaRow.size(); j++) {
                try {
                    WebElement thereIsImage = brojKnjigaRow.get(j).findElement(By.tagName("img"));
                    System.out.println(thereIsImage);
                    if (thereIsImage != null) {
                        brojac = brojac + 1;
                        System.out.println(brojac);
                    }
                }
                catch (org.openqa.selenium.NoSuchElementException ex){

                }
            }
        }
        Assert.assertEquals(2, brojac);
        brisanjeKnjiga();
        notificationNoBooks = driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(notificationNoBooks.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

    }
    @Test (priority = 30)
    public void dodavanjeTriKnjige() throws InterruptedException {
        callingAdded2books();
        js.executeScript("window.scrollBy(0,5000)");
        wdwait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("gotoStore")))).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,300)");
        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action-buttons")));
        try {
            List<WebElement> knjiga3 = driver.findElements(By.cssSelector(".action-buttons"));
            for (int i = 0; i < knjiga3.size(); i++) {
                if (knjiga3.get(i).getText().equalsIgnoreCase("Designing Evolvable Web APIs with ASP.NET")) {
                    knjiga3.get(i).click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> knjiga3 = driver.findElements(By.cssSelector(".action-buttons"));
            for (int i = 0; i < knjiga3.size(); i++) {
                if (knjiga3.get(i).getText().equalsIgnoreCase("Designing Evolvable Web APIs with ASP.NET")){
                    knjiga3.get(i).click();
                }
            }
        }
        js.executeScript("window.scrollBy(0,450)");
        try {
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for (int i = 0; i < addToCollectionButton.size(); i++) {
                if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                    addToCollectionButton.get(i).click();
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            List<WebElement> addToCollectionButton = driver.findElements(By.id("addNewRecordButton"));
            for (int i = 0; i < addToCollectionButton.size(); i++) {
                if (addToCollectionButton.get(i).getText().equalsIgnoreCase("Add To Your Collection")) {
                    addToCollectionButton.get(i).click();
                }
            }
        }
        wdwait.until(ExpectedConditions.alertIsPresent());
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
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
        Thread.sleep(2000);
        int brojac = 0;
        List<WebElement>brojKnjiga = driver.findElements(By.className("rt-tr-group"));
        for(int i = 0; i<brojKnjiga.size(); i++) {
            System.out.println("===============");
            List<WebElement> brojKnjigaRow = brojKnjiga.get(i).findElements(By.className("rt-td"));
            System.out.println(brojKnjigaRow.size());
            for (int j = 0; j < brojKnjigaRow.size(); j++) {
                try {
                    WebElement thereIsImage = brojKnjigaRow.get(j).findElement(By.tagName("img"));
                    System.out.println(thereIsImage);
                    if (thereIsImage != null) {
                        brojac = brojac + 1;
                    }
                }
                catch (org.openqa.selenium.NoSuchElementException ex){

                }
            }
        }
        Assert.assertEquals(3, brojac);
        brisanjeKnjiga();
        notificationNoBooks = driver.findElement(By.className("rt-noData"));
        Assert.assertTrue(notificationNoBooks.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

    }
    @AfterMethod
    public void afterMethod(){
    driver.manage().deleteAllCookies();
   driver.navigate().refresh();
    }
}
