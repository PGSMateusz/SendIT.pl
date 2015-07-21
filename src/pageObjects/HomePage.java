package pageObjects;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
	}
	
	//--- navibar webpage ---
	public HomePage clickOnHome() {
		driver.findElement(By.cssSelector(".home")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public HomePage clickOnOfferNormal() {
		driver.findElement(By.cssSelector("li.offerNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public OrderCourierPage clickOnSubmitNormal() {
		driver.findElement(By.cssSelector("li.submitNormal>a")).click();
		return new OrderCourierPage(driver, errorCollector);
	}
	
	public HomePage clickOnAccountNormal() {
		driver.findElement(By.cssSelector(".accountNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public HomePage clickOnToolsNormal() {
		driver.findElement(By.cssSelector(".toolsNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public HomePage clickOnAllegroNormal() {
		driver.findElement(By.cssSelector(".allegroNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public HomePage clickOnFaqNormal() {
		driver.findElement(By.cssSelector(".faqNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	public HomePage clickOnContactNormal() {
		driver.findElement(By.cssSelector(".contactNormal>a")).click();
		return new HomePage(driver, errorCollector);
	}
	
	//--- user interface ---
	public LoginPage clickOnLogin() {
		driver.findElement(By.cssSelector("li.login>a")).click();
		return new LoginPage(driver, errorCollector);
	}
	
	public CreateAccountPage clickOnCreateAccount() {
		driver.findElement(By.cssSelector("li.create>a")).click();
		return new CreateAccountPage(driver, errorCollector);
	}

	//--- if elements are present ---
	public HomePage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector("section.about > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Czym jest Sendit.pl?'"));
		if(!isElementPresent(By.cssSelector("section.news > h2"))) errorCollector.addError(new Throwable("brak nag³ówka 'Aktualnoœci'"));
		return new HomePage(driver, errorCollector);
	}
	
}
