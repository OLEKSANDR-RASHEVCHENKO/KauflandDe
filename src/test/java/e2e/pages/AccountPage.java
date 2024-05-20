package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AccountPage extends BasePage{
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='navigation-logout']")
    WebElement anmeldenButton;
    public void waitForLoadingAccountPage(){
        getWait().forVisibility(anmeldenButton);
        Assert.assertTrue(anmeldenButton.isDisplayed());
    }

    public void clickOnAnmeldenButton(){
        anmeldenButton.click();
    }
}
