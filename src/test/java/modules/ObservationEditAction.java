package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Log;
import models.Observation;
import pageobjects.ObservationListPage;

public class ObservationEditAction {

	public static void Execute(WebDriver driver, Observation observation) throws Exception {
		Log.info("Going through the loop to find the ID");

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfAllElements(ObservationListPage.observationList));

		for (int i = 1; i <= ObservationListPage.observationIds.size(); i++) {
			if (observation.getId() == Integer.parseInt(ObservationListPage.observationIds.get(i).getText())) {
				WebElement recall = driver.findElement(
						By.xpath("//tr[" + i + "]//a[contains(@title,'Unsubmit observation for editing')]"));
				recall.click();
				break;
			}
		}

		Log.info("Recalled for the Observation id clicked");
	}
}
