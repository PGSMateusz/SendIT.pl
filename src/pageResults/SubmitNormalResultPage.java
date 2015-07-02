package pageResults;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class SubmitNormalResultPage extends AbstractPage {

	public SubmitNormalResultPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
		// TODO Auto-generated constructor stub
	}

	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("h1")).getText();
	}
	
}
