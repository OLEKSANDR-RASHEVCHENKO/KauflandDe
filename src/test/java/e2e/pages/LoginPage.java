package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='rd-page-header']")
    WebElement headerOnLoginPage;
    @FindBy(xpath = "//*[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//*[@data-test-id='login-continue-button']")
    WebElement fortfarenButton;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//*[@data-test-id='login-forgot-password']")
    WebElement passwordVergessen;
    @FindBy(xpath = "//*[@data-test-id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@data-test-id='login-alternative-logins']")
    WebElement loginAlternative;

public void waitForLoadingLoginPage(){
    getWait().forVisibility(headerOnLoginPage);
    Assert.assertTrue(headerOnLoginPage.isDisplayed());
    getWait().forVisibility(emailField);
    Assert.assertTrue(emailField.isDisplayed());
    getWait().forVisibility(fortfarenButton);
    Assert.assertTrue(fortfarenButton.isDisplayed());
    getWait().forVisibility(loginAlternative);
    Assert.assertTrue(loginAlternative.isDisplayed());
}
public void waitForPasswordField(){
    getWait().forVisibility(passwordField);
    Assert.assertTrue(passwordField.isDisplayed());
    getWait().forVisibility(loginButton);
    Assert.assertTrue(loginButton.isDisplayed());
}
public void getUrl(String expectedUrl){
    String actualUrl=getCurrerntUrl();
    Assert.assertEquals(actualUrl,expectedUrl);
}
public void setEmailField(String email){
    emailField.sendKeys(email);
    fortfarenButton.click();
}
public void setPasswordField(String password){
    passwordField.sendKeys(password);
    loginButton.click();
}


}
