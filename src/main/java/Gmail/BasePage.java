package Gmail;

import Core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.manage().window().maximize();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
        waitUntilPageObjectIsLoaded();
    }

    protected abstract void waitUntilPageObjectIsLoaded();
}
