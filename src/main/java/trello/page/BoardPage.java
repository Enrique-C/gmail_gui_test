package trello.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.webelement.CloseBoardPopup;

import java.util.HashMap;
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
    private WebElement btn_levelVisibilityBoard;

    @FindBy(css = ".js-open-more")
    private WebElement rightMenuBtn_more;

    @FindBy(css = ".js-close-board")
    private WebElement rightMenuBtn_closeBoard;

    @FindBy(css = "span.board-header-btn")
    private WebElement btn_butler;

    private Set<String> webElements;


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

    public HashMap<String, String> getBoardResult(final Set<String> fields) {
        HashMap<String, String> values = new HashMap<>();
        HashMap<String, Supplier> strategyMap = composeStrategyMap();
//        fields.forEach(field -> strategyMap.get(field).get());
        for (String field: strategyMap.keySet()) {
            values.put(field, strategyMap.get(field).get().toString());
        }
        return values;
    }

    private HashMap<String, Supplier> composeStrategyMap() {
        HashMap<String, Supplier> strategyMap = new HashMap<>();

        strategyMap.put("name", this::getNameBoard);
        strategyMap.put("visibility", this::getVisibilityBoard);

        return strategyMap;
    }

    private String getVisibilityBoard() {
        final String LOCATOR_TEXT_VISIBILITY = "//div[@class= \"js-board-header-btn-org-wrapper board-header-btn-org-wrapper\"]//a[@id=\"permission-level\"]";
        return btn_levelVisibilityBoard.findElement(By.xpath(LOCATOR_TEXT_VISIBILITY)).getText();
    }

    private String getNameBoard() {
        return spam_boardName.getText();
    }
}
