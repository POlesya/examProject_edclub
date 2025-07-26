package org.filterTest;

import org.baseTest.BaseTest;
import org.junit.Test;
import org.apache.log4j.Logger;

import static org.data.TestData.VALID_LOGIN_UI;
import static org.data.TestData.VALID_PASSWORD_UI;
import static org.junit.Assert.assertEquals;

public class FilterByLibraryTest extends BaseTest {
    final Logger logger = Logger.getLogger(getClass());

    @Test
    public void applyReadingFilter() throws InterruptedException {
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

        pageProvider.getHomePage().verifyRedirectionToHome("Olesia");

        pageProvider.getMainPage()
                .openMainPage()
                .acceptCookiesIfPresent()
                .clickOnLibraryButton();

        Thread.sleep(2000);

        String actualLibraryUrl = webDriver.getCurrentUrl();
        assertEquals("https://www.edclub.com/library", actualLibraryUrl);
        logger.info("Redirected to Library page: " + actualLibraryUrl);

        pageProvider.getLibraryPage().applyReadingFilter();

        Thread.sleep(2000);

        String expectedFilteredUrl = "https://www.edclub.com/library?page=1&ordering=learners_count&locale=en_US&limit=12&subject__in=5";
        String actualFilteredUrl = webDriver.getCurrentUrl();
        assertEquals("Filtered URL should match", expectedFilteredUrl, actualFilteredUrl);

        Thread.sleep(2000);

        logger.info("Filter 'Reading' applied successfully: " + actualFilteredUrl);
    }
}