Feature: Property Manager Login functionality

  Scenario Outline: Validate login functionality for Invalid Property Manager credentials
    Given the user has navigated to entrata website
    And the user clicks on Sign In button
    And the user lands on entrata signIn page
    And the user clicks on property manager login button
    And the user lands on login page
    When the user enters invalid "<username>" and "<password>"
    Then the user gets invalid credentials message.

    Examples: 
      | username | password |
      | abc      | abc123   |
      | xyz      | xyz123   |
