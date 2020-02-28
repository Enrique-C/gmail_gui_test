package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteBoardPopup extends BasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_delete));
    }

    @FindBy(css = "input.js-confirm full negate")
    private WebElement btn_delete;

    public DeleteBoardPage confirm() {
        btn_delete.click();

        return new DeleteBoardPage();
    }
}
