package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddBoardPopup extends BasePage {

    @FindBy(css = ".\\_23NUW98LaZfBpQ")
    private WebElement txb_boardTitle;

    @FindBy(css = ".\\_3UeOvlU6B5KUnS")
    private WebElement btn_boardCreate;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public BoardPage createBoard(String boardTitle) {
        txb_boardTitle.sendKeys(boardTitle);
        btn_boardCreate.click();

        return new BoardPage();
    }
}
