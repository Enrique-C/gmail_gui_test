package trello.webelement;

import trello.page.DeleteBoardPage;

public class DeleteBoardPopup extends BaseConfirmPopup {

    public DeleteBoardPage confirm() {
        this.clickOnBtnAccept();
        return new DeleteBoardPage();
    }
}
