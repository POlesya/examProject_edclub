package org.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.apache.log4j.Logger;

public class MyProfilePage extends ParentPage {
    private final Logger logger = Logger.getLogger(getClass());
    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/sportal/profile";
    }

    public void checkIsRedirectedToProfilePage() {
        webDriverWait10.until(ExpectedConditions.urlContains("/sportal/profile"));
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertTrue("User is not on My Profile page. Actual URL: " + currentUrl,
                currentUrl.contains("/sportal/profile"));
    }

    @FindBy(xpath = ".//input[@id='username']")
    private WebElement inputUsername;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement inputEmail;

    @FindBy(xpath = ".//input[@id='fname']")
    private WebElement inputFirstName;

    @FindBy(xpath = ".//input[@id='lname']")
    private WebElement inputLastName;

    @FindBy(xpath = ".//select[@id='timezone']")
    private WebElement selectTimezone;

    @FindBy(xpath = ".//select[@id='typing_goal_daily']")
    private WebElement selectDailyGoal;

    @FindBy(xpath = ".//select[@id='typing_goal_weekly']")
    private WebElement selectWeeklyGoal;

    @FindBy(xpath = ".//select[@id='weekday_start']")
    private WebElement selectFirstDayOfWeek;

    @FindBy(xpath = ".//button[@type='submit' and contains(text(),'Save Changes')]")
    private WebElement buttonSaveChanges;

    @FindBy(xpath = ".//div[@class='alert alert-success' and contains(text(),'Your profile was successfully updated.')]")
    private WebElement bannerSuccess;

    public void updateProfileGoals() {
        selectTextInDropDown(selectDailyGoal, "10 minutes");
        selectTextInDropDown(selectWeeklyGoal, "20 minutes");
        selectTextInDropDown(selectFirstDayOfWeek, "Monday");
        clickOnElement(buttonSaveChanges);
    }

    public void checkSuccessBannerVisible() {
        checkIsElementDisplayed(bannerSuccess);
    }

    public String getUsernameValue() {
        String value = inputUsername.getAttribute("value");
        logger.info("Username value = " + value);
        return value;
    }

    public String getEmailValue() {
        String value = inputEmail.getAttribute("value");
        logger.info("Email value = " + value);
        return value;
    }

    public String getFirstNameValue() {
        String value = inputFirstName.getAttribute("value");
        logger.info("First Name value = " + value);
        return value;
    }

    public String getLastNameValue() {
        String value = inputLastName.getAttribute("value");
        logger.info("Last Name value = " + value);
        return value;
    }

    public String getTimezoneSelectedValue() {
        Select select = new Select(selectTimezone);
        String value = select.getFirstSelectedOption().getText();
        logger.info("Time Zone selected = " + value);
        return value;
    }
}