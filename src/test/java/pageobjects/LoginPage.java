package pageobjects;
import helpers.Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass{

	public LoginPage(WebDriver driver){
		super(driver);
	}    
	
	@FindBy(how=How.ID, using="inputEmail")
	public static WebElement email;
	
	@FindBy(how=How.ID, using="inputPassword")
	public static WebElement password;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Sign in')]")
	public static WebElement btnSignIn;
	
	@FindBy(how=How.XPATH, using="//h3[contains(text(),'Welcome')]")
	public static WebElement welcomeMsg;	
}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
