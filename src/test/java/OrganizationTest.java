import core.WebDriverManager;
import trello.PageTransporter;
import trello.entity.Organization;
import trello.webelement.AddOrganizationPopup;
import trello.page.HomePage;
import trello.page.LoginPage;
import trello.page.OrganizationPage;
import trello.webelement.SearchPopup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

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

        PageTransporter.goToUrl(BASE_URI);

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        Organization organization = new Organization();
        organization.setName(ORGANIZATION_NAME);
        organization.setDescription(ORGANIZATION_DESCRIPTION);

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationPage organizationPage = addOrganizationPopup.create(organization);

        String actualResult = organizationPage.getText_pageTitle();

        Assert.assertEquals(ORGANIZATION_NAME, actualResult);

        organizationPage.delete();
    }

    @Test
    public void deleteOrganization_NameTestOrganization_TestOrganization() {
        final String ORGANIZATION_NAME = "Test organizarion";
        final String ORGANIZATION_DESCRIPTION = "This is an description";
        final String EXPECTED_MESSAGE = "No se han encontrado tarjetas ni tableros que coincidan con su búsqueda.";

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        Organization organization = new Organization();
        organization.setName(ORGANIZATION_NAME);
        organization.setDescription(ORGANIZATION_DESCRIPTION);

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationPage organizationPage = addOrganizationPopup.create(organization);
        HomePage homePage1 = organizationPage.delete();
        SearchPopup searchPopup = homePage1.search(ORGANIZATION_NAME);
        String actualResult = searchPopup.getMessageSearchResult();

        Assert.assertEquals(EXPECTED_MESSAGE, actualResult);
    }
}
