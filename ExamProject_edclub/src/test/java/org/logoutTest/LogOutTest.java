package org.logoutTest;

import org.apache.log4j.Logger;
import org.baseTest.BaseTest;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.data.TestData.VALID_LOGIN_UI;
import static org.data.TestData.VALID_PASSWORD_UI;

public class LogOutTest extends BaseTest {
    final Logger logger = Logger.getLogger(getClass());

    @Test
    public void userCanLogoutSuccessfully() throws InterruptedException {
        pageProvider.getMainPage()
                .openMainPage()
                .acceptCookiesIfPresent()
                .clickOnLoginButton()
                .checkLoginPopupVisibleAndOptions()
                .clickOnIndividualEditionButton();

        pageProvider.getLoginPage()
                .checkLoginFormTitleIsVisible()
                .enterUsername(VALID_LOGIN_UI)
                .enterPassword(VALID_PASSWORD_UI)
                .clickLogInButton();

        pageProvider.getHomePage().verifyRedirectionToHome("Olesia");
        logger.info("User is logged in successfully");

        pageProvider.getHeader().openUserDropdown();
        logger.info("User dropdown is opened");

        pageProvider.getHeader().clickLogout();
        logger.info("Logout button is clicked");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.edclub.com/"));
        logger.info("User is redirected to main page");

        pageProvider.getMainPage().checkIsButtonLoginVisible();
        logger.info("Verified: 'Log in' button is visible in the header");

    }
}