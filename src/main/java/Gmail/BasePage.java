package Gmail;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = WebDriverManager.getInstance().getWebDriver();
        PageFactory.initElements(this.driver, this);
    }
}
