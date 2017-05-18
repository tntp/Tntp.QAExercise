package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Log;
import models.Observation;
import pageobjects.ObservationListPage;

public class ObservationRecallAction {
	public static void Execute(WebDriver driver, Observation observation) throws Exception {

		driver.navigate().refresh();
		Log.info("Going through the loop to find the ID");
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.visibilityOfAllElements(ObservationListPage.observationList));
		WebElement recall = null;
		for (int i = 1; i <= ObservationListPage.observationIds.size(); i++) {
			System.out.print("inside for loop");
			WebElement status = driver.findElement(By.xpath("//tr[" + i + "]//td[5]"));

			int value = Integer.parseInt(ObservationListPage.observationIds.get(i).getText());
			System.out.println(value);
			if (value == observation.getId()) {
				recall = driver.findElement(
						By.xpath("//tr[" + i + "]//a[contains(@title,'Unsubmit observation for editing')]"));
				break;
			}
		}
		if (recall.isDisplayed()) {
			System.out.println("Inside 2nd condtiion");
			recall.click();
		} else {
			throw new Exception("Recall icon not found!");
		}
		
		System.out.println("out of loop");
		if (ObservationListPage.dialogBox.isDisplayed()) {
			System.out.println("Inside 3rd condtiion");
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(ObservationListPage.confirmButton));
			ObservationListPage.confirmButton.click();

		Log.info("Recalled for the Observation id clicked");
		}

	}

}
