package core.webdriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class Chrome implements IDriver {

    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(CHROME).version("80.0.3987.16").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        return new ChromeDriver(chromeOptions);
    }
}
