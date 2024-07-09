Feature: Verify activity page

  @ActivityScreen
  Scenario Outline: Verifying user card total hours and after click on view screenshot total hours
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "Successfully logged in."
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And click on "<user>" screenshot
    Then Verify the total hours in the user card

    Examples: 
      | login success message   | title    | organization  | user                   |
      | Successfully logged in. | Activity | Real Testing | Shashidhar Amarannavar |
