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

public class OrderCourierDPD {
	
WebDriver driver;
LoginPageTest accountTest = new LoginPageTest(); 


	private static final Logger logger = Logger.getLogger(LoginPageTest.class.getName());

//	private void shouldLoginIntoAccount() {
//		logger.info("About to run the test");
//		HomePage onHomePage = new HomePage(driver);
//		onHomePage = onHomePage.navigateToWebApp();
//		LoginPage onLoginPage = onHomePage.checkIfElementsArePresent().clickOnLogin();
//		LoginResultPage onResultPage = onLoginPage.checkIfElementsArePresent().loginAction().submitForm();
//		
//		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("Zalogowany jako: Dariusz Ju�wik (nr klienta: 832)"));		
//	}

	@Before
	public void setUp() throws Exception {
		logger.info("About to start the test");
	    driver = new FirefoxDriver();
	    accountTest.shouldLoginIntoAccount();
	    //shouldLoginIntoAccount();
	}

	@After
	public void tearDown() throws Exception {
		logger.info("About to quit the driver");
		driver.quit();
	}
	
	@Test
	public void shouldSubmitNewPackage() {
		//Nadaj Paczk�
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver);
		onHomePage = onHomePage.navigateToWebApp();
		SubmitNormalPage onSubmitCurrentPage = onHomePage.checkIfElementsArePresent().clickOnSubmitNormal();
		SubmitNormalResultPage onResultPage = onSubmitCurrentPage.submitActionFromTemplate().acceptParcel();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("NADAJ PACZK�"));	
		
		//Podsumowanie i P�atno��
		onSubmitCurrentPage.submitOrder();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("PODSUMOWANIE I P�ATNO��"));	
		
		//Transakcja Zako�czona
		onSubmitCurrentPage.submitOrderCourier();
		Assert.assertTrue(onResultPage.getEndConfirmationMessage().contains("TRANSAKCJA ZAKO�CZONA"));	
		
		onSubmitCurrentPage.myCourierPackages();
	}

}
