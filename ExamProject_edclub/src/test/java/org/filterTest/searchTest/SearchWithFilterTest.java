package org.filterTest.searchTest;

import org.apache.log4j.Logger;
import org.baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import static org.data.TestData.VALID_LOGIN_UI;
import static org.data.TestData.VALID_PASSWORD_UI;

public class SearchWithFilterTest extends BaseTest {
    final Logger logger = Logger.getLogger(getClass());

    @Test
    public void searchReadingCourseTest() throws InterruptedException {

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
        logger.info("Navigated to Library page");

        pageProvider.getLibraryPage().applyReadingFilter();
        Thread.sleep(2000);
        logger.info("Applied filter: Reading");

        String courseName = "Letters & Sight Words";
        pageProvider.getLibraryPage().searchForCourse(courseName);
        Thread.sleep(2000);
        logger.info("Searched for course: " + courseName);

        String currentUrl = webDriver.getCurrentUrl();
        logger.info("Current URL after search: " + currentUrl);
        Assert.assertTrue("URL does not contain search query",
                currentUrl.contains("search=Letters+%26+Sight+Words"));
        logger.info("Verified URL contains search parameter");

        pageProvider.getLibraryPage().checkSearchResultVisible();
        logger.info("Verified that course card '" + courseName + "' is visible");
    }
}