Feature: Get all links from the Entrata homepage

  Scenario: Fetch all links, their count, and text
    Given I am on the Entrata homepage
    Then I should be able to retrieve all links and print their count and text
