package Gmail;

import Core.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage{
    final String BASE_URI = "https://www.google.com/gmail/";
    private WebDriver driver;
    private WebElement identifierId;
    private WebElement identifierNext;

    @FindBy(name = "password")
    private WebElement txb_password;


    public LoginPage() {
        driver = WebDriverManager.getInstance().getWebDriver();
    }

    public void login(String email, String password) {
        driver.get(BASE_URI);
        identifierId.sendKeys(email);
        identifierNext.click();
        txb_password.click();
        txb_password.sendKeys(password);
    }
}
