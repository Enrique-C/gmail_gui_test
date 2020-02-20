package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
    private WebDriver webDriver;
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
        this.webDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
