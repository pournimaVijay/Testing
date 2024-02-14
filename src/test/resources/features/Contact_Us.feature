@contact_us @regression
Feature: WebDriver University - Contact Us Page
  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message

  Scenario: Validate Successful submission - Specific data
    Given I access the webdriver university contact us page
    When I enter a Specific first name Pournima
    And I enter a Specific last name C
    And I enter a Specific email address pc@gmail.com
    And I enter a Specific comment "How r u?"
    And I click on the submit button
    Then I should be presented with a successful contact us submission message
