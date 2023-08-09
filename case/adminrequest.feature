Feature: Housing Advertisement Requests

  Scenario: Accepting a housing advertisement request
    Given the system administrator is logged in
    When the system administrator navigates to the requests page
    And clicks on the accept button
    And the system updates the status of the request to "Accepted"

  Scenario: Rejecting a housing advertisement request
    Given the system administrator is logged in
    When the system administrator navigates to the requests page
    And clicks on the reject button
    And  system updates the status of the request to "Rejected"