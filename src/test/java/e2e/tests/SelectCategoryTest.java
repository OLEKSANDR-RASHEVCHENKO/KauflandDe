package e2e.tests;

import e2e.pages.AccountPage;
import e2e.pages.CategoryPage;
import e2e.pages.LoginPage;
import e2e.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectCategoryTest extends BaseTest{
    StartPage startPage;
    LoginPage loginPage;
    CategoryPage categoryPage;
    @Test
    public void userCanSelectOnCategory(){
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String anmeldenButtonAfterLogin = "OLEKSANDR";
        String electronik = "Elektronik & Computer";
        String phone="Handys";
        String spielkonsole="Spielkonsolen";
        startPage = new StartPage(app.driver);
        startPage.waitForLoadingStartPage();
        startPage.cookiesZustimmen();
        startPage.clickOnAnmeldenButton();
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setEmailField(email);
        loginPage.waitForPasswordField();
        loginPage.setPasswordField(password);
        String actualName=startPage.getNameFromStartPage();
        Assert.assertEquals(actualName,anmeldenButtonAfterLogin);
        startPage.selectOneMenuFromDropDown(electronik);
        startPage.selectSecondDropDownMenu();
        categoryPage = new CategoryPage(app.driver);
        categoryPage.waitForLoadingCategoryPage();
        categoryPage.selectOneFromCategoryPage(spielkonsole);
        categoryPage.goBack();
        categoryPage.selectOneFromCategoryPage(phone);
    }
}
