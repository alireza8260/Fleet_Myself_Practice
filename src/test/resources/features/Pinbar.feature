@pinbar
Feature: Learn how to use the pinbar

  Background: User is already in login page
    Given the user is on the login page


  Scenario Outline: Verify the "Learn how to use this space" link displays pinbar instructions
    Given the user logged in asa Store or Sales manager "<userType>"
    When the user clicks on the "Learn how to use this space" link
    Then the user should see the text "How To Use Pinbar"
    And the user also should see the text "Use pin icon on the right top corner of page to create fast access link in the pinbar."
    And the user should see an image with the source "/bundles/oronavigation/images/pinbar-location.jpg"
    Examples:
      | userType      |
      | driver        |
      | sales_manager |
      | store_manager |
