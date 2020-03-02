import core.WebDriverManager;
import gmail.AddBoardPopup;
import gmail.BoardPage;
import gmail.CloseBoardPage;
import gmail.CloseBoardPopup;
import gmail.DeleteBoardPage;
import gmail.DeleteBoardPopup;
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
        BoardPage boardPage= addBoardPopup.create(BOARD_TITLE);

        String actualResult = boardPage.getSpam_boardTitle().getText();

        Assert.assertEquals(BOARD_TITLE, actualResult);

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

        DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
        deleteBoardPopup.confirm();
    }

    @Test
    public void closeABoard_TitleAsMyBoard_MyBoard() {
        final String BOARD_NAME = "My Board";
        final String CLOSE_BOARD_MESSAGE = BOARD_NAME + " está cerrado.";

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.create(BOARD_NAME);

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();
        String message = closeBoardPage.getH1_title();

        Assert.assertEquals(CLOSE_BOARD_MESSAGE, message);
    }

    @Test
    public void deleteABoard_TitleAsMyBoard_MyBoard() {
        final String BOARD_NAME = "My Board";
        final String CLOSE_BOARD_PAGE_TITLE = "Tablero no encontrado.";

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.create(BOARD_NAME);

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

        DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
        DeleteBoardPage deleteBoardPage = deleteBoardPopup.confirm();

        String actualResult = deleteBoardPage.getH1_title();

        Assert.assertEquals(CLOSE_BOARD_PAGE_TITLE, actualResult);
    }

    @Test
    public void darkHole() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        while (true){
            BoardPage boardPage= homePage.openFirstBoard();

            CloseBoardPopup closeBoardPopup = boardPage.close();
            CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

            DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
            deleteBoardPopup.confirm();
            WebDriverManager.getInstance().getWebDriver().get("https://trello.com/enriquecarrizales1/boards");
        }
    }
}
