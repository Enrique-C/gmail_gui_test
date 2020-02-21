package gmail;

import core.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    final String BASE_URI = "https://www.google.com/gmail/";
    private WebElement identifierId;
    private WebElement identifierNext;

    @FindBy(name = "password")
    private WebElement txb_password;

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public LoginPage() {
    }


    public void login(String email, String password) {
        webDriver.get(BASE_URI);
        identifierId.sendKeys(email);
        identifierNext.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(txb_password));
        txb_password.sendKeys(password);
        WebDriverManager.getInstance().quitDriver();
    }
}
