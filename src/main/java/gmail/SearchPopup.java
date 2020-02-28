package gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPopup extends BasePage{
    private static final String MESSAGE_LOCATOR = "p.JnTUaEUhn58h7u";

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(div_searchResult));
    }

    @FindBy(css = "div._2qAhBotzZJDWpK")
    private WebElement div_searchResult;

    public String getMessageSearchResult() {
        return div_searchResult.findElement(By.cssSelector(MESSAGE_LOCATOR)).getText();
    }
}
