 Feature: Login to the application
  Scenario Outline: Login to the home page.
    Given I launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify "<login success message>"
    And close the application

    Examples: 
      | login success message   |
      | Successfully logged in. |