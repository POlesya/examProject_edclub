package org.loginTest.profileTest;

import org.baseTest.BaseTest;
import org.junit.Test;

import static org.data.TestData.VALID_LOGIN_UI;
import static org.data.TestData.VALID_PASSWORD_UI;

public class MyProfileUpdateTest extends BaseTest {

    @Test
    public void testMyProfileUpdate() {
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

        pageProvider.getHeader().openUserDropdown();
        pageProvider.getHeader().clickOnProfileInDropdown();
        pageProvider.getMyProfilePage().checkIsRedirectedToProfilePage();

        org.junit.Assert.assertEquals("Username is incorrect", "polesia",
                pageProvider.getMyProfilePage().getUsernameValue());
        org.junit.Assert.assertEquals("Email is incorrect", "olesya.pilip@gmail.com",
                pageProvider.getMyProfilePage().getEmailValue());
        org.junit.Assert.assertEquals("First name is incorrect", "Olesia",
                pageProvider.getMyProfilePage().getFirstNameValue());
        org.junit.Assert.assertEquals("Last name is incorrect", "Pylyp",
                pageProvider.getMyProfilePage().getLastNameValue());
        org.junit.Assert.assertEquals("Time zone is incorrect", "US/Eastern",
                pageProvider.getMyProfilePage().getTimezoneSelectedValue());

        pageProvider.getMyProfilePage().updateProfileGoals();

        pageProvider.getMyProfilePage().checkSuccessBannerVisible();
    }
}