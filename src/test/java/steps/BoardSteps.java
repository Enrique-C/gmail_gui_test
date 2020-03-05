package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import trello.PageTransporter;
import trello.entity.Board;
import trello.entity.Organization;
import trello.webelement.AddBoardPopup;
import trello.page.BoardPage;
import trello.page.CloseBoardPage;
import trello.webelement.CloseBoardPopup;
import trello.page.DeleteBoardPage;
import trello.webelement.DeleteBoardPopup;
import trello.page.HomePage;
import org.junit.Assert;

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

    public BoardSteps(Board board, Organization organization) {
        this.board = board;
        this.organization = organization;
    }


    @When("^I create a Board with name \"([^\"]*)\"$")
    public void createABoardWithName(String boardName) {
        board.setName(boardName);
        homePage = new HomePage();
        addBoardPopup = homePage.displayBoardPopup();
        boardPage = addBoardPopup.create(board);
    }

    @Then("^The application should displays a page with the name board$")
    public void displaysAPageWithNameBoard() {
        String actualResult = boardPage.getSpam_boardName().getText();

        Assert.assertEquals(board.getName(), actualResult);
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
    public void displaysADeleteBoardMessage(String deleteMessage) {
        String actualResult = deleteBoardPage.getH1_title();
        Assert.assertEquals(deleteMessage, actualResult);
    }
}
