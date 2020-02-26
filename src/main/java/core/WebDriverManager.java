package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private static WebDriverManager instance;

    private WebDriverManager() {
        initialize();
    }

    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    private void initialize() {
        PropertiesManager properties = new PropertiesManager();
        String browser = properties.getBrowser();
        this.webDriver = WebDriverFactory.getWebDriver(browser);
        this.webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 40);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }
}
