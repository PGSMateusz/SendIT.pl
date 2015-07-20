package pageResults;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class CheckingMenuHeadersResultPage extends AbstractPage {

	public CheckingMenuHeadersResultPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
	}

	public String getConfirmationMessageH1() {
		return driver.findElement(By.cssSelector("h1")).getText();
	}
	
	public String getConfirmationMessageH2() {
		return driver.findElement(By.cssSelector(".offer>h2")).getText();
	}
	
}
