package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MeinarenkorbPage extends BasePage{
    public MeinarenkorbPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[normalize-space()='Mein Warenkorb']")
    WebElement header;
    @FindBy(css = "div[class='unit-widget-list'] h3 span[class='rd-link__text']")
    WebElement titleFromProduct;
    @FindBy(css = "div[class='payment-overview-costs__invoice-item payment-overview-costs__shipping-costs'] span[class='payment-overview-costs__invoice-item-value']")
    WebElement versandKosten;
    @FindBy(css = "div[class='payment-overview-costs__invoice-item payment-overview-costs__final-price'] span[class='payment-overview-costs__invoice-item-value']")
    WebElement gesamtSumme;
    @FindBy(xpath = "//span[normalize-space()='Jetzt zur Kasse gehen']")
    WebElement jetztZurKasseGehenButton;
    @FindBy(xpath = "//span[normalize-space()='Weiter einkaufen']")
    WebElement weiterEinkaufenButton;

    public void waitForLoadingMeinWarenkorbPage(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(titleFromProduct);
        Assert.assertTrue(titleFromProduct.isDisplayed());
        getWait().forVisibility(versandKosten);
        Assert.assertTrue(versandKosten.isDisplayed());
        getWait().forVisibility(gesamtSumme);
        Assert.assertTrue(gesamtSumme.isDisplayed());
        getWait().forVisibility(jetztZurKasseGehenButton);
        Assert.assertTrue(jetztZurKasseGehenButton.isDisplayed());
        getWait().forVisibility(weiterEinkaufenButton);
        Assert.assertTrue(weiterEinkaufenButton.isDisplayed());
    }
    public String getTitleFromMeinWarenkorbPage(){
        String titleFromWarenKorb=titleFromProduct.getText();
        return titleFromWarenKorb;
    }
    public String getVersandPrice(){
        String versand = versandKosten.getText();
        return  versand;
    }
    public String getGesamtPrice(){
        String gesamtPrice = gesamtSumme.getText();
        return  gesamtPrice;
    }
    public void clickOnjetztZurKasseGehenButton(){
        jetztZurKasseGehenButton.click();
    }
    public void clickOnweiterEinkaufenButton(){
        weiterEinkaufenButton.click();
    }




}
