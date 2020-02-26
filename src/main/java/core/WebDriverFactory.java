package core;

import core.webdriver.Chrome;
import core.webdriver.Firefox;
import core.webdriver.IDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {

    public static WebDriver getWebDriver(final String browser){
        Map<String, IDriver> map = new HashMap<>();
        map.put("chrome", new Chrome());
        map.put("firefox", new Firefox());
        return map.get(browser).initDriver();
//        WebDriver webDriver = new ChromeDriver();
//        return webDriver;
    }
}
