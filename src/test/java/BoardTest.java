import core.WebDriverManager;
import trello.PageTransporter;
import trello.entity.Board;
import trello.webelement.AddBoardPopup;
import trello.page.BoardPage;
import trello.page.CloseBoardPage;
import trello.webelement.CloseBoardPopup;
import trello.page.DeleteBoardPage;
import trello.webelement.DeleteBoardPopup;
import trello.page.HomePage;
import trello.page.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class BoardTest {

    final static String BASE_URI = "https://trello.com/es";
    final static String BOARD_NAME = "Test Board";
    final static String BOARD_VISIBILITY = "Privado";

    @After
    public void afterTest() {
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void createABoard_TitleAsMyBoard_MyBoard() {
        Map<String, String> boardAttributes = new HashMap<>();
        boardAttributes.put("name", BOARD_NAME);
        boardAttributes.put("visibility", BOARD_VISIBILITY);

        Board board = new Board();

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        board.setBoardInformation(boardAttributes);
        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.create(board, boardAttributes.keySet());

        String actualResult = boardPage.getSpam_boardName().getText();

        Assert.assertEquals(BOARD_NAME, actualResult);

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

        DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
        deleteBoardPopup.confirm();
    }

    @Test
    public void closeABoard_TitleAsMyBoard_MyBoard() {
        final String CLOSE_BOARD_MESSAGE = BOARD_NAME + " está cerrado.";

        Map<String, String> boardAttributes = new HashMap<>();
        boardAttributes.put("name", BOARD_NAME);
        boardAttributes.put("visibility", BOARD_VISIBILITY);

        Board board = new Board();
        board.setName(BOARD_NAME);

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        board.setBoardInformation(boardAttributes);

        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.create(board, boardAttributes.keySet());

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();
        String message = closeBoardPage.getH1_title();

        Assert.assertEquals(CLOSE_BOARD_MESSAGE, message);
    }

    @Test
    public void deleteABoard_TitleAsMyBoard_MyBoard() {
        final String CLOSE_BOARD_PAGE_TITLE = "Tablero no encontrado.";

        Map<String, String> boardAttributes = new HashMap<>();
        boardAttributes.put("name", BOARD_NAME);
        boardAttributes.put("visibility", BOARD_VISIBILITY);

        Board board = new Board();
        board.setName(BOARD_NAME);

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        board.setBoardInformation(boardAttributes);

        AddBoardPopup addBoardPopup = homePage.displayBoardPopup();
        BoardPage boardPage= addBoardPopup.create(board, boardAttributes.keySet());

        CloseBoardPopup closeBoardPopup = boardPage.close();
        CloseBoardPage closeBoardPage = closeBoardPopup.confirm();

        DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
        DeleteBoardPage deleteBoardPage = deleteBoardPopup.confirm();

        String actualResult = deleteBoardPage.getH1_title();

        Assert.assertEquals(CLOSE_BOARD_PAGE_TITLE, actualResult);
    }

//    @Test
//    public void cleanTestAccountTrello() {
//        PageTransporter.goToUrl(BASE_URI);
//
//        LoginPage loginPage = new LoginPage();
//        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
//
//        while (true){
//            BoardPage boardPage= homePage.openFirstBoard();
//
//            CloseBoardPopup closeBoardPopup = boardPage.close();
//            CloseBoardPage closeBoardPage = closeBoardPopup.confirm();
//
//            DeleteBoardPopup deleteBoardPopup = closeBoardPage.delete();
//            deleteBoardPopup.confirm();
//            WebDriverManager.getInstance().getWebDriver().get("https://trello.com/enriquecarrizales1/boards");
//        }
//    }
}
