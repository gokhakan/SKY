Feature: This feature will make sure that the shop page is navigable and usable.
@wip
  Scenario: User navigates to shop page
    Given I am on the home page
    When I navigate to "Deals"
    Then the user should be on the "deals" page