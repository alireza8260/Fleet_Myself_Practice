
Feature: Access to vehicle contract

  Background: User is already in login page
    Given the user is on the login page

  Scenario Outline: Verify Store managers and Sales managers can access the Vehicle Contracts page
    Given the user logged in asa Store or Sales manager "<userType>"
    When the user navigates to the Vehicle Contracts page
    Then the user should be redirected to the URL "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
    Examples:
      | userType      |
      | sales_manager |
      | store_manager |

  Scenario: Verify Drivers cannot access the Vehicle Contracts page
    Given the user is logged into the application as driver
    When the user attempts to navigate to the Vehicle Contracts page
    Then the user should see the message "You do not have permission to perform this action."
