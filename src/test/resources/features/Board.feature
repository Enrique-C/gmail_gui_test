Feature: Board

  @Clean
  Scenario: Create a Board
    Given I login to the application with user credentials
    When I create a Board with name "Test Board"
    Then The application should displays a page with name board "Test Board"
    And I close Board
    And I delete Board

  @clean
  Scenario: Close a Board
    Given I login to the application with user credentials
    And I create a Board with name "Test Board"
    When I close Board
    Then The application should displays a close board message "My Board está cerrado"

  @clean
  Scenario: Delete a Board
    Given I login to the application with user credentials
    And I create a Board with name "Test Board"
    When I delete Board
    Then The application should displays a delete board message "Tablero no encontrado."
