package pageResults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class LoginResultPage extends AbstractPage{

	public LoginResultPage(WebDriver driver) {
		super(driver, errorCollector);
	}
	
	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("li.info")).getText();
	}
	
}
