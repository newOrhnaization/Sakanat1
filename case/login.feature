Feature: User login
  I want to login to Sakankom

  Scenario: Login with Empty field
    Given I click on loginchoose and flag is 'true'
    And the user leaves  field '' empty
    And clicks on the "Login" button
    Then the user should see an error message indicating "Username or password is empty"

  Scenario: Successful Login
    Given I click on loginchoose and flag is 'true'
    And he fills in 'username' with 'raiaishtayeh'
    And he fills in 'password' with '123456'
    And clicks on the "Login" button
    Then show  the massage 'Login  has been successfule'

  Scenario: Login with Incorrect field
    Given I click on loginchoose and flag is 'true'
    And he fills in 'username' with the 'raiaishtayeh'
    And he fills in 'password' with the '123456'
    And clicks on the "Login" button
    Then the user should see an error message indicating "Invalid username or password"
