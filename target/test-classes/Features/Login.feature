@landmark
Feature: Login functionality for Landmark website

  Background: 
    Given user should be in the login page

  Scenario: Successful login with valid credentials
    When user should enter valid email and password
    And user should click in the login button
    Then users should be redirected to the dashboard page

  Scenario: Failed login with incorrect password
    When user should enter valid email and an invalid password
    And user should click on the login button
    Then user should see an error message
