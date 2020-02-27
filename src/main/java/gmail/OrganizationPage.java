package gmail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage extends BasePage{
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @FindBy(css = "h1.u-inline")
    private WebElement text_pageTitle;

    public String getText_pageTitle() {
        return text_pageTitle.getText();
    }
}
