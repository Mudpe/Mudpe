package POM;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;

public class Xpath {
	
	private static final By loginname = By.xpath("(//input[@id='usernameField']/ancestor::div)[13]");
	// To navigate till parent class or grand parent class of current node
	//ancestor
	
	private static final By Loginname1 = By.xpath("(//input[@id='usernameField']/ancestor or self ::div)[13]");
	// To navigate till parent class or grand parent class with current node
	//ancestor or self

	private static final By Loginname2 = By.xpath("//input[@id='usernameField']/following-sibling::div");
	// To navigate from xpath to downward (After current node)selector then following sibling is used
	
	private static final By Loginname3 = By.xpath("//input[@id='usernameField']/preceding-sibling::*");
	// To navigate from xpath to above (Before current node) selector then following is used
	
	private static final By Loginname4 = By.xpath("//div[@class='input-field col s12']/descendant::*");
	// to navigate from current node to childer or grand children
	
	private static final By Loginname5 = By.xpath("//div[@class='input-field col s12']/descendant or self::*");
	// to navigate with current node to childer or grand children
	
	private static final By Loinname6 = By.xpath("//span[contains(text(),'Email ID/Username cannot be left blank')]");
	// By using contains text
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY;HH-mm-ss");
		String date1 = sdf.format(date);
		System.out.println(date1);
	}
	
	
	
	
	
	

}
