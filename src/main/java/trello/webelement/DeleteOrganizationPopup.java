package trello.webelement;

import trello.page.HomePage;

public class DeleteOrganizationPopup extends BaseConfirmPopup{

    public HomePage confirm() {
        this.clickOnBtnAccept();
        return new HomePage();
    }
}
