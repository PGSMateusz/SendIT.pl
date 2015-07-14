package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageResults.CreateAccountResultPage;

public class CreateAccountPage extends AbstractPage {

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public CreateAccountPage createAccountAction() {
	    driver.findElement(By.id("registration_login")).clear();
	    driver.findElement(By.id("registration_login")).sendKeys("REGISTRATION_TEST");
	    driver.findElement(By.id("registration_plainPassword_password")).clear();
	    driver.findElement(By.id("registration_plainPassword_password")).sendKeys("mateusz_2015");
	    driver.findElement(By.id("registration_plainPassword_confirm")).clear();
	    driver.findElement(By.id("registration_plainPassword_confirm")).sendKeys("mateusz_2015");
	    driver.findElement(By.id("registration_firstName")).clear();
	    driver.findElement(By.id("registration_firstName")).sendKeys("User");
	    driver.findElement(By.id("registration_lastName")).clear();
	    driver.findElement(By.id("registration_lastName")).sendKeys("Testowy");
	    driver.findElement(By.id("registration_email")).clear();
	    driver.findElement(By.id("registration_email")).sendKeys("mateusz.dabrowski@example.pl");
	    driver.findElement(By.id("registration_termsOfService")).click();
	    driver.findElement(By.id("registration_personalDataAgreement")).click();
     // driver.findElement(By.id("registration_commercialInformationAgreement")).click();
		return new CreateAccountPage(driver);
	}

	// Click Registration button
	public CreateAccountResultPage sumbitForm() {
		driver.findElement(By.id("registration_register")).click();
		return new CreateAccountResultPage(driver);
	}
	
	// Assertions on existing Web elements
	public CreateAccountPage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("main.registration > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'ZAK£ADANIE KONTA'"));
		return new CreateAccountPage(driver);
	}
	
}
