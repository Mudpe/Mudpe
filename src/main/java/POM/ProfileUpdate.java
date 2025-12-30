package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.Selenium;

public class ProfileUpdate extends Selenium{
	
	
	private static final By UpdateProfileLocator = By.xpath("(//a[@href='/mnjuser/profile'])[1]/parent::div");
	private static final By ReumeHeadlineLocator = By.xpath("(//span[contains(text(),'editOneTheme')])[1]");
	private static final By EditLocator = By.xpath("//textarea[@id='resumeHeadlineTxt']");
	private static final By SaveLocator = By.xpath("(//button[contains(text(),'Save')])[2]");
	
	public ProfileUpdate(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void TestUpdate() throws InterruptedException {
		Click(UpdateProfileLocator);
		Click(ReumeHeadlineLocator);
		SendKey(EditLocator, "Having 5 years of experience as QA Engineer with Automation Testing, API Testing, Manual Testing, SQL Testing with the Tools like Selenium, java, Maven, POM, TestNG, Rest Assured, BDD, API Postman,… Along with other tools like JIRA,GIT etc.");
		Click(SaveLocator);
	}

}
