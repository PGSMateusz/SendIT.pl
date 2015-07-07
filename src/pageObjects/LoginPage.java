package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageResults.LoginResultPage;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Data Login to the Web Page
	public LoginPage loginAction() {
		
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		 
		//get current date time with Date()
		Date date = new Date();
		 
		// Now format the date
		String date1= dateFormat.format(date);
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("TESTY_AUTOMATYCZNE");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("rambo_" + date1);
		return new LoginPage(driver);
		
	}

	// Click Login button
	public LoginResultPage submitForm() {
		driver.findElement(By.cssSelector("button.btn-default-large")).click();
		return new LoginResultPage(driver);
	}
	
	// Assertions on existing Web elements
	public LoginPage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("main.login > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'LOGOWANIE'"));
		return new LoginPage(driver);
	}
	
}
