Feature: Verify invite member page

  @InviteMembersScreen
  Scenario Outline: Sent invitation to members and verify toast message
    Sent invitation to existing mailId and verify toast message

    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "Successfully logged in."
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And invite user with "<emailId>" and "<role>"
    Then Verify popup "<toast message>"

    Examples: 
      | login success message   | toast message                                                     | title          | organization | emailId       | role |
      | Successfully logged in. | Invitation Sent Successfully                                      | Invite Members | Real Testing | abc@gmail.com | User |
      | Successfully logged in. | Invitation is already sent to the User or user is already present | Invite Members | Real Testing | abc@gmail.com | User |

  @InviteMembersScreen
  Scenario Outline: Resend the invitation
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "Successfully logged in."
    When Switch to other "<organization>"
    And select the "<title>" in the leftside menubar
    And resend the invitation "<emailId>"
    Then Verify popup "<toast message>"

    Examples: 
      | login success message   | toast message                | title          | organization | emailId       |
      | Successfully logged in. | Invitation Sent Successfully | Invite Members | Real Testing | abc@gmail.com |
