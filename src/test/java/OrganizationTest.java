import core.WebDriverManager;
import trello.PageTransporter;
import trello.entity.Organization;
import trello.webelement.AddOrganizationPopup;
import trello.page.HomePage;
import trello.page.LoginPage;
import trello.page.OrganizationPage;
import trello.webelement.OrganizationInvitePopup;
import trello.webelement.SearchPopup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OrganizationTest {
    final static String BASE_URI = "https://trello.com/es";

    @After
    public void afterTest() {
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void crateOrganization_NameTestOrganization_TestOrganization() {

        final String ORGANIZATION_NAME = "Test organizarion";
        final String ORGANIZATION_DESCRIPTION = "This is an description";

        Map<String, String> boardAttributes = new HashMap<>();
        boardAttributes.put("name", ORGANIZATION_NAME);
        boardAttributes.put("description", ORGANIZATION_DESCRIPTION);

        Organization organization = new Organization();

        organization.setOrganizationInformation(boardAttributes);

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");


        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationInvitePopup organizationInvitePopup = addOrganizationPopup.create(organization, boardAttributes.keySet());
        OrganizationPage organizationPage = organizationInvitePopup.clickOnLinkText();

        String actualResult = organizationPage.getText_pageTitle();

        Assert.assertEquals(ORGANIZATION_NAME, actualResult);

        organizationPage.delete();
    }

    @Test
    public void deleteOrganization_NameTestOrganization_TestOrganization() {
        final String ORGANIZATION_NAME = "Test organizarion";
        final String ORGANIZATION_DESCRIPTION = "This is an description";
        final String EXPECTED_MESSAGE = "No se han encontrado tarjetas ni tableros que coincidan con su búsqueda.";

        Map<String, String> organizationAttributes = new HashMap<>();
        organizationAttributes.put("name", ORGANIZATION_NAME);
        organizationAttributes.put("description", ORGANIZATION_DESCRIPTION);

        Organization organization = new Organization();

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        organization.setName(ORGANIZATION_NAME);
        organization.setDescription(ORGANIZATION_DESCRIPTION);

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationInvitePopup organizationInvitePopup = addOrganizationPopup.create(organization, organizationAttributes.keySet());
        OrganizationPage organizationPage = organizationInvitePopup.clickOnLinkText();
        HomePage homePage1 = organizationPage.delete();
        SearchPopup searchPopup = homePage1.search(ORGANIZATION_NAME);
        String actualResult = searchPopup.getMessageSearchResult();

        Assert.assertEquals(EXPECTED_MESSAGE, actualResult);
    }
}
