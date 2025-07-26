package org.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pages.CommonActionsWithElements;
import org.pages.MyProfilePage;

public class HeaderForLoggedUserElement extends CommonActionsWithElements {

    public HeaderForLoggedUserElement(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@class='dropdown-toggle' and @role='menuitem' and contains(text(),'Olesia')]")
    private WebElement dropdownUserMenu;

    @FindBy(xpath = ".//a[@role='menuitem' and contains(text(), 'Logout')]")
    private WebElement buttonLogout;

    @FindBy(xpath = ".//a[@href='#' and @role='menuitem' and contains(text(),'Profile')]")
    private WebElement buttonProfile;

    public void clickLogout() {
        clickOnElement(buttonLogout);
    }

    public void openUserDropdown() {
        clickOnElement(dropdownUserMenu);
    }

    public MyProfilePage clickOnProfileInDropdown() {
        clickOnElement(buttonProfile);
        return new MyProfilePage(webDriver);
    }

    public void checkUserDropdownIsVisibleWithName(String expectedName) {
        String xpath = String.format(".//a[@class='dropdown-toggle' and @role='menuitem' and contains(text(),'%s')]", expectedName);
        WebElement dynamicDropdown = webDriver.findElement(By.xpath(xpath));
        checkIsElementDisplayed(dynamicDropdown);
    }
}