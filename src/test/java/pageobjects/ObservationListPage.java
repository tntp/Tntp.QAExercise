package pageobjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
public class ObservationListPage extends BaseClass{

	public ObservationListPage(WebDriver driver){
		super(driver);
	}    
	
	@FindBys({@FindBy(how=How.XPATH, using="(//*[@id='obs-list']//tr/td[2])")})
	public static List<WebElement> observationIds;	
	
	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
