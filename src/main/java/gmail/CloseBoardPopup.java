package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CloseBoardPopup extends BasePage{

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @FindBy(css = ".js-confirm")
    private WebElement btn_confirm;

    public CloseBoardPage confirm() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_confirm));
        btn_confirm.click();

        return new CloseBoardPage();
    }
}
