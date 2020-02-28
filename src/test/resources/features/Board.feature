Feature: Board

  Scenario: Create a Board
    Given I login to the application with "admin" user credentials
    When I create a Board with name "Test Board"
    Then The application should displays a page with name board "Test Board"

  Scenario: Close a Board
    Given I login to the application with "admin" user credentials
    And I create a Board with name "Test Board"
    When I close the Board "Test Board"
    Then The application should displays a message "My Board está cerrado"

  Scenario: Delete a Board
    Given I login to the application with "admin" user credentials
    And I create a Board with name "Test Board"
    When I delete Board
    Then The application should displays a message "Tablero no encontrado."
