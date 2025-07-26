package org.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.pages.elements.HeaderForLoggedUserElement;

public class HomePage extends ParentPage {

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/sportal";
    }

    public void verifyRedirectionToHome(String expectedUserName) {
        webDriverWait10.until(ExpectedConditions.urlContains("/sportal"));

        String currentUrl = webDriver.getCurrentUrl();
        if (!currentUrl.contains("/sportal")) {
            Assert.fail("User is not on Home page. Actual URL: " + currentUrl);
        }

        new HeaderForLoggedUserElement(webDriver).checkUserDropdownIsVisibleWithName(expectedUserName);
    }
}