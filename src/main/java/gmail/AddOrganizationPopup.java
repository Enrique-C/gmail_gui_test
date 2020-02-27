package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddOrganizationPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_createOrganization));
    }

    @FindBy(css = "input._1CLyNodCAa-vQi")
    //#\31 582840706832-create-team-org-display-name
    private WebElement txb_organizationName;

    @FindBy(css = "textarea._15aIJYNKhrO4vB")
    private WebElement txb_OrganizationDescription;

    @FindBy(css = "._3UeOvlU6B5KUnS")
    private WebElement btn_createOrganization;

    @FindBy(css = ".eg0KI5SqghoOFd")
    private WebElement linkText;

    public OrganizationPage create(String organizationName, String OrganizationDescription) {
        txb_organizationName.sendKeys(organizationName);
        txb_OrganizationDescription.sendKeys(OrganizationDescription);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_createOrganization));
        btn_createOrganization.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(linkText));
        linkText.click();

        return new OrganizationPage();
    }
}
