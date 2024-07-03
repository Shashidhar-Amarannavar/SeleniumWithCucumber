Feature: Verify the signUp page.

  @loginScreen @SignUp
  Scenario Outline: Create account and verify the toast message
    Given User launch the browser and hit the URL
    When user in lagin page and click on signUp
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    And click on signUp button
    Then Verify popup "<created>"
    When navigate to login page
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    And click on signUp button
    Then Verify popup "<exists>"

    Examples: 
      | emailId    | firstName | lastName | password   | confirmPassword | created                                                     | exists                              |
      | @gmail.com | Shashi    | A        | Shashi#123 | Shashi#123      | User has been created successfully.Please verify the email. | User already exists please sign in. |

  @loginScreen @SignUp1
  Scenario Outline: Entering null values to the textbox and verify error message
    Given User launch the browser and hit the URL
    When user in lagin page and click on signUp
    And enter "<emailId>","<firstName>","<lastName>","<password>", and "<confirmPassword>"
    Then enter blank values in all textbox and verify the error message

    Examples: 
      | emailId | firstName          | lastName           | password   | confirmPassword |
      | @gmail. | sixteenCharrector  | MaximumCharrector  | Shashi#123 | Shashi#12       |
      | @gmail. | sixteenCharrectors | MaximumCharrectors | Shashi     | Shashi#1234     |
