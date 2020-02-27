package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    @FindBy(css = "button._2ZNy4w8Nfa58d1:nth-child(5)")
    private WebElement btn_profile;

    @FindBy(css = ".\\_3r1LXvjBp8zfAv")
    private WebElement btnBar_plus;

    @FindBy(css = ".\\_2DBw9GxD3tha0R")
    private WebElement btn_newBoard;

    @FindBy(css = "li:nth-child(2) .\\_2DBw9GxD3tha0R")
    private WebElement btn_newOrganization;

    @FindBy(css = ".boards-page-board-section-list-item:nth-child(1)")
    private WebElement board_random;

    public WebElement getBtn_profile() {
        return btn_profile;
    }

    public AddBoardPopup displayBoardPopup() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnBar_plus));
        btnBar_plus.click();
        btn_newBoard.click();

        return new AddBoardPopup();
    }

    public AddOrganizationPopup displayOrganizationPopup() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnBar_plus));
        btnBar_plus.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_newOrganization));
        btn_newOrganization.click();

        return new AddOrganizationPopup();
    }

    public BoardPage openBoardRandom(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(board_random));
        board_random.click();

        return new BoardPage();
    }
}
