Feature: Housing Data Modification
  As a administrater I want to have the ability to modify housing data

Scenario: Invalid Data Modification
Given I am logged in as an administrator
And I have navigated to the housing data management page
When I select a property to modify
And I enter invalid data for one or more fields
Then the changes are not saved and message show "invalid data entered"


Scenario: Auditing Housing Data Modifications
Given I am logged in as an administrator
And I have navigated to the housing data management page
And I have modified a property
Then I save the changes and message show "modify data successful"
