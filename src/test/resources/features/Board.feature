Feature: Board

  Scenario: Create a Board
#    Given I login to the application with "Admmin" user credentials
    Given I go to home page
    When I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    Then The application should displays a page with the name board
    And I close Board
    And I delete Board

  Scenario: Close a Board
#    Given I login to the application with "Admin" user credentials
    Given I go to home page
    And I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    When I close Board
    Then The application should displays a close board message "Test Board está cerrado."
    And I delete Board

  Scenario: Delete a Board
#    Given I login to the application with "Admin" user credentials
    Given I go to home page
    And I create a Board with values
      | name       | Test Board |
      | visibility | Privado    |
    When I close Board
    And I delete Board
    Then The application should displays a delete board message "Tablero no encontrado."
