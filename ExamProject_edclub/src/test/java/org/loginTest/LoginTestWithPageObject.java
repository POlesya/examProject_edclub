package org.loginTest;

import org.baseTest.BaseTest;
import org.junit.Test;

import static org.data.TestData.VALID_LOGIN_UI;
import static org.data.TestData.VALID_PASSWORD_UI;

public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLogin() {
        pageProvider.getMainPage()
                .acceptCookiesIfPresent()
                .clickOnLoginButton()
                .checkLoginPopupVisibleAndOptions()
                .clickOnIndividualEditionButton();

        pageProvider.getLoginPage()
                .checkLoginFormTitleIsVisible()
                .enterUsername(VALID_LOGIN_UI)
                .enterPassword(VALID_PASSWORD_UI)
                .clickLogInButton();

        pageProvider.getHomePage()
                .verifyRedirectionToHome("Olesia");

        pageProvider.getMainPage()
                .checkButtonLoginIsNotVisible();
    }
}