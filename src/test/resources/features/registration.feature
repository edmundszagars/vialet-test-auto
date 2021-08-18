@register
Feature: User registration first step

  Scenario: User enters valid data in registration first form page
    Given user is in registration page
    And prepare ID pop-up is displayed
    And users fills in first form with "VALID" data
    Then no errors should be displayed for inputs

  Scenario: User enters invalid data in registration first form page
    Given user is in registration page
    And prepare ID pop-up is displayed
    And users fills in first form with "INVALID" data
    Then errors should be displayed for all inputs

  Scenario: User enters valid data in registration first form page (FAILS ON PURPOSE TO SHOW SCREENSHOT FUNCTIONALITY)
    Given user is in registration page
    And prepare ID pop-up is displayed
    And users fills in first form with "VALID" data
    Then errors should be displayed for all inputs