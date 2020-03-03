package trello.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.webelement.CloseBoardPopup;

public class BoardPage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_butler));
    }

    @FindBy(css = ".mod-board-name")
    private WebElement spam_boardTitle;

    @FindBy(css = ".js-open-more")
    private WebElement rightMenuBtn_more;

    @FindBy(css = ".js-close-board")
    private WebElement rightMenuBtn_closeBoard;

    @FindBy(css = "span.board-header-btn")
    private WebElement btn_butler;


    public WebElement getSpam_boardTitle() {
        return spam_boardTitle;
    }

    public CloseBoardPopup close() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rightMenuBtn_more));
        rightMenuBtn_more.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rightMenuBtn_closeBoard));
        rightMenuBtn_closeBoard.click();

        return new CloseBoardPopup();
    }
}
