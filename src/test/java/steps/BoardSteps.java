package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entity.Board;
import trello.entity.Organization;
import trello.webelement.AddBoardPopup;
import trello.page.BoardPage;
import trello.page.CloseBoardPage;
import trello.webelement.CloseBoardPopup;
import trello.page.DeleteBoardPage;
import trello.webelement.DeleteBoardPopup;
import trello.page.HomePage;

import java.util.Map;

public class BoardSteps {

    HomePage homePage;
    AddBoardPopup addBoardPopup;
    BoardPage boardPage;
    CloseBoardPopup closeBoardPopup;
    CloseBoardPage closeBoardPage;
    DeleteBoardPopup deleteBoardPopup;
    DeleteBoardPage deleteBoardPage;

    Board board;
    Organization organization;

    Map<String, String> actualResultBoard;

    public BoardSteps(Board board, Organization organization) {
        this.board = board;
        this.organization = organization;
    }

    @When("^I create a Board with values$")
    public void createABoardWithName(final Map<String, String> boardAttributes) {
        homePage = new HomePage();
        board.setBoardInformation(boardAttributes);
        addBoardPopup = homePage.displayBoardPopup();
        boardPage = addBoardPopup.create(board, boardAttributes.keySet());

        this.actualResultBoard = boardAttributes;
    }

    @Then("^The application should displays a page with the name board$")
    public void displaysAPageWithNameBoard() {
        Map<String, String> expectedResultBoard = boardPage.getBoardResult(actualResultBoard.keySet());
        Assert.assertEquals(actualResultBoard, expectedResultBoard);
    }

    @When("^I close Board$")
    public void closeTheBoard() {
        closeBoardPopup = boardPage.close();
        closeBoardPage = closeBoardPopup.confirm();
    }

    @Then("^The application should displays a close board message \"([^\"]*)\"$")
    public void theApplicationShouldDisplaysAMessage(String closeMessage) {
        String message = closeBoardPage.getH1_title();
        Assert.assertEquals(closeMessage, message);
    }

    @When("^I delete Board$")
    public void deleteBoard() {
        deleteBoardPopup = closeBoardPage.delete();
        deleteBoardPage = deleteBoardPopup.confirm();
    }

    @Then("^The application should displays a delete board message \"([^\"]*)\"$")
    public void displaysADeleteBoardMessage(String expectedResultMessage) {
        String actualResultMessage = deleteBoardPage.getH1_title();
        Assert.assertEquals(actualResultMessage, expectedResultMessage);
    }
}
