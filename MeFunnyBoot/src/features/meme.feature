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

Feature: Upload a new meme

  
  Scenario: upload a new meme
    Given User wants to upload a new meme
    When User clicks upload meme
    Then User choose meme to upload
    And The meme gets uploaded
    
  Scenario: Comment on a meme
  	Given  user wants to comment on a meme
  	When User types a comment
  	And User clicks on comment
  	Then comment gets added to meme
  	
  Scenario: Caption a Photo
  	Given User wants to caption a meme
  	When User types a caption
  	And Clicks add caption
  	Then Caption gets added to meme
  	
  	Scenario: Like a meme
  		Given User wants to like a meme
  		When User clicks Like
  		Then Like counter increases by 1
  	
  	Scenario: Dislike a meme
  		Given User wants to dislike a meme
  		When User clicks Dislike
  		Then Dislike counter decreases by 1
  		
  		