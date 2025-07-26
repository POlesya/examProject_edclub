package org.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LibraryPage extends ParentPage {

    public LibraryPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/library";
    }

    @FindBy(xpath = ".//input[@type='checkbox' and @id='reading-filter--1' and @value='reading']")
    private WebElement checkboxFilterReading;

    @FindBy(xpath = ".//input[@name='search_input' and @placeholder='Search']")
    private WebElement inputSearch;

    @FindBy(xpath = ".//a[@href='/library/reading-letters-sight-words']//h2[text()='Letters & Sight Words']")
    private WebElement searchResultCard;

    public void applyReadingFilter() {
        clickOnElement(checkboxFilterReading);
    }

    public void searchForCourse(String courseName) {
        try {
            webDriverWait10.until(ExpectedConditions.visibilityOf(inputSearch));
            inputSearch.clear();
            inputSearch.sendKeys(courseName + Keys.ENTER);

            logger.info(courseName + " was entered into element " + getElementName(inputSearch) + " and Enter was sent together.");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkSearchResultVisible() {
        checkIsElementDisplayed(searchResultCard);
    }
}