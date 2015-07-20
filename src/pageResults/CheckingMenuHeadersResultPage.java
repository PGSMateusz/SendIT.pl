package pageResults;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class CheckingMenuHeadersResultPage extends AbstractPage {

	public CheckingMenuHeadersResultPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
	}

	public String getConfirmationMessageOferta() {
		return driver.findElement(By.cssSelector(".offer>h2")).getText();
	}
	
	public String getConfirmationMessageTools() {
		return driver.findElement(By.cssSelector(".tools>h2")).getText();
	}
	
	public String getConfirmationMessageSubHeader() {
		return driver.findElement(By.cssSelector(".structSubHeader>h1")).getText();
	}
	
}
