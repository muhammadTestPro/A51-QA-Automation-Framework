Feature: Login feature

  #This wont get executed/ This is a comment.
  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I should get logged in

  Scenario Outline: Login Incorrect Password
    Given I open Login Page
    When I enter email "<email>"
    And I enter password "<password>"
    And I submit
    Then I should get logged in

    Examples:
      | email                | password          |
      | demo@class.com       | te$t$tudent       |
      | demmo@class.com      | te$t$tudent       |
      | demo@class.com       | test$tudent       |
      | demo@class.com       |                   |