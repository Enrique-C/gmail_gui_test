package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CloseBoardPage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(h1_title));
    }

    @FindBy(css = "h1")//h1:nth-child(1) //p[@text()=’ SIGN UP’]
    private WebElement h1_title;

    @FindBy(css = "a.quiet")
    private WebElement link_deleteBoard;

    public String getH1_title() {
        return h1_title.getText();
    }

    public DeleteBoardPopup delete() {
        link_deleteBoard.click();
        return new DeleteBoardPopup();
    }
}
