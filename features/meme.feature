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
Feature: Meme Features

  @tag1
  Scenario: Upload meme
    Given User wants to upload meme
    When User clicks post
    And User selects meme to upload
    Then meme gets uploaded

  Scenario: Add Caption
    Given User is uploading a meme
    When User clicks Caption
    And User enters a Caption
    Then Caption gets added to the meme

  Scenario: Like a meme
    Given User wants to like a meme
    When User clicks Like
    Then Like counter increases by one

  Scenario: DisLike a meme
    Given User wants to dislike a meme
    When User clicks disLike
    Then DisLike counter increases by one

  Scenario: Comment on a meme
    Given User wants to comment on a meme
    When User clicks comment
    And Enters a comment
    Then comment gets added to meme

  Scenario: Rate meme
    Given User wants to rate a meme
    When User clicks rate
    And User enters rating
    Then rate gets updated with new rating
