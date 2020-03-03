import core.WebDriverManager;
import trello.page.HomePage;
import trello.page.LoginPage;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    @After
    public void afterTest(){
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void login_ValidUser_LoginPage(){
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
        final String EXPECTED_RESULT = "Enrique Carrizales";
        String btn_profileTitle = homePage.getBtn_profile().getAttribute("title");
        boolean actualResult = btn_profileTitle.matches(".*" + EXPECTED_RESULT + ".*");

        assertTrue(actualResult);
    }
}
