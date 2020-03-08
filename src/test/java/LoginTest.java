import core.WebDriverManager;
import org.junit.Assert;
import trello.PageTransporter;
import trello.page.HomePage;
import trello.page.LoginPage;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    static final String BASE_URI = "https://trello.com/es";

    @After
    public void afterTest(){
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void login_ValidUser_LoginPage(){
        PageTransporter.goToUrl(BASE_URI);
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
        final String EXPECTED_RESULT = "Enrique Carrizales";
        String actualResult = homePage.getUserName();

        Assert.assertEquals(EXPECTED_RESULT, actualResult);
    }
}
