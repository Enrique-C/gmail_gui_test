package Gmail;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GmailLogin {
    private WebDriver driver;

    public GmailLogin(String email, String password) {
        driver = WebDriverManager.getInstance().getWebDriver();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(email, password);
    }
}
