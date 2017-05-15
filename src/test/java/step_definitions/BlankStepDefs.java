package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BlankStepDefs{
    public WebDriver driver;
    
    public BlankStepDefs()
    {
    	driver = Hooks.driver;
    }
    
	@When("^I open Argus$")
	public void i_open_argus() throws Throwable {
		driver.get("https://beta.argusobservations.com/#/");
	}

	@Then("^I am presented with the login page$")
	public void validate_title() throws Throwable {
		assertEquals("Argus Observations", driver.getTitle());
		assertEquals("https://beta.argusobservations.com/#/", driver.getCurrentUrl());
	}
    
}