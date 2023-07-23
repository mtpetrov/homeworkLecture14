package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class herokuappHomework {
    private WebDriver driver;

    @BeforeSuite
    public final void setUpSuite(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    public final void buildUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public final void tearDown(){
        //driver.close();
    }

    @Test
    public void addRemoveElements(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElement = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();
        WebElement removeElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='elements']/button")));
        removeElement.click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='elements']/button"), "Delete"));
    }
    @Test
    public void basicAuth(){
        String username = "admin";
        String password = "admin";
        driver.get("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        String expectedResults = "Congratulations! You must have the proper credentials.";
        String verifyResults = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(verifyResults, expectedResults);

    }

   @Test
    public void checkboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[1]"));
       WebElement checkbox2 = driver.findElement(By.xpath("//*[@id='checkboxes']/input[2]"));
        if(checkbox2.isSelected()){
            checkbox2.click();
        } else if (checkbox1.isSelected()) {
            checkbox1.click();
        }
       checkbox1.click();
       checkbox2.click();
       Assert.assertTrue(checkbox1.isSelected() && checkbox2.isSelected());

   }
   @Test
    public void contextMenu(){
       Actions actions = new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement contextField = driver.findElement(By.id("hot-spot"));
        actions.contextClick(contextField).perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
   }

   @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
WebElement optionsSelect = driver.findElement(By.id("dropdown"));
optionsSelect.click();
WebElement option1 = driver.findElement(By.xpath("//option[text()='Option 1']"));
//option1.click();
WebElement option2 = driver.findElement(By.xpath("//option[text()='Option 2']"));
option2.click();
   }

   @Test
    public void hover(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
       Actions actions = new Actions(driver);

WebElement image1= driver.findElement(By.xpath("//div[1]/img"));
actions.moveToElement(image1).perform();

WebElement firstImageViewProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/users/1']")));
Assert.assertTrue(firstImageViewProfile.isDisplayed());

WebElement image2 = driver.findElement(By.xpath("//div[2]/img"));
actions.moveToElement(image2).perform();

WebElement secondImageViewProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/users/2']")));
Assert.assertTrue(secondImageViewProfile.isDisplayed());

WebElement image3 = driver.findElement(By.xpath("//div[3]/img"));
actions.moveToElement(image3).perform();

WebElement thirdImageViewProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/users/3']")));
Assert.assertTrue(thirdImageViewProfile.isDisplayed());
   }

   @Test
    public void multipleWindows(){
        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        clickHere.click();
       Set<String> windows = driver.getWindowHandles();
Iterator<String> iterator = windows.iterator();
String parentWindow = iterator.next();
String childWindow = iterator.next();
       WebElement newWindow = driver.findElement(By.cssSelector(".example"));
       Assert.assertTrue(newWindow.isDisplayed());
       driver.switchTo().window(parentWindow);
       driver.switchTo().window(childWindow);
   }
}
