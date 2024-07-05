Feature: Verify the forgot password.

  @loginScreen
  Scenario Outline: Enter the wrong email and verify validation message
    Given User launch the browser and hit the URL
    When user in login page and click forgot password and enter "<incorrect email>"
    Then Verify the email "<validation message>"

    Examples: 
      | incorrect email        | validation message                 |
      | shashidhar.amarannavar | Please enter a valid email address |

  @loginScreen
  Scenario Outline: Enter the unknown user email and verify the popup
    Given User launch the browser and hit the URL
    When user in login page and click forgot password and enter "<unknown email>"
    When click on reset password
    Then Verify popup "<message>"

    Examples: 
      | unknown email         | message           |
      | unknownMail@gmail.com | No User was found |
