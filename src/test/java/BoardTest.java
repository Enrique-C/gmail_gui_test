import core.WebDriverManager;
import gmail.AddBoardPopup;
import gmail.BoardPage;
import gmail.HomePage;
import gmail.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class BoardTest {

    @After
    public void afterTest() {
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void createABoard_TitleAsMyBoard_MyBoard() {
        final String BOARD_TITLE = "My Board";
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.createBoard(BOARD_TITLE);
        String actualResult = boardPage.getSpam_boardTitle().getAttribute("name");

        Assert.assertEquals(BOARD_TITLE, actualResult);
    }
}
