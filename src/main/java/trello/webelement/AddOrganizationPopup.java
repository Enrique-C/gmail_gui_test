package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entity.Organization;
import trello.page.BasePage;
import trello.page.OrganizationPage;

public class AddOrganizationPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_createOrganization));
    }

    @FindBy(css = "input._1CLyNodCAa-vQi")
    private WebElement txb_organizationName;

    @FindBy(css = "textarea._15aIJYNKhrO4vB")
    private WebElement txb_OrganizationDescription;

    @FindBy(css = "._3UeOvlU6B5KUnS")
    private WebElement btn_createOrganization;

    @FindBy(css = ".eg0KI5SqghoOFd")
    private WebElement linkText;

    public OrganizationPage create(Organization organization) {
        txb_organizationName.sendKeys(organization.getName());
        txb_OrganizationDescription.sendKeys(organization.getDescription());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_createOrganization));
        btn_createOrganization.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(linkText));
        linkText.click();

        return new OrganizationPage();
    }
}
