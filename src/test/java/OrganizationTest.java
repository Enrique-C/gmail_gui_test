import core.WebDriverManager;
import gmail.AddOrganizationPopup;
import gmail.HomePage;
import gmail.LoginPage;
import gmail.OrganizationPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class OrganizationTest {

    @After
    public void afterTest() {
        WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void crateOrganization_NameTestOrganization_TestOrganization() {
        final String ORGANIZATION_NAME = "Test organizarion";
        final String ORGANIZATION_DESCRIPTION = "This is an description";

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationPage organizationPage = addOrganizationPopup.create(ORGANIZATION_NAME, ORGANIZATION_DESCRIPTION);

        String actualResult = organizationPage.getText_pageTitle();

        Assert.assertEquals(ORGANIZATION_NAME, actualResult);
    }

    @Test
    public void deleteOrganization_NameTestOrganization_TestOrganization() {
        final String ORGANIZATION_NAME = "Test organizarion";
        final String ORGANIZATION_DESCRIPTION = "This is an description";

        LoginPage loginPage = new LoginPage();
        HomePage homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");

        AddOrganizationPopup addOrganizationPopup = homePage.displayOrganizationPopup();
        OrganizationPage organizationPage = addOrganizationPopup.create(ORGANIZATION_NAME, ORGANIZATION_DESCRIPTION);
        HomePage homePage1 = organizationPage.delete();

        String actualResult = homePage1.getTextTag_organization();

        Assert.assertNotNull(actualResult);//REVIEW THIS ASSERTION AGAIN
    }
}
