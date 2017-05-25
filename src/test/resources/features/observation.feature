Feature: Create, Update and View Observations

  Background: 
    When I open Argus
    Then I am presented with the login page

  Scenario: Observer is able to navigate to the the observation form
    Given an observer
    When that observer selects a rubric to measure the participant against
    Then that observer should be presented with a blank observation form based on that rubric

  Scenario: Observer is able to submit an observation
    Given an observer
    When that observer selects a rubric to measure the participant against
    And that observer submits the observation
    Then the user should be informed that the observation was submitted successfully
    And that user should be able to view the observation in their list of observations
   
  Scenario: Observer submits an incomplete observation
	Given an observer
	When that observer selects a rubric to measure the participant against
	And that observer attempts to submit an incomplete observation
	Then the user should be informed that the observation is incomplete submitted successfully
	And the user should be able to identify incomplete/invalid observation fields
	
  Scenario: Observer can edit submitted Observation
	Given an observer
	When that observer selects a rubric to measure the participant against
    And that observer submits the observation
	And that observer recalls the observation
	Then that observer should receive a message indicating that the observation has been recalled
	And that observer should be able to edit that observation