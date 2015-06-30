package pageObjects;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
		// TODO Auto-generated constructor stub
	}

	public LoginPage clickOnLogin() {
		driver.findElement(By.cssSelector("li.login>a")).click();
		return new LoginPage(driver, errorCollector);

	}
	
	public CreateAccountPage clickOnCreateAccount() {
		driver.findElement(By.cssSelector("li.create>a")).click();
		return new CreateAccountPage(driver, errorCollector);

	}
	
	public SubmitNormalPage clickOnSubmitNormal() {
		driver.findElement(By.cssSelector("li.submitNormal>a")).click();
		return new SubmitNormalPage(driver, errorCollector);
	
	}
	
	public HomePage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("section.about > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Czym jest Sendit.pl?'"));
		if(!isElementPresent(By.cssSelector("section.news > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Aktualnoœci'"));
		return new HomePage(driver, errorCollector);
	}
	
}
