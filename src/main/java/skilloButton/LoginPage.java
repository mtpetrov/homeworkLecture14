package skilloButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = ".h4")
    private WebElement signInText;

    @FindBy(id = "defaultLoginFormUsername")
    private WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "sign-in-button")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@href='/users/register']")
    private WebElement registerButton;

    public LoginPage(WebDriver driver) {
        this.driver =  driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public String getSignInElementText(){
        WebElement signInFormTitle = driver.findElement(By.xpath("//p[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOf(signInFormTitle));
        return signInFormTitle.getText();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
    public void populateUsername(String user){
        usernameField.sendKeys(user);
    }

    public void populatePassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickSignIn(){
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

}
