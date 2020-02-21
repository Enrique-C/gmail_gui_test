import Gmail.LoginPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void test(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("enrique.carrizalesh@gmail.com", "E7999812c");
    }
}
