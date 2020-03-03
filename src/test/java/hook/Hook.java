package hook;

import core.WebDriverManager;
import cucumber.api.java.After;

public class Hook {

    @After
    public void tearDown() {
        WebDriverManager.getInstance().quitDriver();
    }
}
