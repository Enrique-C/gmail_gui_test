package Gmail;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    WebDriver driver;

    public BasePage() {
        driver = WebDriverManager.getInstance().getWebDriver();
    }
}
