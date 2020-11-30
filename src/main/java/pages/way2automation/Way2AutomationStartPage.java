package pages.way2automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WebElementUtils;

import java.util.List;
import java.util.UUID;

public class Way2AutomationStartPage {
    @FindBy(id = "load_box")
    private WebElement registrationForm;

    @FindBy(css = "[name~=name]")
    private WebElement nameField;

    @FindBy(css = "[name~=phone]")
    private WebElement phoneField;

    @FindBy(css = "[name~=email]")
    private WebElement emailField;

    @FindBy(css = "[name~=city]")
    private WebElement cityField;

    @FindBy(css = "[name~=username]")
    private List<WebElement> usernameFields;

    @FindBy(css = "[name~=password]")
    private List<WebElement> passwordFields;

    @FindBy(css = "[value~=Submit]")
    private List<WebElement> submitButtons;

    @FindBy(linkText = "Widget")
    private WebElement widget;

    @FindBy(linkText = "Datepicker")
    private WebElement datepicker;

    private static final String PAGE_URL = "http://way2automation.com/way2auto_jquery/index.php";

    private final WebDriver driver;

    public Way2AutomationStartPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public Way2AutomationStartPage register() {
        WebElementUtils.waitForElementToBeVisible(driver, registrationForm);
        String generatedData = UUID.randomUUID().toString();
        WebElementUtils.setValue(nameField,"Ana Oana");
        WebElementUtils.setValue(phoneField,"0734781339");
        WebElementUtils.setValue(emailField,generatedData + "@gmail.com");
        Select dropdownCountry = new Select(driver.findElement(By.name("country")));
        dropdownCountry.selectByVisibleText("Romania");
        cityField.sendKeys("Timisoara");
        WebElementUtils.setValue(usernameFields.get(1),generatedData);
        WebElementUtils.setValue(passwordFields.get(1),generatedData);
        submitButtons.get(1).click();
        return this;
    }

    public Way2AutomationDatePickerPage navigateToDatePickerPage() {
        Actions action = new Actions(driver);
        action.moveToElement(widget).click().perform();
        WebElementUtils.waitForElementToBeClickable(driver, datepicker);
        action.moveToElement(datepicker).click().perform();
        return new Way2AutomationDatePickerPage(driver);
    }
}
