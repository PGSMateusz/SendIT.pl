package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import pageResults.OrderCourierResultPage;

public class OrderCourierPage extends AbstractPage {

	public OrderCourierPage(WebDriver driver) {
		super(driver);
	}
	
	public OrderCourierPage submitActionFromTemplate() {
	    new Select(driver.findElement(By.id("Template"))).selectByVisibleText("TEST");
	    driver.findElement(By.id("SendTypePack")).click();
		return this;
	}

	public OrderCourierResultPage acceptParcel() {
		driver.findElement(By.cssSelector(".acceptParcel")).click();
		return new OrderCourierResultPage(driver);
	}
	
	public OrderCourierPage submitOrder() {
		driver.findElement(By.cssSelector(".buttonOrderSubmit.orderUps")).click();
		return this;
	}
	
	public OrderCourierPage submitOrderCourier() {
		driver.findElement(By.cssSelector(".buttonOrder.buttonOrderConfirm")).click();
		return this;
	}
	
	public OrderCourierPage myCourierPackages() {
		driver.findElement(By.xpath("//a[contains(text(),'Moje przesy³ki')]")).click();
		return this;
	}
	
	// Assertions on existing Web elements
	public LoginPage checkIfElementsArePresent() {
		if(!isElementPresent(By.cssSelector(".structSubHeader>h1"))) errorCollector.addError(new Throwable("brak nag³ówka 'NADAJ PACZKÊ'"));
		return new LoginPage(driver);
	}
	
}
