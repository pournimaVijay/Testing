@Login @regression
Feature:  WebDriver University - Login Page

  Background:
    Given I access the webdriver university Login Page
    When I navigate to Login Portal

  Scenario: Validate successful Login
    And I enter username webdriver
    And I enter password webdriver123
    And I click on Login button
    Then I should get successful Login message

  Scenario: Validate unsuccessful Login
    And I enter username webdriver
    And I enter password password123
    And I click on Login button
    Then I should get unsuccessful Login message

  Scenario Outline:Validate Successful and Unsuccessful Login
    When I enter a username <username>
    And I enter password <password>
    And I click on Login button
    Then I should be presented with following login validation message <loginValidationMessage>


    Examples:
      | username  | password     | loginValidationMessage |
      | webdriver | webdriver123 | validation succeeded   |
      | webdriver | password123  | validation failed      |
      | pournima  | pvc          | validation failed      |

