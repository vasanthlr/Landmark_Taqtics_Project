@swagger
Feature: Test /generateAuthToken API

  Scenario Outline: Validate /generateAuthToken API for various cases
    Given I set the base URL as "<base_url>"
    And I set the request endpoint as "/generateAuthToken"
    And I set the request body with "<username>" and "<password>"
    When I send a POST request
    Then I expect the response status to be "<expected_status>"
    And I validate the response message contains "<expected_message>"

    Examples: 
      | base_url                             | username          | password        | expected_status | expected_message     |
      | https://landmark.taqtics.co/api-docs | intern@taqtics.co | TestIntern@123  |             403 | Unauthorized         |
      | https://landmark.taqtics.co/api-docs | admin@taqtics.co  | ValidAdminPass  |             200 | Token generated      |
      | https://landmark.taqtics.co/api-docs | intern@taqtics.co | InvalidPassword |             401 | Invalid credentials  |
      | https://landmark.taqtics.co/api-docs |                   | TestIntern@123  |             400 | Username is required |
      | https://landmark.taqtics.co/api-docs | intern@taqtics.co |                 |             400 | Password is required |
