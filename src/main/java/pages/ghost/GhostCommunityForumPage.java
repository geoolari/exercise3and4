package pages.ghost;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementUtils;

import java.util.List;

public class GhostCommunityForumPage {
    @FindBy(id = "search-button")
    private WebElement searchButton;

    @FindBy(id = "search-term")
    private WebElement searchInputField;

    @FindBy(className = "results")
    private WebElement results;

    @FindBy(css = "li.item")
    private List<WebElement> items;

    private final WebDriver driver;

    public GhostCommunityForumPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public GhostCommunityForumPage searchTerm(String term) {
        WebElementUtils.waitForElementToBeVisible(driver, searchButton);
        searchButton.click();
        WebElementUtils.setValue(searchInputField,term);
        return this;
    }

    public GhostCommunityForumPage openOneSearchedResult() {
        WebElementUtils.waitForElementToBeVisible(driver, results);
        items.get(1).click();
        return this;
    }
}
