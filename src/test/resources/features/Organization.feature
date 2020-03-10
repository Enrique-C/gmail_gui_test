Feature: Organization

  Scenario: Create an Organization
#    Given I login to the application with "admin" user credentials
    When I create a Organization with
      | name        | Test Organization     |
      | team type   | Otro                  |
      | description | This is a description |
    Then The application should displays a page with the organization name
    And I delete Organization

#  Scenario: Delete an Organization
#    Given I login to the application with "admin" user credentials
#    And I create a Organization with
#      | name        | Test Organization     |
#      | description | This is a description |
#    When I delete Organization
#    Then I search the Organization and message "No se han encontrado tarjetas ni tableros que coincidan con su búsqueda." is displayed