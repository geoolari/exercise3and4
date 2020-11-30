package pages.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebElementUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Way2AutomationDatePickerPage {
    @FindBy(linkText = "FORMAT DATE")
    private WebElement formatDateTab;

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy(id = "datepicker")
    private WebElement datepicker;

    @FindBy(css = "[class~=ui-datepicker-today]")
    private WebElement todayDate;

    private final WebDriver driver;

    public Way2AutomationDatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Way2AutomationDatePickerPage openFormatDateTab() {
        formatDateTab.click();
        return this;
    }

    public Way2AutomationDatePickerPage pickTodayDate() {
        for (WebElement iframe : iframes) {
            if (iframe.getAttribute("src").contains("datepicker/defult4.html")) {
                driver.switchTo().frame(iframe);
            }
        }
        WebElementUtils.waitForElementToBeVisible(driver, datepicker);
        datepicker.click();
        todayDate.click();
        return this;
    }

    public Way2AutomationDatePickerPage pickFormatDateAsISO8601() {
        Select dropdownFormat = new Select(driver.findElement(By.id("format")));
        dropdownFormat.selectByVisibleText("ISO 8601 - yy-mm-dd");
        return this;
    }

    public Way2AutomationDatePickerPage validateShownDate() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String shownDate = (String) jse.executeScript("return arguments[0].value", datepicker);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format( Calendar.getInstance().getTime());

        assertEquals(currentDate,shownDate);
        return this;
    }
}