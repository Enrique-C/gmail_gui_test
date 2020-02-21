package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver getWebDriver(final String browser){
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    }
}
