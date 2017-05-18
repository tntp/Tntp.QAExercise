package step_definitions;

import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Log;
import models.Observation;
import modules.NavigateToNewObservationAction;
import modules.ObservationCreateAction;
import modules.ObservationEditAction;
import modules.ObservationRecallAction;
import pageobjects.NavigationSection;
import pageobjects.ObservationCreatePage;
import pageobjects.ObservationListPage;

public class ObservationStepDefs {
	
	private Observation observation;
	
	public WebDriver driver; 

	public ObservationStepDefs() {
		driver = Hooks.driver;
	}
	
	@When("^that observer selects a rubric to measure the participant against$")
	public void navigate_to_create_observation_page() throws Throwable {
		PageFactory.initElements(driver, NavigationSection.class);
		NavigateToNewObservationAction.Execute(driver);
	}

	@Then("^that observer should be presented with a blank observation form based on that rubric$")
	public void assert_new_observation_form() throws Throwable {
		PageFactory.initElements(driver, ObservationCreatePage.class);
		boolean isDisplayed = new WebDriverWait(driver, 10).until(
			ExpectedConditions.visibilityOf(ObservationCreatePage.form)
		).isDisplayed();

		assertTrue(isDisplayed);
	}
	
	@And("^that observer submits the observation$")
	public void submit_new_observation() throws Throwable {
		PageFactory.initElements(driver, ObservationCreatePage.class);
		
		observation = new Observation();
		observation.setParticipantName("TestQA ParticipantOne");
		observation.setDate("15");
		observation.setRating("Formal");
		observation.setRound("Round 2");
		observation.setRole("Coach");
		observation.setPercentage("Coach");
		observation.setFraming("3 - Developing");
		observation.setVoice("3 - Developing");
		observation.setWhatToDo("3 - Developing");
		observation.setEfficiency("3 - Developing");
		
		ObservationCreateAction.Execute(driver, observation);
	}
	
	@Then("^the user should be informed that the observation was submitted successfully$")
	public void confirm_new_observation() throws Throwable {
		PageFactory.initElements(driver, ObservationCreatePage.class);
        new WebDriverWait(driver, 10).until(
				ExpectedConditions.elementToBeClickable(ObservationCreatePage.btnConfirmation)
			);      
        
        Log.info("Succesfully clicked Confirmation Button");
		Reporter.log("ObservationCreate Action is successfully perfomred");
	}
	
	@And("^that user should be able to view the observation in their list of observations$")
	public void view_new_observation_in_their_list_of_observations() throws Throwable {
		PageFactory.initElements(driver, ObservationListPage.class);
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOfAllElements(ObservationListPage.observationList)
			); 
		for (WebElement opt : ObservationListPage.observationIds) {			
            if (Integer.parseInt(opt.getText()) == observation.getId()) {
                break;
            }
            else {
            	throw new Exception("Unable to find created ID");
            }
		}	
	}
	
	@And("^that observer attempts to submit an incomplete observation$")
	public void that_observer_attempts_to_submit_an_incomplete_observation() throws Throwable {
		PageFactory.initElements(driver, ObservationCreatePage.class);
		
		observation = new Observation();
		observation.setParticipantName("");
		observation.setRating("Formal");
		observation.setRole("Coach");
		observation.setEfficiency("31 - Developing");
		
		ObservationCreateAction.Execute(driver, observation);
	}

	@Then("^the user should be informed that the observation is incomplete submitted successfully$")
	public void the_user_should_be_informed_that_the_observation_is_incomplete_submitted_successfully() throws Throwable {
		PageFactory.initElements(driver, ObservationCreatePage.class);
		if(!ObservationCreatePage.btnSubmit.isDisplayed()) {
			new WebDriverWait(driver, 10).until(
					ExpectedConditions.visibilityOfAllElements(ObservationCreatePage.reqMsgList)
				);
			if(ObservationCreatePage.reqMsgParticipant.isDisplayed() || ObservationCreatePage.reqMsgDates.isDisplayed() || ObservationCreatePage.reqMsgRound.isDisplayed() || ObservationCreatePage.reqMsgRole.isDisplayed()) {
				throw new Exception("Observation is not successfully submitted due to incorrect input");
			}
		}
	}

	@Then("^the user should be able to identify incomplete/invalid observation fields$")
	public void the_user_should_be_able_to_identify_incomplete_invalid_observation_fields() throws Throwable {
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(ObservationCreatePage.reqMsgParticipant)
			);
		if(ObservationCreatePage.reqMsgParticipant.isDisplayed()) {
			throw new Exception("Field Participant Name has invalid data");
		}
		else if(ObservationCreatePage.reqMsgDates.isDisplayed()) {
			throw new Exception("Field Dates has invalid data");
		}
		else if(ObservationCreatePage.reqMsgRound.isDisplayed()) {
			throw new Exception("Field Round has invalid data");
		}
		else if(ObservationCreatePage.reqMsgRole.isDisplayed()) {
			throw new Exception("Field Role has invalid data");
		}

	}

	@And("^that observer recalls the observation$")
	public void that_observer_recalls_the_observation() throws Throwable {
		PageFactory.initElements(driver, ObservationListPage.class);
		ObservationRecallAction.Execute(driver, observation);
	}

	@Then("^that observer should receive a message indicating that the observation has been recalled$")
	public void that_observer_should_receive_a_message_indicating_that_the_observation_has_been_recalled() throws Throwable {
		PageFactory.initElements(driver, ObservationListPage.class);
		boolean isDisplayed = new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(ObservationListPage.popUpRecalled)
			).isDisplayed();

			assertTrue(isDisplayed);
			Log.info("Observation Recalled");
	}

	@And("^that observer should be able to edit that observation$")
	public void that_observer_should_be_able_to_edit_that_observation() throws Throwable {
		Log.info("Edit Observation");
		ObservationEditAction.Execute(driver, observation);
		PageFactory.initElements(driver, ObservationCreatePage.class);
		
		observation = new Observation();
		observation.setParticipantName("TestQA Participant2");
		observation.setRating("Informal");
		observation.setRound("Round 5");
		observation.setRole("Instructor");
		observation.setPercentage("Coach");
		observation.setFraming("Ineffective");
		observation.setEfficiency("Ineffective");
		
		ObservationCreateAction.Execute(driver, observation);

		Reporter.log("Observation is succesfully Edited");
	}
	

}