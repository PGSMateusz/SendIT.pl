package pageResults;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class LoginResultPage extends AbstractPage{

	public LoginResultPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
		// TODO Auto-generated constructor stub
	}
	
	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("li.info")).getText();
	}
	
}
