package trello.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.webelement.DeleteBoardPopup;

public class CloseBoardPage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(h1_title));
    }

    @FindBy(css = "h1")
    private WebElement h1_title;

    @FindBy(css = "a.quiet")
    private WebElement link_deleteBoard;

    public String getH1_title() {
        return h1_title.getText();
    }

    public DeleteBoardPopup delete() {
        link_deleteBoard.click();
        return new DeleteBoardPopup();
    }
}
