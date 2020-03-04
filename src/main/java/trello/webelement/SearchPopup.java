package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.page.BasePage;

public class SearchPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    @FindBy(css = "div.search-warning")
    private WebElement div_searchWaring;

    public String getMessageSearchResult() {
        webDriverWait.until(ExpectedConditions.visibilityOf(div_searchWaring));
        return div_searchWaring.getText();
    }
}
