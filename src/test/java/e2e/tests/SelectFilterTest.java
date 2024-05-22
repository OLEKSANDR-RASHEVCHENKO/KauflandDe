package e2e.tests;

import e2e.pages.CategoryPage;
import e2e.pages.CategorysPage;
import e2e.pages.LoginPage;
import e2e.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectFilterTest extends BaseTest {
    StartPage startPage;
    LoginPage loginPage;
    CategorysPage categorysPage;
    CategoryPage categoryPage;

    @Test
    public void userCanSelectByFilters() throws InterruptedException {
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String anmeldenButtonAfterLogin = "OLEKSANDR";
        String electronik = "Elektronik & Computer";
        String phone = "Handys";
        String color = "Weiß";
        String smartwatches = "Smartwatches";
        String höchsterPreis = "Höchster Preis";

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
        categorysPage = new CategorysPage(app.driver);
        categorysPage.waitForLoadingCategoryPage();
        categorysPage.selectOneFromCategoryPage(phone);
        categoryPage = new CategoryPage(app.driver);
        categoryPage.waitForLoadingCategoryPage();
        categoryPage.selectFilterOnCategoryPage(color);
        categoryPage.waitForLoadingCategoryPage();
        Thread.sleep(5000);
        categoryPage.goBack();
        categoryPage.waitForLoadingCategoryPage();
        categoryPage.selectFilterOnCategoryPage(smartwatches);
        categoryPage.waitForLoadingCategoryPage();
        Thread.sleep(5000);
        String titleSmartwatches = categoryPage.getTextFromTitle();
        Assert.assertEquals(titleSmartwatches, smartwatches);
        categoryPage.sortierenNachDropDown(höchsterPreis);
        Thread.sleep(5000);

    }
}
