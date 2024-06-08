package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='result-header']//*[@class='title']")
    WebElement header;
    @FindBy(xpath = "//div[@class='rd-cart-widget__button rd-cart-widget__button--desktop rd-cart-widget__button--hasProducts']")
    WebElement warenkorb;

    public void clickOnOneFromArticle(int index){
        List<WebElement> listOfArticle = driver.findElements(By.xpath("//*[@class='results results--list']//article"));
        WebElement articleToBeSelect=listOfArticle.get(index);
        articleToBeSelect.click();
    }

    public void navigateToPage(int pageIndex) throws InterruptedException {
        boolean pageVisible = false;
        while (!pageVisible) {
            try {
                WebElement pageButton = driver.findElement(By.xpath("//button[normalize-space()='"+pageIndex+"']"));
                System.out.println("NumberOfPAge"+pageButton.getText());
                pageButton.click();
                if (pageButton.isDisplayed()) {
                    pageVisible = true;
                }
            } catch (Exception e) {
                List<WebElement> visiblePages = driver.findElements(By.xpath("//*[@class='rd-pagination']//button"));
                if (visiblePages.size() > 2) {
                    WebElement secondLastVisiblePageButton = visiblePages.get(visiblePages.size() - 3);
                    secondLastVisiblePageButton.click();
                    Thread.sleep(2000);
                } else {
                    System.out.println("Не удалось найти предпоследнюю видимую кнопку.");
                    break;
                }
            }
        }
    }


    public void waitForLoadingCategoryPage(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }
    public void selectFilterOnCategoryPage(String filter){
        List<WebElement> listOfFilters=driver.findElements(By.xpath("//*[@class='filters main-content__filters--desktop']//*[@class='filter__list']//*[@class='filter__list-item']"));
        for (int i = 0;i<listOfFilters.size();i++){
            String text = listOfFilters.get(i).getText();
            System.out.println(text);
            if (text.equals(filter)){
                listOfFilters.get(i).click();
                break;
            }
        }
    }
    public void hoverOverToOnTheCategory(String filter) {
        List<WebElement> listOfFilters = driver.findElements(By.xpath("//*[@class='filters main-content__filters--desktop']//*[@class='filter__list']//*[@class='filter__list-item']"));
        for (int i = 0; i < listOfFilters.size(); i++) {
            String text = listOfFilters.get(i).getText();
            System.out.println(text);
            if (text.equals(filter)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(listOfFilters.get(i)).click().perform();
                break;
            }
        }
    }

    public void sortierenNachDropDown(String sortCategory){
        driver.findElement(By.xpath("//*[@class='rd-select']")).click();
        List<WebElement> listOfSotr=driver.findElements(By.xpath("//*[@class='rd-select']//option"));
        for (int i = 0;i<listOfSotr.size();i++){
            String sotr = listOfSotr.get(i).getText();
            if (sotr.equals(sortCategory)){
                listOfSotr.get(i).click();
                break;
            }
        }

    }


    public String getTextFromTitle(){
        String textFromTitle=header.getText();
        return textFromTitle;
    }
    public void clickOnWarenkorb(){
        warenkorb.click();
    }
    public void goBack(){
        driver.navigate().back();
    }

}
