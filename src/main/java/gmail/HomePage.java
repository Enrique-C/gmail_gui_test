package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = "button._2ZNy4w8Nfa58d1:nth-child(5)")
    private WebElement btn_profile;

    @FindBy(css = ".\\_3r1LXvjBp8zfAv")
    private WebElement btnBar_plus;

    @FindBy(css = ".\\_2DBw9GxD3tha0R")
    private WebElement btn_newBoard;

    @Override
    protected void waitUntilPageObjectIsLoaded() {
    }

    public WebElement getBtn_profile() {
        return btn_profile;
    }

    public AddBoardPopup displayBoardPopup() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnBar_plus));
        btnBar_plus.click();
//        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_newBoard));
        btn_newBoard.click();

        return new AddBoardPopup();
    }
}
