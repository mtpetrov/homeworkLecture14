package skilloButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver driver;
    private final WebDriverWait wait;
    @FindBy(id="homeIcon")
    private WebElement skilloLogo;
@FindBy(id="nav-link-login")
    private WebElement loginButton;
@FindBy(id="nav-link-home")
private WebElement homeButton;

@FindBy(id = "nav-link-profile")
private WebElement profileButton;

@FindBy(id = "nav-link-new-post")
private WebElement newPostButton;

@FindBy(id = "search-bar")
private WebElement searchBarField;

@FindBy(tagName = "i")
private WebElement logoutButton;
    public Header(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);

    }
    public boolean isSkilloLogoDisplayed(){
        return skilloLogo.isDisplayed();
    }
    public void clickSkilloLogo(){
        skilloLogo.click();
    }
 public void clickLoginButton(){
        loginButton.click();
 }
 public void clickHomeButton(){
        homeButton.click();
 }

 public void clickProfileButton(){
        profileButton.click();
 }
 public void clickNewPostButton(){
        newPostButton.click();
 }
 public void logoutClick(){
        logoutButton.click();
 }
}
