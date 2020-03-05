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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import trello.entity.Organization;
import trello.page.HomePage;
import trello.page.OrganizationPage;
import trello.webelement.AddOrganizationPopup;
import trello.webelement.OrganizationInvitePopup;
import trello.webelement.SearchPopup;

import java.util.Map;

public class OrganizationSteps {

    HomePage homePage;
    OrganizationPage organizationPage;
    OrganizationInvitePopup organizationInvitePopup;

    Organization organization;

    public OrganizationSteps(Organization organization) {
        this.organization = organization;
    }

    @When("^I create a Organization with$")
    public void createAOrganizationWith(final Map<String, String> boardAttributes) {
        homePage = new HomePage();

        organization.setOrganizationInformation(boardAttributes);

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        organizationInvitePopup = addOrganizationPopup.create(organization, boardAttributes.keySet());
        organizationPage = organizationInvitePopup.clickOnLinkText();
    }

    @Then("^The application should displays a page with the organization name$")
    public void theApplicationShouldDisplaysAPageWithNameOrganization() {
        String actualResult = organizationPage.getText_pageTitle();
        Assert.assertEquals(organization.getName(), actualResult);
    }

    @When("^I delete Organization$")
    public void iDeleteOrganization() {
        organizationPage.delete();
    }

    @Then("^I search the Organization and message \"([^\"]*)\" is displayed$")
    public void iSearchTheOrganizationAndMessageIsDisplayed(String deletionMessage) {
//        PageTransporter.goToUrl(BASE_URI);
        SearchPopup searchPopup = homePage.search(organization.getName());
        String actualResult = searchPopup.getMessageSearchResult();

        Assert.assertEquals(deletionMessage, actualResult);
    }
}
