Feature: Organization

  Scenario: Create an Organization
    Given I login to the application with "admin" user credentials
    When I create a Organization with
      | name        | Test Organization     |
      | description | This is a description |
    Then The application should displays a page with name Organization "Test Organization"

  Scenario: Delete an Organization
    Given I login to the application with "admin" user credentials
    And I create a Organization with
      | name        | Test Organization     |
      | description | This is a description |
    When I delete Organization
    Then The application should displays the home page