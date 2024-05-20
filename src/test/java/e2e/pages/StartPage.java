package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StartPage extends BasePage{
    public StartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='rh-main']")
    WebElement headerOnStartPage;

    @FindBy(xpath = "//*[contains(text(), 'Anmelden')]")
    WebElement anmeldenButton;
    @FindBy(xpath = "//*[@class='rd-aw-login__text rd-aw-login__text--logged-in']")
    WebElement accountButton;
    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookies;

    public void waitForLoadingStartPage(){
        getWait().forVisibility(headerOnStartPage);
        Assert.assertTrue(headerOnStartPage.isDisplayed());
        getWait().forVisibility(anmeldenButton);
        Assert.assertTrue(anmeldenButton.isDisplayed());
        getWait().forClickable(anmeldenButton);
    }
    public void clickOnAnmeldenButton(){
        anmeldenButton.click();
    }
    public String getNameFromStartPage(){
        getWait().forVisibility(accountButton);
        Assert.assertTrue(accountButton.isDisplayed());
        String actualName=accountButton.getText();
        return actualName;
    }
    public String getTextFromAnmeldenButton(){
        String actualName=anmeldenButton.getText();
        return actualName;
    }

    public void clickOnAccountButton(){
        accountButton.click();
    }
    public void cookiesZustimmen(){
        cookies.click();
    }

}
