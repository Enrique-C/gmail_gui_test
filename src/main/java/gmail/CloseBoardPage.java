package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloseBoardPage extends BasePage{

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(h1_title));
    }

    @FindBy(css = "h1:nth-child(1)")
    private WebElement h1_title;

    @FindBy(css = "a.quiet")
    private WebElement link_deleteBoard;

    public WebElement getH1_title() {
        return h1_title;
    }

//    public WebElement delete()´´´´

}
