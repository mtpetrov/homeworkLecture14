package homeworkSkilloButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class skilloButton {
    private WebDriver driver;

    @BeforeSuite
    public final void beforeSuite() {
        WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public final void buildUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterMethod
    public final void tearDown() {
        driver.close();
    }

    @Test
    public void skilloButtonClickFromLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement skilloButton = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        skilloButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));

    }

    @Test
    public void skilloButtonClickFromRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement skilloButton = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Register']"));
        registerButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/register"));
        Assert.assertTrue(skilloButton.isDisplayed());
        skilloButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
        Assert.assertTrue(skilloButton.isDisplayed());
    }

    @Test
    public void skilloButtonClickFromProfile() {
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.get("http://training.skillo-bg.com:4300/posts/all");
            WebElement skilloButton = driver.findElement(By.id("homeIcon"));
            Assert.assertTrue(skilloButton.isDisplayed());
            WebElement loginButton = driver.findElement(By.id("nav-link-login"));
            loginButton.click();
            wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
            Assert.assertTrue(skilloButton.isDisplayed());
            WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
            username.sendKeys("genadigenadi");
            WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
            password.sendKeys("genadi");
            WebElement signInButton = driver.findElement(By.id("sign-in-button"));
            wait.until(ExpectedConditions.elementToBeClickable(signInButton));
            signInButton.click();
            Assert.assertTrue(skilloButton.isDisplayed());
            
            WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-profile")));
            profileButton.click();

            wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users"));
            Assert.assertTrue(skilloButton.isDisplayed());

            skilloButton.click();
            wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
            Assert.assertTrue(skilloButton.isDisplayed());
        }

    }

    @Test
    public void skilloButtonClickFromNewPost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("http://training.skillo-bg.com:4300/posts/all");
        WebElement skilloButton = driver.findElement(By.id("homeIcon"));
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement loginButton = driver.findElement(By.id("nav-link-login"));
        loginButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login"));
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement username = driver.findElement(By.id("defaultLoginFormUsername"));
        username.sendKeys("genadigenadi");
        WebElement password = driver.findElement(By.id("defaultLoginFormPassword"));
        password.sendKeys("genadi");
        WebElement signInButton = driver.findElement(By.id("sign-in-button"));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        Assert.assertTrue(skilloButton.isDisplayed());
        WebElement newPost = driver.findElement(By.id("nav-link-new-post"));
        newPost.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/create"));
        Assert.assertTrue(skilloButton.isDisplayed());
        skilloButton.click();
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/all"));
        Assert.assertTrue(skilloButton.isDisplayed());

    }
}



