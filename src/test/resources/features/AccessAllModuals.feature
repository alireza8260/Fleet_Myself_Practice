
Feature: Accessing main modules of the app

  Background: User is already in login Page
    Given the user is on the login page

  Scenario Outline: Store and Sales managers see 8 module names
    Given the user logged in asa Store or Sales manager "<userType>"
    When the user views the main menu
    Then the user should see Eight module names
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |
    Examples:
      | userType      |
      | sales_manager |
      | store_manager |

  Scenario Outline: Drivers see 4 module names
    Given the user logged in as a driver "<userType>"
    When the user views the main menu
    Then the user should see Four module names
      | Fleet       |
      | Customers   |
      | Activities  |
      | System      |
    Examples:
      | userType |
      | driver   |
