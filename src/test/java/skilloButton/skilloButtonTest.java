package skilloButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;

public class skilloButtonTest {
    private WebDriver driver;

    @BeforeSuite
    public final void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
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
        //driver.close();
    }

    @DataProvider(name = "generateLoginCredentials")
    public Object[][] generateLoginCredentials() {
       return new Object[][]{
               {"genadigenadi", "genadi"},
       };
    }

    @Test
    public void verifySkilloButtonVisibilityHomepage(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        Header header = new Header(driver);
        Assert.assertTrue(header.isSkilloLogoDisplayed(), "The Skillo logo is not displayed on the Homepage");
    }

    @Test
    public void verifySkilloButtonVisibilityLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();
        Header header = new Header(driver);
        header.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Assert.assertTrue(wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/users/login")));
        Assert.assertTrue(header.isSkilloLogoDisplayed());
    }
    @Test
    public void verifySkilloButtonVisibilityRegister(){
HomePage homePage = new HomePage(driver);
homePage.navigateTo();
Header header = new Header(driver);
header.clickLoginButton();
LoginPage loginPage = new LoginPage(driver);
loginPage.clickRegisterButton();
Assert.assertTrue(header.isSkilloLogoDisplayed());
    }

@Test(dataProvider = "generateLoginCredentials")
    public void verifySkilloButtonLoggedIn(String user, String password){
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        Assert.assertTrue(header.isSkilloLogoDisplayed());

}
@Test(dataProvider = "generateLoginCredentials")
public void verifySkilloButtonProfile(String user, String password){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        HomePage homePage = new HomePage(driver);
        homePage.navigateTo();

        Header header = new Header(driver);
        header.clickLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateUsername(user);
        loginPage.populatePassword(password);
        loginPage.clickSignIn();

        header.clickProfileButton();
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("http://training.skillo-bg.com:4300/users")));
        Assert.assertTrue(header.isSkilloLogoDisplayed());
}

 @Test(dataProvider = "generateLoginCredentials")
    public void verifySkilloButtonNewPost(String user, String password){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     HomePage homePage = new HomePage(driver);
     homePage.navigateTo();

     Header header = new Header(driver);
     header.clickLoginButton();

     LoginPage loginPage = new LoginPage(driver);
     loginPage.populateUsername(user);
     loginPage.populatePassword(password);
     loginPage.clickSignIn();

     header.clickNewPostButton();
     Assert.assertTrue(wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4300/posts/create")));
     Assert.assertTrue(header.isSkilloLogoDisplayed());
 }

 @Test(dataProvider = "generateLoginCredentials")
    public void verifySkilloButtonLogout(String user, String password){
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     HomePage homePage = new HomePage(driver);
     homePage.navigateTo();

     Header header = new Header(driver);
     header.clickLoginButton();

     LoginPage loginPage = new LoginPage(driver);
     loginPage.populateUsername(user);
     loginPage.populatePassword(password);
     loginPage.clickSignIn();

     header.logoutClick();
     Assert.assertTrue(header.isSkilloLogoDisplayed());
    }

}
