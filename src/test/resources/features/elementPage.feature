@ElementPage
Feature: Click "Click Me" button

  Scenario: User clicks the Click Me
    Given User is on the page
    When User clicks the Buttons button
    When User clicks the Click Me button
    Then User sees a button message
