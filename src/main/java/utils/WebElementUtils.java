package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementUtils {
    private static final int WAIT_TIMEOUT = 10;

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
}
