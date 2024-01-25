Feature: User Login

  Scenario: Successfull Login
    Given the user is on the Login page
    When the user enters valid credentials(username: "Admin", password: "admin123")
    And the user clicks on the Login button
    Then the user should be redirected to Dashboard page 
    And the user should see a welcome message

    
    Scenario: UnSuccessfull Login
    Given the user is on Login page
    When the user enters invalid credentials(username: "Admins",password: "admin")
    And the user clicks on login button
    Then the user should not be displayed dashboard page