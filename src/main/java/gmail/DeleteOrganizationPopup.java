package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteOrganizationPopup extends BasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(popupBtn_confirmDelete));
    }

    @FindBy(css = ".js-confirm")
    private WebElement popupBtn_confirmDelete;

    public void confirm() {
        popupBtn_confirmDelete.click();
    }
}
