package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickOnLogin() {
		driver.findElement(By.cssSelector("li.login>a")).click();
		return new LoginPage(driver);

	}
	
	public CreateAccountPage clickOnCreateAccount() {
		driver.findElement(By.cssSelector("li.create>a")).click();
		return new CreateAccountPage(driver);

	}
	
	public OrderCourierPage clickOnSubmitNormal() {
		driver.findElement(By.cssSelector("li.submitNormal>a")).click();
		return new OrderCourierPage(driver);
	
	}
	
	public HomePage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("section.about > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Czym jest Sendit.pl?'"));
		if(!isElementPresent(By.cssSelector("section.news > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Aktualnoœci'"));
		return new HomePage(driver);
	}
	
}
