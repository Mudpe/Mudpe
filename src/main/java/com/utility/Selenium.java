package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {
	private WebDriver driver;
	private WebDriverWait driverWait;
	private static WebDriver SSdriver;

	public Selenium(WebDriver driver) {
		this.driver = driver;
		SSdriver=driver;
		 driverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
	}
	
	public void ScreenMaximise () {
		driver.manage().window().maximize();
	}
	
	public void Website (String URL) {
		driver.get(URL);
	}
	
	public void ScreenMinimise() {
		driver.manage().window().minimize();
	}
	
	public void GetText (By Locator) {
		WebElement text = driverWait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		String Value = text.getText();
		System.out.println(Value);
	}
	
	public void Click (By Locator) throws InterruptedException {
		WebElement clickable = driverWait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		clickable.click();
		Thread.sleep(2000);
	}
	
	public void SendKey (By Locator, String Value) throws InterruptedException {
		WebElement entertext = driverWait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		entertext.clear();
		entertext.sendKeys(Value);
		Thread.sleep(2000);
	}
	
	public void Enter () {
		Actions act = new Actions(driver);
		act.keyDown(Keys.ENTER).perform();
		act.keyUp(Keys.ENTER).perform();
	}
	
	public void Close () {
		driver.close();
	}
	
	public static String takeScreenshot (String TestName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)SSdriver;
		File screenshotdata = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String pathname = ("C:\\Users\\abhil\\Downloads\\"+TestName+".png");
		File file = new File(pathname);
		FileUtils.copyFile(screenshotdata, file);
		return pathname;
	}
	
	public static String gettime () {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY;HH-mm-ss");
		String date1 = sdf.format(date);
		System.out.println(date1);
		return date1;
	}
	
	
	

}
