package gmail;

import core.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    final String BASE_URI = "https://trello.com/es";

    @FindBy(css = ".btn-link")
    private WebElement btn_logIn;

    @FindBy(id = "user")
    private WebElement txb_email;

    @FindBy(id = "password")
    private WebElement txb_password;


    @FindBy(id = "login")
    private WebElement btn_logInAccount;


    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public LoginPage() {
    }

    public HomePage login(String email, String password) {
        webDriver.get(BASE_URI);
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_logIn));
        btn_logIn.click();
        txb_email.sendKeys(email);
        txb_password.sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_logInAccount));
        btn_logInAccount.click();

        return new HomePage();
    }
}
