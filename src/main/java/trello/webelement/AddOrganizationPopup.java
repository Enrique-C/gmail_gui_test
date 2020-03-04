package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entity.Board;
import trello.entity.Organization;
import trello.page.BasePage;
import trello.page.OrganizationPage;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public OrganizationInvitePopup create(final Organization organization, final Set<String> fields) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(organization);
        fields.forEach(field -> strategyMap.get(field).run());
        clickOnBtnCreateOrganization();

        return new OrganizationInvitePopup();
    }

    private HashMap<String, Runnable> composeStrategyMap(Organization organization) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put("name", () -> setName(organization.getName()));
        strategyMap.put("description", () -> setDescription(organization.getDescription()));

        return strategyMap;
    }

    private void setName(String name) {
        txb_organizationName.sendKeys(name);
    }

    private void setDescription(String description) {
        txb_OrganizationDescription.sendKeys(description);
    }

    private void clickOnBtnCreateOrganization() {
        btn_createOrganization.click();
    }
}
