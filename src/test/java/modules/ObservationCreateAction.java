package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import helpers.Log;
import models.Observation;
import pageobjects.ObservationCreatePage;

public class ObservationCreateAction {

	public static void Execute(WebDriver driver, Observation observation) throws Exception{
		
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.visibilityOf(ObservationCreatePage.form)
			);
		
		ObservationCreatePage.clickParticipantName.click();
		
		Log.info("Succesfully clicked on Participant Name Select field");
		
        for (WebElement opt : ObservationCreatePage.participantNames) {
            if (opt.getText().equals(observation.getParticipantName())) {
                opt.click();
                break;
            }
        }
		Log.info("Cobservationr succesfully selects Participant Name");
		
		ObservationCreatePage.clickDate.click();
		
		Log.info("Succesfully clicked on Date picker to Select date");
		
		for(WebElement ele:ObservationCreatePage.dates)
		{
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(observation.getDate()))
			{
				ele.click();
				break;
			}
			
		}
		Log.info("observationr sucesfully seect the date");
		
		ObservationCreatePage.clickRating.click();
		
		Log.info("Succesfully clicked on Rating Select field");
		
		for (WebElement opt : ObservationCreatePage.rating) {
            if (opt.getText().equals(observation.getRating())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected Rating");
        
        ObservationCreatePage.clickRound.click();
		
		Log.info("Succesfully clicked on Percentage Select field");
        
		for (WebElement opt : ObservationCreatePage.round) {
            if (opt.getText().equals(observation.getRound())) {
                opt.click();
                break;
            }
        }
        
        ObservationCreatePage.clickRole.click();
		
		Log.info("Succesfully clicked on Participant Role Select field");
        
		for (WebElement opt : ObservationCreatePage.role) {
            if (opt.getText().equals(observation.getRole())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected Role");
        
        ObservationCreatePage.clickPercentage.click();
		
		Log.info("Succesfully clicked on Percentage Select field");
        
		for (WebElement opt : ObservationCreatePage.percentage) {
            if (opt.getText().equals(observation.getPercentage())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected Percentage");
        
        ObservationCreatePage.clickFraming.click();
		
		Log.info("Succesfully clicked on Framing Select field");
        
		for (WebElement opt : ObservationCreatePage.framing) {
            if (opt.getText().equals(observation.getFraming())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected Framing");
        
        ObservationCreatePage.clickVoice.click();
		
		Log.info("Succesfully clicked on Voice Select field");
        
		for (WebElement opt : ObservationCreatePage.voice) {
            if (opt.getText().equals(observation.getVoice())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected Percentage");
        
        ObservationCreatePage.clickWhatTodDo.click();
		
		Log.info("Succesfully clicked on What to do Select field");
        
		for (WebElement opt : ObservationCreatePage.whatToDo) {
            if (opt.getText().equals(observation.getWhatToDo())) {
                opt.click();
                break;
            }
        }
        Log.info("Succesfully selected What to do");
        
        ObservationCreatePage.clickEfficiency.click();
		
		Log.info("Succesfully clicked on Efficiency Select field");
        
		for (WebElement opt : ObservationCreatePage.efficiency) {
            if (opt.getText().equals(observation.getEfficiency())) {
                opt.click();
                break;
            }
        }     
        Log.info("Succesfully selected Efficiency");
        
        observation.setId(Integer.parseInt(driver.getCurrentUrl().replaceAll("\\D+","")));

        ObservationCreatePage.btnSubmit.click();
        Log.info("Succesfully clicked Submit Button");

		Reporter.log("ObservationCreate form is submitted");
	}
}
