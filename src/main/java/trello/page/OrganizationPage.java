package trello.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.webelement.DeleteOrganizationPopup;

public class OrganizationPage extends BasePage {
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @FindBy(css = "h1.u-inline")
    private WebElement text_pageTitle;

    @FindBy(css = ".js-org-account")
    private WebElement menuBtn_configuration;

    @FindBy(css = ".quiet-button")
    private WebElement textLink_delete;



    public String getText_pageTitle() {
        return text_pageTitle.getText();
    }

    public HomePage delete() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(menuBtn_configuration));
        menuBtn_configuration.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(textLink_delete));
        textLink_delete.click();
        DeleteOrganizationPopup deleteOrganizationPopup = new DeleteOrganizationPopup();
        deleteOrganizationPopup.confirm();

        return new HomePage();
    }
}
