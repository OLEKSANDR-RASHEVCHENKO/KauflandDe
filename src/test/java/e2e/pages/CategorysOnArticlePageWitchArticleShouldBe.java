package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CategorysOnArticlePageWitchArticleShouldBe extends BasePage{

    public CategorysOnArticlePageWitchArticleShouldBe(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='rd-category-pages__headline']")
    WebElement header;
    public void waitForLoadingCategoryPage(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
    }
    public void selectOneFromCategoryPage(String category){
        List<WebElement> listOfCategory=driver.findElements(By.xpath("//*[@id='recommender-categories']//*[@class='rd-tile__title']"));
        for (int i = 0;i<listOfCategory.size();i++){
            String text = listOfCategory.get(i).getText();
            if (text.equals(category)){
                listOfCategory.get(i).click();
                break;
            }
        }
    }
    public void goBack(){
        driver.navigate().back();
    }
}
