@trends
Feature: As a user,I should be able to compare two elements in trends.google

  Scenario: User should be able compare "Selenium WebDriver" and "Javascript WebDriverIO" from compare page.
    Given user is on the main page
    When  user enter "Selenium WebDriver" on search box
    Then  user navigates to explore page
    And   user enter "Javascript WebDriverIO" to the +Compare field
    Then  user navigates to compare page
    And   user select filters
    And   user select compare by metro
    Then  user verify percentual ratio