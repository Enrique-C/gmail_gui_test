package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteBoardPage extends BasePage{
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(h1_title));
    }

    @FindBy(css = "h1")
    private WebElement h1_title;

    @FindBy(css = ".little-message")
    private WebElement message;

    public String getH1_title(){
        webDriverWait.until(ExpectedConditions.visibilityOf(message));
        return h1_title.getText();
    }
}
