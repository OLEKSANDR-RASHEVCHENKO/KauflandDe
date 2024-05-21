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
    WebElement abmeldenButton;
    public void waitForLoadingAccountPage(){
        getWait().forVisibility(abmeldenButton);
        Assert.assertTrue(abmeldenButton.isDisplayed());
    }

    public void clickOnAnmeldenButton(){
        abmeldenButton.click();
    }
}
