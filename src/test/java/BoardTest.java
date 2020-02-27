import core.WebDriverManager;
import gmail.AddBoardPopup;
import gmail.BoardPage;
import gmail.CloseBoardPage;
import gmail.CloseBoardPopup;
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
        String actualResult = boardPage.getSpam_boardTitle().getText();

        Assert.assertEquals(BOARD_TITLE, actualResult);
    }

    @Test
    public void closeABoard_TitleAsMyBoard_MyBoard() {
        final String BOARD_TITLE = "My Board";
        final String PAGE_TITLE = BOARD_TITLE + " está cerrado";
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.createBoard(BOARD_TITLE);
        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

        String message = closeBoardPage.getH1_title().getText();

        boolean actualResult = message.matches(PAGE_TITLE + "(.*)");

        Assert.assertTrue(actualResult);
    }

    @Test
    public void deleteABoard_TitleAsMyBoard_MyBoard() {
        final String BOARD_TITLE = "My Board";
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.createBoard(BOARD_TITLE);
        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();
//        closeBoardPage


//        Assert.assertEquals(BOARD_TITLE, actualResult);
    }
}
