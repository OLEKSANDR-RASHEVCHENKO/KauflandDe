package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ArticlePage extends BasePage{

    public ArticlePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='rd-title']")
    WebElement header;
    @FindBy(xpath = "//span[@class='rd-price-information__price']")
    WebElement price;
    @FindBy(xpath = "//button[@class='rd-add-to-cart__button rd-button rd-button--buy rd-button--icon']")
    WebElement clickOnInDenWarenkorbButton;
    @FindBy(xpath = "//span[normalize-space()='Zum Warenkorb']")
    WebElement zumWarenkorbButton;
    @FindBy(xpath = "//span[normalize-space()='Zur Kasse']")
    WebElement zurKasseButton;
    @FindBy(xpath = "//span[@class='rd-add-to-cart-overlay__close-icon svg-icon']//*[name()='svg']")
    WebElement closeWindow;
    public void waitForLoading(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(price);
        Assert.assertTrue(price.isDisplayed());
        getWait().forVisibility(clickOnInDenWarenkorbButton);
        Assert.assertTrue(clickOnInDenWarenkorbButton.isDisplayed());

    }
    public String getTitleOnProduct(){
        String title=header.getText();
        return title;
    }
    public String getPriceOnProduct(){
        String priceOnProduct = price.getText();
        return priceOnProduct;
    }
    public void clickOnInDenWarenkorbButton(){
        clickOnInDenWarenkorbButton.click();
    }
    public void waitForLoadingFrameWarenkorb(){
        getWait().forVisibility(zumWarenkorbButton);
        Assert.assertTrue(zumWarenkorbButton.isDisplayed());
        getWait().forVisibility(zurKasseButton);
        Assert.assertTrue(zurKasseButton.isDisplayed());
    }
    public void clickOnZumWarenkorb(){
        zumWarenkorbButton.click();
    }
    public void clickOnZurKasseButton(){
        zurKasseButton.click();
    }
    public void closeWindow(){
        getWait().forVisibility(closeWindow);
        getWait().forClickable(closeWindow);
        closeWindow.click();
    }
    public void goBack(){
        driver.navigate().back();
    }


}
