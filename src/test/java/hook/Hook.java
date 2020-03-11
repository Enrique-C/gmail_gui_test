package hook;

import core.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import trello.PageTransporter;
import trello.page.HomePage;
import trello.page.LoginPage;

public class Hook {

    @Before
    public void beginScenario(){
        final String BASE_URI = "https://trello.com/es";
        HomePage homePage;
        LoginPage loginPage;

        PageTransporter.goToUrl(BASE_URI);
        loginPage = new LoginPage();
        homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
    }

    @After
    public void afterScenario() {
        WebDriverManager.getInstance().quitDriver();
    }
}
