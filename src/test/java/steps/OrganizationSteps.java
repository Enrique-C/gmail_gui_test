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

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import trello.PageTransporter;
import trello.entity.Board;
import trello.entity.Organization;
import trello.page.HomePage;
import trello.page.LoginPage;
import trello.page.OrganizationPage;
import trello.webelement.AddOrganizationPopup;
import trello.webelement.SearchPopup;

import java.util.Map;

public class OrganizationSteps {

    final static String BASE_URI = "https://trello.com/es";

    LoginPage loginPage;
    HomePage homePage;
    OrganizationPage organizationPage;

    Organization organization;

    public OrganizationSteps(Organization organization, LoginPage loginPage, HomePage homePage) {
        this.organization = organization;
        this.loginPage = loginPage;
        this.homePage = homePage;
    }

    @When("^I create a Organization with$")
    public void createAOrganizationWith(DataTable boardTable) {
        Map<String, String> organizationDictionary = boardTable.asMap(String.class, String.class);

        organization.setName(organizationDictionary.get("name"));
        organization.setDescription(organizationDictionary.get("description"));

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        organizationPage = addOrganizationPopup.create(organization);
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
        PageTransporter.goToUrl(BASE_URI);
        SearchPopup searchPopup = homePage.search(organization.getName());
        String actualResult = searchPopup.getMessageSearchResult();

        Assert.assertEquals(deletionMessage, actualResult);
    }
}
