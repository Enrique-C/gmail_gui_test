package Gmail;

import org.openqa.selenium.support.PageFactory;

public class GmailLogin extends BasePage {

    public GmailLogin(String email, String password) {
        LoginPage loginPage = PageFactory.initElements(this.driver, LoginPage.class);
        loginPage.login(email, password);
    }
}
