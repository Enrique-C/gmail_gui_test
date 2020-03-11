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

import cucumber.api.java.en.Given;
import trello.PageTransporter;
import trello.page.HomePage;
import trello.page.LoginPage;

public class LoginSteps {

    final static String BASE_URI = "https://trello.com/es";

    HomePage homePage;
    LoginPage loginPage;

    @Given("^I login to the application with \"([^\"]*)\" user credentials$")
    public void loginToTheApplicationWithUserCredentials(String typeUser) {
        PageTransporter.goToUrl(BASE_URI);
        loginPage = new LoginPage();
        homePage = loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
    }
}
