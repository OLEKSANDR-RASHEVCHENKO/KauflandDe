package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

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

    @FindBy(xpath = "//*[@class='rh-menu-toggle__burger']")
    WebElement alleKategorienButton;

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
    public void selectOneMenuFromDropDown(String menu){
        alleKategorienButton.click();
        List<WebElement> dropMenu=driver.findElements(By.xpath("//*[@class='rh-menu__top-tile']//*[@class='rh-menu-tile']//span[text()]"));
        System.out.println(dropMenu.size());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        for (int i=0;i<dropMenu.size();i++){
            String text = dropMenu.get(i).getText();
            if (text.equals(menu)){
                dropMenu.get(i).click();
                break;
            }
        }
    }
    public void selectSecondDropDownMenu(){
        driver.findElement(By.xpath("//*[@class='rh-menu-overlay__category']")).click();
    }

}
