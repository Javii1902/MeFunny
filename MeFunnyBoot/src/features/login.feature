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
Feature: Login For MeFunny

  Background: 
    Given a user is on the login page for of MeFunny

  Scenario: Logging Into MeFunny With Correct Credentials
    When the User inputs the correct username
    And the user inputs the correct password
    Then the user is redirected to the home page

  Scenario: Logging Into MeFunny with Incorrect Credentials
    When the user inputs the correct username
    But the user inputs the oncorrect password
    Then the user is still on the home page of MeFunny
