Feature: Verify update profile page

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Update user profile Information
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When update "<firstname>"
    Then Verify popup "<with update>"
    When click on update button without changing values
    Then Verify popup "<without update>"

    Examples: 
      | login success message   | firstname | with update                        | without update            |
      | Successfully logged in. | .         | User details updated successfully. | No changes has been made! |

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Enter the null values and verify the validation message
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    And Verify "<firstname>" and "<lastname>" error message

    Examples: 
      | login success message   | firstname                    | lastname                    |
      | Successfully logged in. | Please enter your first name | Please enter your last name |

  @OrganizationScreen13 @ProfileScreen
  Scenario Outline: Delete profile photo
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When delete profile photo
    Then Verify popup "<delete message>"

    Examples: 
      | login success message   | delete message                       |
      | Successfully logged in. | Profile Picture deleted successfully |

  @OrganizationScreen @ProfileScreen
  Scenario Outline: Upload profile picture and verify toast message
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When upload profile ""
    Then Verify popup "<select file>"
    When upload profile "<picture>"
    Then Verify popup "<file uploaded>"

    Examples: 
      | login success message   | select file          | file uploaded                      | picture                                                |
      | Successfully logged in. | Please select a File | Profile Picture added successfully | C:\\Desktop\\BDDFramework\\resources\\profilePhoto.png |
