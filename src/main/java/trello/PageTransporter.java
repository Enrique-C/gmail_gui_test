/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package trello;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Navigate on a web Page.
 *
 * @version 0.1 03 March 2020.
 *
 * @author Enrique Carrizales.
 */
public class PageTransporter {

    // Content WebDriver value.
    private static WebDriver webDriver;

    /**
     * This method is used for go to a page.
     * @param url The parameter url defines a input url.
     */
    public static void goToUrl(final String url) {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.get(url);
    }
}
