package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CategoryPage extends BasePage{

    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='result-header']//*[@class='title']")
    WebElement header;


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
    public void goBack(){
        driver.navigate().back();
    }

}
