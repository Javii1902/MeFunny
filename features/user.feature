#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: User Features

  @tag1
  Scenario: Successful Login
    Given User wants to log in
    When User clicks Account
    And User enters correct Username
    And user enters correct Password
    Then user logs in

  Scenario: UnSuccessful Login
    Given User attemps to log in
    When User clicks Account
    And User enters incorrect Username
    And user enters incorrect Password
    Then User fails to log in

  Scenario: Update Password
    Given User wants to update password
    When User is logged in
    And User clicks change password
    And User enters new password
    Then Users password gets updated

  Scenario: Create Account
    Given User wants to create a new account
    When User clicks Create Account
    And User enters username
    And User enters password
    Then new account gets created
