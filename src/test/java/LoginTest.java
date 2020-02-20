import Gmail.GmailLogin;
import Gmail.LoginPage;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void test(){
        new GmailLogin("enrique.carrizalesh@gmail.com", "E7999812c");
    }
}
