package pageObjects;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {

	protected WebDriver driver;
	protected ErrorCollector errorCollector;
	
	public AbstractPage (WebDriver driver, ErrorCollector errorCollector){
		this.driver = driver;
		this.errorCollector = errorCollector;
	    this.driver.manage().window().maximize();
	    this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public HomePage navigateToWebApp() {
		driver.navigate().to("http://www.sendit/");
		return new HomePage(driver, errorCollector);
		
	}
	
    public boolean isElementPresent(By elem) {
        try {
            driver.findElement(elem);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
}
