package tests;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageResults.LoginResultPage;

public class LoginPageTest {

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
	public void shouldLoginIntoAccount() {
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver, null);
		onHomePage = onHomePage.navigateToWebApp();
		LoginPage onLoginPage = onHomePage.checkIfElementsArePresent().clickOnLogin();
		LoginResultPage onResultPage = onLoginPage.checkIfElementsArePresent().loginAction().submitForm();
		
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("Zalogowany jako: Dariusz Juüwik (nr klienta: 832)"));
	}
	
	
	
}
