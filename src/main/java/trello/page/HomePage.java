package trello.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.webelement.AddBoardPopup;
import trello.webelement.AddOrganizationPopup;
import trello.webelement.SearchPopup;

public class HomePage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    @FindBy(css = "span._24AWINHReYjNBf")
    private WebElement btn_profile;

    @FindBy(css = ".\\_3r1LXvjBp8zfAv")
    private WebElement btnBar_plus;

    @FindBy(css = ".\\_2DBw9GxD3tha0R")
    private WebElement btn_newBoard;

    @FindBy(css = "li:nth-child(2) .\\_2DBw9GxD3tha0R")
    private WebElement btn_newOrganization;

    @FindBy(css = ".boards-page-board-section-list-item:nth-child(1)")
    private WebElement board_random;

    @FindBy(css = "._33CvMKqfH4Yf0j")
    private WebElement textTag_organization;

    @FindBy(css = "input._1CyMivLdH2a8dA")
    private WebElement txb_search;

    @FindBy(xpath = "//span//a")
    private WebElement btn_search;

    public String getUserName() {
        final String TITLE = "title";
        final String REGEX = "\\(";
        String userName = btn_search.getAttribute(TITLE).split(REGEX, 0)[0];
        return userName.substring(0, userName.length() - 1);
    }

    public SearchPopup search(String nameElement) {
        // Crear un validador
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(txb_search));
        txb_search.sendKeys(nameElement);
        webDriverWait.until(ExpectedConditions.attributeContains(txb_search, "value", nameElement));
        btn_search.click();
        return new SearchPopup();
    }

    public AddBoardPopup displayBoardPopup() {
        clickOnBtnBarPlus();
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_newBoard));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_newBoard));
        btn_newBoard.click();
        return new AddBoardPopup();
    }

    public AddOrganizationPopup displayOrganizationPopup() {
        clickOnBtnBarPlus();
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_newOrganization));
        btn_newOrganization.click();
        return new AddOrganizationPopup();
    }

    public BoardPage openFirstBoard() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(board_random));
        board_random.click();
        return new BoardPage();
    }

    private void clickOnBtnBarPlus() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btnBar_plus));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnBar_plus));
        btnBar_plus.click();
    }
}
