package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }
    @FindBy(xpath = ".//button[contains(., 'Accept all cookies')]")
    private WebElement buttonAcceptCookies;

    @FindBy(xpath = ".//a[@href='/signin']")
    private WebElement buttonLogin;

    @FindBy(xpath = ".//div[contains(@class, 'edmodal-box') and contains(@class, 'auth-modal')]")
    private WebElement loginPopupContainer;

    @FindBy(xpath = ".//a[@name='signin' and @href='/signin' and contains(@class, 'modal-btn')]")
    private WebElement buttonIndividualEdition;

    @FindBy(xpath = "//a[@href='/library' and text()='Library']")
    private WebElement buttonLibrary;

    public MainPage openMainPage() {
        openPage();
        return this;
    }

    public MainPage acceptCookiesIfPresent() {
        try {
            if (isElementDisplayed(buttonAcceptCookies)) {
                click(buttonAcceptCookies);
            }
        } catch (Exception e) {

        }
        return this;
    }

    public MainPage clickOnLoginButton() {
        click(buttonLogin);
        return this;
    }

    public MainPage checkLoginPopupVisibleAndOptions() {
        checkIsElementDisplayed(loginPopupContainer);
        return this;
    }

    public MainPage clickOnIndividualEditionButton() {
        click(buttonIndividualEdition);
        return this;
    }

    public void checkIsButtonLoginVisible() {
        checkIsElementDisplayed(buttonLogin);
    }
    public void checkButtonLoginIsNotVisible() {
        checkIsElementNotDisplayed(buttonLogin);
    }
    public LibraryPage clickOnLibraryButton() {
        click(buttonLibrary);
        return new LibraryPage(webDriver);
    }

    public MainPage checkCurrentUrl() {
        super.checkCurrentUrl(getRelativeUrl());
        return this;
    }
}