/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.runner;

import core.WebDriverManager;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import trello.PageTransporter;
import trello.page.LoginPage;
import trello.report.Report;


public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeExecution() {
        final String BASE_URI = "https://trello.com/es";

        PageTransporter.goToUrl(BASE_URI);
        LoginPage loginPage = new LoginPage();
        loginPage.login("enrique.carrizales@outlook.es", "e7999812CH");
    }

    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().quitDriver();
        Report.getInstance().generateReport();
    }
}
