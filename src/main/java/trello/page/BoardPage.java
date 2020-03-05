package trello.page;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entity.Organization;
import trello.webelement.CloseBoardPopup;
import trello.webelement.OrganizationInvitePopup;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class BoardPage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_butler));
    }

    @FindBy(css = ".mod-board-name")
    private WebElement spam_boardName;

    @FindBy(css = "#permission-level")
    private WebElement btn_levelAccessBoard;

    @FindBy(css = ".js-open-more")
    private WebElement rightMenuBtn_more;

    @FindBy(css = ".js-close-board")
    private WebElement rightMenuBtn_closeBoard;

    @FindBy(css = "span.board-header-btn")
    private WebElement btn_butler;

    private Set<String> webElements;

//    public BoardPage() {
//        webElements = new HashSet<>();
//        webElements.add()
//    }


    public WebElement getSpam_boardName() {
        return spam_boardName;
    }

    public CloseBoardPopup close() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rightMenuBtn_more));
        rightMenuBtn_more.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(rightMenuBtn_closeBoard));
        rightMenuBtn_closeBoard.click();

        return new CloseBoardPopup();
    }

//    public void getBoardResult(final String boardVisibility, final Set<String> fields) {
//        HashMap<String, Supplier> strategyMap = composeStrategyMap(boardVisibility);
//        fields.forEach(field -> strategyMap.get(field).get());
//
//    }
//
//    private HashMap<String, Supplier> composeStrategyMap(String boardVisibility) {
//        HashMap<String, Supplier> strategyMap = new HashMap<>();
//
//        strategyMap.put("name", getVisibilityBoard(boardVisibility));
//        strategyMap.put("visibility", getNameBoard());
//
//        return strategyMap;
//    }
//
//    private String getVisibilityBoard(String boardVisibility) {
//        String locatorBoardVisibility = "spam:contains('s%')";
//        locatorBoardVisibility = String.format(locatorBoardVisibility, boardVisibility);
//        return btn_levelAccessBoard.findElement(By.cssSelector(locatorBoardVisibility)).getText();
//    }

    private String getNameBoard() {
        return spam_boardName.getText();
    }

    private void validate(String actualResult, String expectedResult) {
    }
}
