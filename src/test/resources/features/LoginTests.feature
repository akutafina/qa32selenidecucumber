Feature: Login functionality feature

  Scenario: If login with invalid credentials, correct error message appears
    Given Login Page is opened
    When invalid login credentials are entered
    And Login button is clicked
    Then correct error message appears