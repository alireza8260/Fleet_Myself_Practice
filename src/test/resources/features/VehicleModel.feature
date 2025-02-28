Feature: Vehicles Model page columns verification

  Background:

  Scenario Outline: Verify Store managers and Sales managers can see 10 columns on the Vehicles Model page
    Given the user logged in asa Store or Sales manager "<userType>"
    When the user navigates to the Vehicles Model page
    Then the user should see the following columns:

      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |
    Examples:
      | userType      |
      | sales_manager |
      | store_manager |


  Scenario: Verify Store managers and Sales managers can access the Vehicle Contracts page
    Given the user is logged into the application as a Store manager or Sales manager
    When the user navigates to the Vehicle Contracts page
    Then the user should be redirected to the URL "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"

  Scenario: Verify Drivers cannot access the Vehicle Contracts page
    Given the user is logged into the application as a Driver
    When the user attempts to navigate to the Vehicle Contracts page
    Then the user should see the message "You do not have permission to perform this action."
