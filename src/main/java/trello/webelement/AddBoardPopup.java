package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.page.BasePage;
import trello.page.BoardPage;

public class AddBoardPopup extends BasePage {

    @FindBy(css = ".\\_23NUW98LaZfBpQ")
    private WebElement txb_boardTitle;

    @FindBy(css = ".\\_3UeOvlU6B5KUnS")
    private WebElement btn_createBoard;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public BoardPage create(String boardTitle) {
        webDriverWait.until(ExpectedConditions.visibilityOf(txb_boardTitle));
        txb_boardTitle.sendKeys(boardTitle);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_createBoard));
        btn_createBoard.click();

        return new BoardPage();
    }
}
