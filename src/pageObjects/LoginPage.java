package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageResults.LoginResultPage;
import utilities.Settings;

public class LoginPage extends AbstractPage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Data Login to the Web Page
	public LoginPage loginAction() {		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(Settings.SendIT.SendIT_USER);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(Settings.SendIT.SendIT_PASSWORD);
		return new LoginPage(driver);
		
	}

	// Click Login button
	public LoginResultPage submitForm() {
		driver.findElement(By.cssSelector("button.btn-default-large")).click();
		return new LoginResultPage(driver);
	}
	
	// Assertions on existing Web elements
	public LoginPage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("main.login > h2"))) errorCollector.addError(new Throwable("brak nag��wka 'LOGOWANIE'"));
		return new LoginPage(driver);
	}
	
}
