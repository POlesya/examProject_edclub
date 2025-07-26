package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath =".//div[contains(@class, 'card')]//h1[text()='Log in']")
    private WebElement loginFormTitle;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement inputUsername;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@type='submit' and contains(@value, 'Log in')]")
    private WebElement buttonLogIn;

    @Override
    protected String getRelativeUrl() {
        return "/signin";
    }

    public LoginPage checkLoginFormTitleIsVisible() {
        checkIsElementDisplayed(loginFormTitle);
        return this;
    }

    public LoginPage enterUsername(String username) {
        clearAndEnterTextToElement(inputUsername, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clearAndEnterTextToElement(inputPassword, password);
        return this;
    }

    public void clickLogInButton() {
        click(buttonLogIn);
    }
}