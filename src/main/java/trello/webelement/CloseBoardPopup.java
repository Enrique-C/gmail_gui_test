package trello.webelement;

import trello.page.CloseBoardPage;

public class CloseBoardPopup extends BaseConfirmPopup {

    public CloseBoardPage confirm() {
        this.clickOnBtnAccept();
        return new CloseBoardPage();
    }
}
