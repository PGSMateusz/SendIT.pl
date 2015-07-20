package tests;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import pageResults.CheckingMenuHeadersResultPage;
import tests.LoginPageTest;

public class CheckingMenuHeaders {
	
WebDriver driver;
LoginPageTest accountTest; 

	private static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

	@Before
	public void setUp() throws Exception {
		logger.info("About to start the test");
	    driver = new FirefoxDriver();
	    accountTest = new LoginPageTest(driver);
	    accountTest.shouldLoginIntoAccount();
	}

	@After
	public void tearDown() throws Exception {
		logger.info("About to quit the driver");
		driver.quit();
	}
	
	@Test
	public void shouldCheckAllWebHeaders() {
		//Checking headers
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver, null);
		onHomePage = onHomePage.navigateToWebApp();
		//LoginPage onLoginPage = onHomePage.checkIfElementsArePresent().clickOnLogin();
		HomePage onCheckingMenuHeaders = onHomePage.checkIfElementsArePresent().clickOnOfferNormal();
		CheckingMenuHeadersResultPage onMainPage = new CheckingMenuHeadersResultPage(driver, null) ;  
		
		Assert.assertTrue(onMainPage.getConfirmationMessageH2().contains("OFERTA"));	


	}

}