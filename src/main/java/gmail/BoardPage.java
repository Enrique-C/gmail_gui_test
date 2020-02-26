package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage{

    @FindBy(className = ".mod-board-name")
    private WebElement spam_boardTitle;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public WebElement getSpam_boardTitle() {
        return spam_boardTitle;
    }
}
