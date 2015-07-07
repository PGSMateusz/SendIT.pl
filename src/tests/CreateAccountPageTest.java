package tests;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageResults.CreateAccountResultPage;

public class CreateAccountPageTest {

	WebDriver driver;
	
	private static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

	@Before
	public void setUp() throws Exception {
		logger.info("About to start the test");
	    driver = new FirefoxDriver();
	}
	
	@After
	public void tearDown() throws Exception {
		logger.info("About to quit the driver");
		driver.quit();
	}
	
	@Test
	public void shouldCreateNewAccount() {
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver);
		onHomePage = onHomePage.navigateToWebApp();
		CreateAccountPage onCreateAccountPage = onHomePage.checkIfElementsArePresent().clickOnCreateAccount();
		CreateAccountResultPage onResultPage = onCreateAccountPage.checkIfElementsArePresent().createAccountAction().sumbitForm();
		
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("Dziêkujemy za Twoje zainteresowanie platform¹ wysy³kow¹ Sendit.pl!"));	
	}
	
	
}
