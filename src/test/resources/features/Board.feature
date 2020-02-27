Feature: Board

  Scenario: Create a Board
    Given I login to the application with "admin" user credentials
    When I create a Board witn name "Test Board"
    Then The application displays a page with name board "Test Board"

  Scenario: Create a Board
    Given I login to the application with "admin" user credentials
    And I have an organization with name "admin org12"
    When I create a Board with name "Test Board"
    And I add the organization to the Board

    And I make the Board public
    Then The application displays a page with name board "Test Board"
    And the organization should be displayed in the Board page
    And the Board should be public in Board page
