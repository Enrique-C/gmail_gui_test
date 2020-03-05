package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GradleReader;

import java.util.Properties;
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
        String browser = GradleReader.readBrowser();
        this.webDriver = WebDriverFactory.getWebDriver(browser);
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 20);
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
