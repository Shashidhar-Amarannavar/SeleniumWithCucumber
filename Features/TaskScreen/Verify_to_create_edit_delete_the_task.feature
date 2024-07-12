Feature: Verify the tasks screen

  @TasksScreen
  Scenario Outline: Create new tasks if currect organization should have projects.
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And create new "<task>"
    Then Verify popup "<success message>"  

    Examples: 
      | login success message   | success message                    | title | organization | task     |
      | Successfully logged in. | Task has been created sucessfully. | Tasks | Real Testing | New task |

  @TasksScreen
  Scenario Outline: Edit the task and validate task name textbox.
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And edit the "<task>" and verify "<validation>"
    Then Verify popup "<success message>"   

    Examples: 
      | login success message   | success message                    | title | organization | task     | validation            |
      | Successfully logged in. | This task was successfully edited. | Tasks | Real Testing | New task | Task Name is required |

  @TasksScreen
  Scenario Outline: Delete the task.
    Given User launch the browser and hit the URL
    When user is in login page and enter the email and password
    Then Verify popup "<login success message>"
    When Switch to other "<organization>"
    When select the "<title>" in the leftside menubar
    And delete the "<task>"
    Then Verify popup "<success message>"

    Examples: 
      | login success message   | success message               | title | organization | task     |
      | Successfully logged in. | Task was successfully deleted | Tasks | Real Testing | New task |
