package pageObjects;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageResults.SubmitNormalResultPage;

public class SubmitNormalPage extends AbstractPage {

	public SubmitNormalPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
		// TODO Auto-generated constructor stub
	}
	
	public SubmitNormalPage submitActionFromTemplate() {
	    new Select(driver.findElement(By.id("Template"))).selectByVisibleText("TEST");
	    driver.findElement(By.id("SendTypePack")).click();
		return this;
	}

	public SubmitNormalResultPage acceptParcel() {
		driver.findElement(By.cssSelector(".acceptParcel")).click();
		return new SubmitNormalResultPage(driver, errorCollector);
	}
	
	public SubmitNormalPage submitOrder() {
		driver.findElement(By.cssSelector(".buttonOrderSubmit.orderUps")).click();
		return this;
	}
	
	public SubmitNormalPage submitOrderCourier() {
		driver.findElement(By.cssSelector(".buttonOrder.buttonOrderConfirm")).click();
		return this;
	}
	
	// Assertions on existing Web elements
	public LoginPage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector(".structSubHeader>h1"))) errorCollector.addError(new Throwable("brak nag³ówka 'NADAJ PACZKÊ'"));
		return new LoginPage(driver, errorCollector);
	}
	
}
