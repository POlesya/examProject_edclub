package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class ParentPage extends CommonActionsWithElements {
    protected WebDriver webDriver;
    protected WebDriverWait wait;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void openPage() {
        String baseUrl = "https://www.edclub.com";
        webDriver.get(baseUrl + getRelativeUrl());
    }

    protected abstract String getRelativeUrl();


    protected void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void click(WebElement element) {
        waitUntilVisible(element);
        element.click();
    }

    protected void checkCurrentUrl(String expectedRelativeUrl) {
        String actualUrl = webDriver.getCurrentUrl();
        String expectedUrl = "https://www.edclub.com" + expectedRelativeUrl;
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Expected URL: " + expectedUrl + " but got: " + actualUrl);
        }
    }
}