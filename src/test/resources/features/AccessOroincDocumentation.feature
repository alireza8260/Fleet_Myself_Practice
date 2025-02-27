Feature: Access Oroinc Documentation page
Background: User is already in login page
  Given the user is on the login page

  Scenario: Verify access to Oroinc Documentation page via question mark icon
    Given the user is logged into the application as driver
    When the user clicks on the question mark icon
    Then the user should be redirected to the Oroinc Documentation page in a new window
    And the title of the new window should contain "Oro Documentation"