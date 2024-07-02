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
      | email                                 | password    | message                        |
      | shashidhar.amarannavar@softsuave.org  | Shashi#123  | Successfully logged in.        |
      | shashidhar.amarannavar@softsuave.org  | Shashi#1231 | Wrong password entered.        |
      | shashidhar.amarannavar1@softsuave.org | Shashi#123  | No user found. Please sign up. |
      | shashidhar.amarannavar1@softsuave.org | Shashi#1231 | No user found. Please sign up. |

  @loginScreen @validationEmailAndPassword
  Scenario Outline: Verify the email and password textbox validation message
    Given User launch the browser and hit the URL
    When user enter the wrong "<email>" and "<password>"
    Then Verify the textfield validation "<message>"

    Examples: 
      | email                  | password  | message                            |
      | shashidhar.amarannavar |           | Please enter a valid email address |
      |                        | Shashi#12 | Please enter your password         |
      |                        |           | Please enter your email            |
