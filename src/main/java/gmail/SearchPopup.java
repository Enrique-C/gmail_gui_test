package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPopup extends BasePage{

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(div_searchWaring));
    }

    @FindBy(css = "div.search-warning")
    private WebElement div_searchWaring;

    public String getMessageSearchResult() {
        return div_searchWaring.getText();
    }
}
