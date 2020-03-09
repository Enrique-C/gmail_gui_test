/*
 *  Copyright (c) 2019 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package trello.webelement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.page.BasePage;

public abstract class BaseConfirmPopup extends BasePage {

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        webDriverWait.until(ExpectedConditions.visibilityOf(div_popup));
        webDriverWait.until(ExpectedConditions.visibilityOf(btn_accept));
    }

    @FindBy(css = ".js-confirm")
    private WebElement btn_accept;

    @FindBy(css = "div.no-back")
    private WebElement div_popup;

    protected abstract BasePage confirm();

    protected void clickOnBtnAccept() {
        btn_accept.click();
    }
}
