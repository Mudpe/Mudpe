package com.Runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM.Login;
import POM.ProfileUpdate;

@Listeners(com.Listner.HTMLReport2.class)


public class Runner {
	private WebDriver driver;
	private Login login;
	private ProfileUpdate profileUpdate;
	
	@BeforeMethod
	public void IntBrowser () {
		driver = new  ChromeDriver();
		login = new Login(driver);
		profileUpdate = new ProfileUpdate(driver);
		login.Website("https://www.naukri.com/nlogin/login");
		login.ScreenMaximise();
		
	}
	
	@Test
	public void Run () throws InterruptedException {
		login.TestLogin("mudpeabhilash95@gmail.com", "123456");
		profileUpdate.TestUpdate();
	}
	
	@AfterMethod
	public void Close () {
		login.Close();
	}
}
