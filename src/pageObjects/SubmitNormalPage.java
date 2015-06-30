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

	public SubmitNormalResultPage submitForm (){
		
		return new SubmitNormalResultPage(driver, errorCollector);
	}
	
}
