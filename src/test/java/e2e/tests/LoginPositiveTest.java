package e2e.tests;

import e2e.pages.AccountPage;
import e2e.pages.LoginPage;
import e2e.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPositiveTest extends BaseTest{
    StartPage startPage;
    LoginPage loginPage;
    AccountPage accountPage;

    @Test
    public void loginTest(){
        String email = "rashevchenkoo@gmail.com";
        String password = "Gazmanov1234";
        String anmeldenButtonBeforeLogin = "Anmelden";
        String anmeldenButtonAfterLogin = "OLEKSANDR";
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
        startPage.clickOnAccountButton();
        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoadingAccountPage();
        accountPage.clickOnAnmeldenButton();
        startPage.waitForLoadingStartPage();
        String actualNameOnAnmeldenButton=startPage.getTextFromAnmeldenButton();
        Assert.assertEquals(actualNameOnAnmeldenButton,anmeldenButtonBeforeLogin);
    }
}
