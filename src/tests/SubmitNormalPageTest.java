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
import pageObjects.SubmitNormalPage;
import pageResults.LoginResultPage;
import pageResults.SubmitNormalResultPage;
import tests.LoginPageTest;

public class SubmitNormalPageTest {
	
WebDriver driver;
LoginPageTest accountTest;

	private static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

	private void shouldLoginIntoAccount() {
//		logger.info("About to run the test");
//		HomePage onHomePage = new HomePage(driver, null);
//		onHomePage = onHomePage.navigateToWebApp();
//		LoginPage onLoginPage = onHomePage.checkIfElementsArePresent().clickOnLogin();
//		LoginResultPage onResultPage = onLoginPage.checkIfElementsArePresent().loginAction().submitForm();
//		
//		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("Zalogowany jako: Dariusz Juüwik (nr klienta: 832)"));		
		accountTest.shouldLoginIntoAccount();
	}

	@Before
	public void setUp() throws Exception {
		logger.info("About to start the test");
	    driver = new FirefoxDriver();
	    //accountTest.shouldLoginIntoAccount();
	     shouldLoginIntoAccount();
	}

	@After
	public void tearDown() throws Exception {
		logger.info("About to quit the driver");
		driver.quit();
	}
	
	@Test
	public void shouldSubmitNewPackage() {
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver, null);
		onHomePage = onHomePage.navigateToWebApp();
		SubmitNormalPage onSubmitCurrentPage = onHomePage.checkIfElementsArePresent().clickOnSubmitNormal();
		SubmitNormalResultPage onResultPage = onSubmitCurrentPage.submitActionFromTemplate().acceptParcel();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("NADAJ PACZK "));	
		
		onSubmitCurrentPage.submitOrder();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("PODSUMOWANIE I P£ATNOå∆"));		
	}

}
