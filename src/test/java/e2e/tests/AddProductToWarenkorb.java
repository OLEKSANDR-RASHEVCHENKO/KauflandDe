package e2e.tests;

import e2e.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToWarenkorb extends BaseTest{
    StartPage startPage;
    LoginPage loginPage;
    CategorysOnArticlePageWitchArticleShouldBe categorysOnArticlePageWitchArticleShouldBe;
    CategoryPage categoryPage;
    ArticlePage articlePage;
    MeinarenkorbPage meinarenkorbPage;
    @Test
    public void addProductToWarenkorb () throws InterruptedException {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String anmeldenButtonAfterLogin = "OLEKSANDR";
        String electronik = "Elektronik & Computer";
        String phone = "Handys";

        startPage = new StartPage(app.driver);
        startPage.waitForLoadingStartPage();
        startPage.cookiesZustimmen();
        startPage.clickOnAnmeldenButton();
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailField(email);
        loginPage.waitForPasswordField();
        loginPage.setPasswordField(password);
        String actualName = startPage.getNameFromStartPage();
        Assert.assertEquals(actualName, anmeldenButtonAfterLogin);
        startPage.selectOneMenuFromDropDown(electronik);
        startPage.selectSecondDropDownMenu();
        categorysOnArticlePageWitchArticleShouldBe = new CategorysOnArticlePageWitchArticleShouldBe(app.driver);
        categorysOnArticlePageWitchArticleShouldBe.waitForLoadingCategoryPage();
        categorysOnArticlePageWitchArticleShouldBe.selectOneFromCategoryPage(phone);
        categoryPage = new CategoryPage(app.driver);
        categoryPage.waitForLoadingCategoryPage();
        categoryPage.clickOnOneFromArticle(1);
        articlePage = new ArticlePage(app.driver);
        articlePage.waitForLoading();
        String nameOfArticleActualOne = articlePage.getTitleOnProduct();
        articlePage.clickOnInDenWarenkorbButton();
        articlePage.closeWindow();
        articlePage.goBack();
        categoryPage.waitForLoadingCategoryPage();
        categoryPage.clickOnOneFromArticle(6);
        articlePage = new ArticlePage(app.driver);
        articlePage.waitForLoading();
        String nameOfArticleActualTwo = articlePage.getTitleOnProduct();
        articlePage.clickOnInDenWarenkorbButton();
        articlePage.closeWindow();
        articlePage.goBack();
        categoryPage.clickOnWarenkorb();
        meinarenkorbPage = new MeinarenkorbPage(app.driver);
        meinarenkorbPage.waitForLoadingMeinWarenkorbPage();
        String  nameInWarenkorbOne=meinarenkorbPage.getTitleFromMeinWarenkorbPage(1);
        String  nameInWarenkorbTwo=meinarenkorbPage.getTitleFromMeinWarenkorbPage(2);
        Assert.assertEquals(nameOfArticleActualOne,nameInWarenkorbOne);
        Assert.assertEquals(nameOfArticleActualTwo,nameInWarenkorbTwo);
        meinarenkorbPage.removeItemFromKorb();
        meinarenkorbPage.itemIsLeerText();


    }
}
