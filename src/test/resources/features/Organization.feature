Feature: Organization

  Scenario: Create an Organization
    When I create a Organization with
      | name        | Test Organization     |
      | team type   | Otro                  |
      | description | This is a description |
    Then The application should display a page with the organization name
    And I delete Organization

#  Scenario: Delete an Organization
#    Given I create a Organization with
#      | name        | Test Organization     |
#      | description | This is a description |
#    When I delete Organization
#    thEN THE ORGANIZATION IS NOT DISPLAYE DIN TEAMS SECTION
#    wHEN i SEARCH FOR THE ORGAIZATION
#    Then The application should display a search message
#  "No se han encontrado tarjetas ni tableros que coincidan con su búsqueda."
