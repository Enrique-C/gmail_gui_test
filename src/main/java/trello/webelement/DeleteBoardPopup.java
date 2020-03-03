package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.page.BasePage;
import trello.page.DeleteBoardPage;

public class DeleteBoardPopup extends BasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_delete));
    }

    @FindBy(css = "input[value = Eliminar]")
    private WebElement btn_delete;

    public DeleteBoardPage confirm() {
        btn_delete.click();

        return new DeleteBoardPage();
    }
}
