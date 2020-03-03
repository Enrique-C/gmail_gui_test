/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrganizationSteps {

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
