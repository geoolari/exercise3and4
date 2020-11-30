package pages.ghost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtils;

public class GhostStartPage {
    @FindBy(xpath = "//span[contains(text(),'Resources')]")
    private WebElement resources;

    @FindBy(xpath = "//h5[contains(text(),'Community Forum')]")
    private WebElement forum;

    private static final String PAGE_URL = "https://ghost.org/";

    private final WebDriver driver;

    public GhostStartPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public GhostCommunityForumPage navigateToCommunityForumPage() {
        resources.click();
        WebElementUtils.waitForElementToBeClickable(driver, forum);
        forum.click();
        return new GhostCommunityForumPage(driver);
    }
}