Feature: Entrata Website Footer Links

  Scenario: Validate footer links
    Given I scroll to the footer of the homepage
    When I click on the Privacy Policy link
    Then I should be navigated to the Privacy Policy page
