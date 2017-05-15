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
import modules.NavigateToNewObservationAction;
import modules.ObservationCreateAction;
import pageobjects.NavigationSection;
import pageobjects.ObservationCreatePage;
import pageobjects.ObservationListPage;
import static org.testng.AssertJUnit.assertEquals;

public class ObservationStepDefs {
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
		ObservationCreateAction.Execute(driver);
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
		int createdId = ObservationCreateAction.getCreatedId();
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOfAllElements(ObservationListPage.observationIds)
			); 
		for (WebElement opt : ObservationListPage.observationIds) {
            if (Integer.parseInt(opt.getText()) == createdId) {
                return;
            }
		}
		
		throw new Exception("Unable to find created ID");	
	}

}