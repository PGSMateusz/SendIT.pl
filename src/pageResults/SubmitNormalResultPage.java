package pageResults;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.AbstractPage;

public class SubmitNormalResultPage extends AbstractPage {

	public SubmitNormalResultPage(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationMessage() {
		return driver.findElement(By.cssSelector("h1")).getText();
	}
	
	public String getEndConfirmationMessage() {
		return driver.findElement(By.cssSelector("#confirmation>h2")).getText();
	}

}
