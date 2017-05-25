package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import models.Observation;

public class ObservationListPage extends BaseClass {

	public ObservationListPage(WebDriver driver) {
		super(driver);
	}

	@FindBys({ @FindBy(how = How.ID, using = "obs-list") })
	public static List<WebElement> observationList;

	@FindBys({ @FindBy(how = How.XPATH, using = "(//*[@id='obs-list']//tr/td[2])") })
	public static List<WebElement> observationIds;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Recalled')]")
	public static WebElement popUpRecalled;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	public static WebElement confirmButton;

	@FindBy(how = How.XPATH, using = "//div[@role='dialog']")
	public static WebElement dialogBox;



}
