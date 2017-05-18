package pageobjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
public class ObservationCreatePage extends BaseClass{

	public ObservationCreatePage(WebDriver driver){
		super(driver);
	}   
	
	@FindBy(how=How.ID, using=".//button[contains(text(),'Create observation')]")
	public static WebElement btnCreateObservation;	
	
	@FindBy(how=How.ID, using="observationForm")
	public static WebElement form;	
	
	@FindBy(how=How.XPATH, using="//*[@id='participantName_chosen']/a")
	public static WebElement clickParticipantName;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='participantName_chosen']//li")})
	public static List<WebElement> participantNames;
	
	@FindBy(how=How.XPATH, using="//*[@id='participantName_chosen']/following-sibling::span[contains(text(),'This field is required')]")
	public static WebElement reqMsgParticipant;
	
	@FindBy(how=How.ID, using="TechniqueDate")
	public static WebElement clickDate;	
	
	@FindBys({@FindBy(how=How.XPATH, using="//table[@class='datepicker-days']//td")})
	public static List<WebElement> dates;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueDate']/following-sibling::span[contains(text(),'This field is required')]")
	public static WebElement reqMsgDates;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueRatingType_chosen']/a")
	public static WebElement clickRating;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueRatingType_chosen']//li")})
	public static List<WebElement> rating;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueDate']/following-sibling::span[contains(text(),'This field is required')]")
	public static WebElement reqMsgRating;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueRound_chosen']/a")
	public static WebElement clickRound;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueRound_chosen']//li")})
	public static List<WebElement> round;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueRound_chosen']/following-sibling::span[contains(text(),'This field is required')]")
	public static WebElement reqMsgRound;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueEvaluatorRole_chosen']/a")
	public static WebElement clickRole;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueEvaluatorRole_chosen']//li")})
	public static List<WebElement> role;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueEvaluatorRole_chosen']/following-sibling::span[contains(text(),'This field is required')]")
	public static WebElement reqMsgRole;
	
	@FindBy(how=How.XPATH, using=".//*[@id='Technique100_chosen']/a")
	public static WebElement clickPercentage;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='Technique100_chosen']//li")})
	public static List<WebElement> percentage;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniquePositiveFraming_chosen']/a")
	public static WebElement clickFraming;

	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniquePositiveFraming_chosen']//li")})
	public static List<WebElement> framing;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueStrongVoice_chosen']/a")
	public static WebElement clickVoice;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueStrongVoice_chosen']//li")})
	public static List<WebElement> voice;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueWhatToDo_chosen']/a")
	public static WebElement clickWhatTodDo;

	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueWhatToDo_chosen']//li")})
	public static List<WebElement> whatToDo;
	
	@FindBy(how=How.XPATH, using="//*[@id='TechniqueEngineerEfficiency_chosen']/a")
	public static WebElement clickEfficiency;
	
	@FindBys({@FindBy(how=How.XPATH, using="//*[@id='TechniqueEngineerEfficiency_chosen']//li")})
	public static List<WebElement> efficiency;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Submit')]")
	public static WebElement btnSubmit;
	
	@FindBy(how=How.ID, using="swal2-title']")
	public static WebElement msgSucces;
	
	@FindBy(how=How.XPATH, using="//button[contains(@class,'swal2-confirm')]")
	public static WebElement btnConfirmation;
	
	@FindBys({@FindBy(how=How.XPATH, using="//span[contains(text(),'This field is required')]")})
	public static List<WebElement> reqMsgList;
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
