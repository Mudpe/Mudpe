package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.Selenium;

public class Login extends Selenium{

	private static final By UserNmaeLocator = By.cssSelector("input[id='usernameField']");
	private static final By passwordLocator = By.cssSelector("input[id='passwordField']");


	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void TestLogin (String LoginName, String Password) throws InterruptedException {
		SendKey(UserNmaeLocator, LoginName);
		SendKey(passwordLocator, Password);
		Enter();
	}
	
	
}
