Feature: Board
  
  Scenario: Create a Board
    Given I login to the application with user "Admmin" credentials
    When I create a Board with name "Test Board"
    Then The application should displays a page with name board "Test Board"
    And I close Board
    And I delete Board

  Scenario: Close a Board
    Given I login to the application with user "Admin" credentials
    And I create a Board with name "Test Board"
    When I close Board
    Then The application should displays a close board message "Test Board está cerrado."
    And I delete Board

  Scenario: Delete a Board
    Given I login to the application with user "Admin" credentials
    And I create a Board with name "Test Board"
    When I close Board
    And I delete Board
    Then The application should displays a delete board message "Tablero no encontrado."
