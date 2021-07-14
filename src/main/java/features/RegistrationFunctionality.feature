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

Feature: Registration functionality
As a new user, I should be able to register after providing required information 
to use the application.

@EndToEnd, @Regression
Scenario: Positive registration functionality by clicking submit button
	Given user is at registration page
	When user provides firstName, lastName, phone number, email address, address, city, state, postal code, country, userName, password and confirm password
	And user clicks submit button
	Then user should be registered
	
@EndToEnd, @Regression	
Scenario: Positive registration functionality by hitting enter tab
	Given user is at registration page
	When user provides firstName, lastName, phone number, email address, address, city, state, postal code, country, userName, password and confirm password
	And user hits enter tab
	Then user should be registered	
