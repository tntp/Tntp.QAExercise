package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class NavigationSection extends BaseClass{

	public NavigationSection(WebDriver driver){
		super(driver);
	}    
	
	@FindBy(how=How.XPATH, using="//button[@class='navbar-toggle']")
	public static WebElement menu;
	
	@FindBy(how=How.XPATH, using="(//a[@class='dropdown-toggle'])[1]")
	public static WebElement menuObservation;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'New Observation')]")
	public static WebElement menuNewObservation;
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	