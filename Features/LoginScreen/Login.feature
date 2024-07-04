Feature: Login to the application

  @loginScreen
  Scenario: Login to the home page.
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "Successfully logged in."

  @loginScreen
  Scenario Outline: Login to the application
    Given User launch the browser and hit the URL
    When user enter the "<email>" and "<password>"
    Then Verify popup "<message>"

    Examples: 
      | email                        | password     | message                        |
      | shashi.amarannavar@soft.org  | valid#123    | Successfully logged in.        |
      | shashi.amarannavar@soft.org  | invalid#1231 | Wrong password entered.        |
      | shashi.amarannavar1@soft.org | valid#123    | No user found. Please sign up. |
      | shashi.amarannavar1@soft.org | invalid#1231 | No user found. Please sign up. |

  @loginScreen @validationEmailAndPassword
  Scenario Outline: Verify the email and password textbox validation message
    Given User launch the browser and hit the URL
    When user enter the wrong "<email>" and "<password>"
    Then Verify the textfield validation "<message>"

    Examples: 
      | email              | password   | message                            |
      | shashi.amarannavar |            | Please enter a valid email address |
      |                    | invalid#12 | Please enter your password         |
      |                    |            | Please enter your email            |
