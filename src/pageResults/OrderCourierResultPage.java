package pageResults;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class OrderCourierResultPage extends AbstractPage {

	public OrderCourierResultPage(WebDriver driver, ErrorCollector errorCollector) {
		super(driver, errorCollector);
	}

	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("h1")).getText();
	}
	
	public String getEndConfirmationMessage() {
		return driver.findElement(By.cssSelector("#confirmation>h2")).getText();
	}
	
	public String getLatesCourierPackagesMessage() {
		return driver.findElement(By.xpath("//form[@id='listUserParcelsForm']/table/tbody/tr/td[2]")).getText();
	}

}
