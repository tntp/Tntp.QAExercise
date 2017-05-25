package step_definitions;

import modules.SignInAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import pageobjects.LoginPage;

public class LoginStepDefs {
	public WebDriver driver;

	public LoginStepDefs() {
		driver = Hooks.driver;

	}
	
	@Given("^an observer$")
	public void observer_logged_in() throws Throwable {
		PageFactory.initElements(driver, LoginPage.class);
		SignInAction.Execute(driver);
	}	
}