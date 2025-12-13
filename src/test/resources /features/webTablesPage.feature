@WebTablesPage
Feature: Manage Records in Web Tables

  Scenario Outline: Add a new record and edit it
    Given User is on the Web Tables page
    When User clicks the Add button
    And User fills in the new record form with "<firstName>" "<lastName>" "<email>" <age> <salary> "<department>"
    And User submits the form with "<firstName>" "<lastName>" "<email>" <age> <salary> "<department>"
    And User edits the last added record of first name field with "<newFirstName>"
    Then User updates the data in the record with "<newFirstName>"

    Examples:
      | firstName | lastName | email             | age | salary | department | newFirstName |
      | Selin     | Solmaz   | sesol@gmail.com   | 23  | 65000  | Accounting | Selin Nur    |
      | Ahmet     | Yilmaz   | ayilmaz@gmail.com | 25  | 70000  | Accounting | Ahmet Nuri   |
