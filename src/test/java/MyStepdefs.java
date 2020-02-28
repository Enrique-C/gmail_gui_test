import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @Given("^I login to the application with \"([^\"]*)\" user credentials$")
    public void iLoginToTheApplicationWithUserCredentials(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I create a Board with name \"([^\"]*)\"$")
    public void iCreateABoardWithName(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^The application should displays a page with name board \"([^\"]*)\"$")
    public void theApplicationShouldDisplaysAPageWithNameBoard(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I close the Board \"([^\"]*)\"$")
    public void iCloseTheBoard(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^The application should displays a message \"([^\"]*)\"$")
    public void theApplicationShouldDisplaysAMessage(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^I delete Board$")
    public void iDeleteBoard() {
    }
}
