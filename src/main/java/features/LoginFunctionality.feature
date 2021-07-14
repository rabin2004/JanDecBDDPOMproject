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

Feature: Login Functionality
Registered user should be able to login with this functionality after providing valid credentials

@EndToEnd, @Regression
Scenario: Positive login functionality test by click submit button
	Given registered user is in homepage
	When user provides valid username and valid password
	And user clicks on submit button
	Then user should be able to login and see login success message

@EndToEnd, @Regression	
Scenario: Positive login functionality test by hitting enter
	Given registered user is in homepage
	When user provides valid username and valid password
	And user hits enter button from keypad
	Then user should be able to login and see login success message	

@EndToEnd, @Regression	
Scenario: Negative login functionality test with invalid username but valid password clicking submit button
	Given registered user is in homepage
	When user provides invalid username and valid password
	And user clicks on submit button
	Then user should not be able to login and should see error message

@EndToEnd, @Regression	
Scenario: Negative login functionality test with invalid username but valid password hitting enter
	Given registered user is in homepage
	When user provides invalid username and valid password
	And user hits enter button from keypad
	Then user should not be able to login and should see error message

# Data Driven Testing in Cucumber	

Scenario: Positive login functionality test Data driven1
	Given registered user is in homepage
	When user provides valid credentials username "test" and password "123"
	And user clicks on submit button
	Then user should be able to login and see login success message	

Scenario: Positive login functionality test Data driven2
	Given registered user is in homepage
	When user provides valid credentials
	| username | password |
	| test123  | 123			|
	| test		 | 123			|
	And user clicks on submit button
	Then user should be able to login and see login success message		


Scenario Outline: Positive login functionality test Data driven3
	Given registered user is in homepage
	When user provides valid credentials <ValidUsername> <ValidPassword>
	And user clicks on submit button
	Then user should be able to login and see login success message		
	
Examples:
	| ValidUsername | ValidPassword |
	| test123  			| 123						|
	| test					| 123						|
	| tom123				| 123						|		
	
	
@DataDriven	
Scenario Outline: Positive login functionality test Data driven3
	Given registered user is in homepage
	When user provides valid credentials "<Username>" "<Password>"
	And user clicks on submit button
	Then user should be able to login and see login success message		
	
Examples:
	|	Username 			| Password 			|
	| test123  			| 123						|
	| test					| 123						|
	| tom123				| 123						|


	
	
	
## Assignment 1 -> Features mentioned in framework assignment -> Write those test cases in gherkin language creating feature file
## Assignment	2 -> Convert the feature files into automation script (Multiple feature file and multiple scenarios)
## Assignment 3 -> Optimize automation script/framework => Main class, Hooks class, Runner class (features, glue, monochrome, plugins, tags)
## Assignment 4 -> creating BDD POM framework, achieve complete testing of an application (Mercury Tours) <- Past assignment TDD POM framework
	
	
	
	
	
	
	
	
	
	
	
	