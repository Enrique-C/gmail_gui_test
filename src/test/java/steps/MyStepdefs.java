package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import trello.webelement.AddBoardPopup;
import trello.page.BoardPage;
import trello.page.CloseBoardPage;
import trello.webelement.CloseBoardPopup;
import trello.page.DeleteBoardPage;
import trello.webelement.DeleteBoardPopup;
import trello.page.HomePage;
import trello.page.LoginPage;
import org.junit.Assert;

public class MyStepdefs {

    HomePage homePage;
    LoginPage loginPage;
    AddBoardPopup addBoardPopup;
    BoardPage boardPage;
    CloseBoardPopup closeBoardPopup;
    CloseBoardPage closeBoardPage;
    DeleteBoardPopup deleteBoardPopup;
    DeleteBoardPage deleteBoardPage;


    @Given("^I login to the application with \"([^\"]*)\" user credentials$")
    public void loginToTheApplicationWithUserCredentials(String typeUser) {
        loginPage = new LoginPage();
        homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
    }

    @When("^I create a Board with name \"([^\"]*)\"$")
    public void createABoardWithName(String boardName) {
        addBoardPopup = homePage.displayBoardPopup();
        boardPage = addBoardPopup.create(boardName);
    }

    @Then("^The application should displays a page with name board \"([^\"]*)\"$")
    public void displaysAPageWithNameBoard(String boardName) {
        String actualResult = boardPage.getSpam_boardTitle().getText();

        Assert.assertEquals(boardName, actualResult);
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

    @When("^I create a Organization with$")
    public void createAOrganizationWith() {

    }

    @Then("^The application should displays a page with name Organization \"([^\"]*)\"$")
    public void theApplicationShouldDisplaysAPageWithNameOrganization(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I delete Organization$")
    public void iDeleteOrganization() {

    }

    @Then("^I search the Organization and message \"([^\"]*)\" is displayed$")
    public void iSearchTheOrganizationAndMessageIsDisplayed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
