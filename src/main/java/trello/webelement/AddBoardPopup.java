package trello.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entity.Board;
import trello.page.BasePage;
import trello.page.BoardPage;

import java.util.HashMap;
import java.util.Set;

public class AddBoardPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_moreBackground));
    }

    @FindBy(css = ".\\_23NUW98LaZfBpQ")
    private WebElement txb_boardTitle;

    @FindBy(css = ".\\_3UeOvlU6B5KUnS")
    private WebElement btn_createBoard;

    @FindBy(css = "._1Lkx3EjS3wCrs7")
    private WebElement btn_visibility;

    @FindBy(xpath = "//span[@class = \"_2BQG4yPMt5s_hu _3qi72H5bh1Hw2k _1b1jsYFCPYOS8c _3uyeiQJHPeTbZO\"]")
    private WebElement btn_moreBackground;

    public BoardPage create(final Board board, final Set<String> fields) {
        final String CREATE_BUTTON_ATTRIBUTE = "style";
        final String CREATE_BUTTON_VALUE = "width: 105px;";
        HashMap<String, Runnable> strategyMap = composeStrategyMap(board);
        fields.forEach(field -> strategyMap.get(field).run());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_createBoard));
        webDriverWait.until(ExpectedConditions.attributeContains(btn_createBoard, CREATE_BUTTON_ATTRIBUTE,CREATE_BUTTON_VALUE));
        btn_createBoard.click();

        return new BoardPage();
    }

    private HashMap<String, Runnable> composeStrategyMap(Board board) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(board.getName()));
        strategyMap.put("visibility", () -> seVisibility(board.getVisibility()));
        return strategyMap;
    }

    private void setName(String boardName) {
        txb_boardTitle.sendKeys(boardName);
    }

    private void seVisibility(String boardVisibility) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_visibility));
        btn_visibility.click();
        final String LOCATOR_VISIBILITY_OPTION = "._1ArtKJZLTN_ljN";
        String auxLocatorBoardVisibility = "//button[span[contains(text(),'%s')] and @class='_2jR0BZMM5cBReR _2_NniNXJ4o9-Nk']";

        webDriverWait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.cssSelector(LOCATOR_VISIBILITY_OPTION))));
        String locatorBoardVisibility = String.format(auxLocatorBoardVisibility, boardVisibility);
        this.webDriver.findElement(By.xpath(locatorBoardVisibility)).click();
    }
}
