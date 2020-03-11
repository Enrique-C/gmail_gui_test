package trello.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import trello.entity.Organization;
import trello.page.BasePage;

import java.util.HashMap;
import java.util.Set;

public class AddOrganizationPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_createOrganization));
    }

    @FindBy(css = "input._1CLyNodCAa-vQi")
    private WebElement txb_organizationName;

    @FindBy(css = "div[id=\"teamTypeSelect\"]")
    private WebElement listBox_teamType;

    @FindBy(css = "textarea._15aIJYNKhrO4vB")
    private WebElement txb_OrganizationDescription;

    @FindBy(css = "._3UeOvlU6B5KUnS")
    private WebElement btn_createOrganization;

    @FindBy(css = ".eg0KI5SqghoOFd")
    private WebElement linkText;

    public OrganizationInvitePopup create(final Organization organization, final Set<String> fields) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(organization);
        fields.forEach(field -> strategyMap.get(field).run());
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_createOrganization));
        clickOnBtnCreateOrganization();

        return new OrganizationInvitePopup();
    }

    private HashMap<String, Runnable> composeStrategyMap(Organization organization) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(organization.getName()));
        strategyMap.put("team type", () -> setTeamType(organization.getTeamType()));
        strategyMap.put("description", () -> setDescription(organization.getDescription()));
        return strategyMap;
    }

    private void setName(String name) {
        txb_organizationName.sendKeys(name);
    }

    private void setTeamType(String teamType){
        String xpath_baseOptionToSelect = "//li[contains(.,'%s')]";
        String xpath_optionSelected = String.format(xpath_baseOptionToSelect, teamType);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(listBox_teamType));
        listBox_teamType.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_optionSelected))).click();
    }

    private void setDescription(String description) {
        txb_OrganizationDescription.sendKeys(description);
    }

    private void clickOnBtnCreateOrganization() {
        btn_createOrganization.click();
    }
}
