Feature: Board

  Scenario: Create a Board
    When I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    Then The application should display a page with the name board
    And I close Board
    And I delete Board

  Scenario: Close a Board
    Given I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    When I close Board
    Then The application should display a close board message "Test Board está cerrado."
    And I delete Board

  Scenario: Delete a Board
    Given I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    When I close Board
    And I delete Board
    Then The application should display a delete board message "Tablero no encontrado."
