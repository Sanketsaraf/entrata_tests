Feature: Schedule Demo Form

  Scenario Outline: Fill login form without submission
    Given user has navigated to entrata website
    And the user clicks on Schedule Your Demo button
    And the user lands on form page
    And the user enters "<firstname>", "<lastname>", "<email>", "<companyName>" and "<phoneNumber>"
    And the user selects "<unitCount>" from unit count dropdown
    And the user enters "<jobTitle>"
    And the user selects "<iamoption>"
    When the user scrolls down
    Then the Schedule Demo buton is displayed

    Examples: 
      | firstname | lastname | email         | companyName | phoneNumber | unitCount | jobTitle | iamoption  |
      | abc       | xyz      | abc@gmail.com | entrata     |        1111 | 1 - 10    | abcabd   | a Resident |
