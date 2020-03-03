package trello.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.PageTransporter;

public class LoginPage extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    @FindBy(css = ".btn-link")
    private WebElement btn_logIn;

    @FindBy(id = "user")
    private WebElement txb_email;

    @FindBy(id = "password")
    private WebElement txb_password;


    @FindBy(id = "login")
    private WebElement btn_logInAccount;

    public HomePage login(String email, String password) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_logIn));
        btn_logIn.click();
        txb_email.sendKeys(email);
        txb_password.sendKeys(password);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btn_logInAccount));
        btn_logInAccount.click();

        return new HomePage();
    }
}
