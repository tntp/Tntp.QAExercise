package modules;

import helpers.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;

import pageobjects.NavigationSection;

public class NavigateToNewObservationAction {

	public static void Execute(WebDriver driver) throws Exception{

		new WebDriverWait(driver, 10).until(
			ExpectedConditions.elementToBeClickable(NavigationSection.menu)
		).click();
		Log.info("Toggle the menu");
		
		new WebDriverWait(driver, 10).until(
			ExpectedConditions.elementToBeClickable(NavigationSection.menuObservation)
		).click();
		Log.info("Toggle Observation sub-menu");

		NavigationSection.menuNewObservation.click();
		Log.info("Click action is performed on New Observation link");

		Reporter.log("ObservationCreate Action is successfully perfomred");
	}
}
