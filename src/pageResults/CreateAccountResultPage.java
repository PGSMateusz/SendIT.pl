package pageResults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class CreateAccountResultPage extends AbstractPage{

	public CreateAccountResultPage(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("h3")).getText();
	}
	
}
