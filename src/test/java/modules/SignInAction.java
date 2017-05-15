package modules;

import helpers.Log;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageobjects.LoginPage;

public class SignInAction {

	public static void Execute(WebDriver driver) throws Exception{

		LoginPage.email.sendKeys("zsattar1224@gmail.com");

		Log.info(" is entered in UserName text box" );
		
		LoginPage.password.sendKeys("t2vULcU5DsNvwh8f9JdM");
		Log.info(" is entered in Password text box" );

		LoginPage.btnSignIn.click();
		Log.info("Click action is performed on Sign In button");

		Reporter.log("SignIn Action is successfully perfomred");

	}
}
