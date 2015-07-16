package tests;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.HomePage;
import pageObjects.OrderCourierPage;
import pageResults.OrderCourierResultPage;
import tests.LoginPageTest;
import utilities.TestDataParser;

public class OrderCourierUPS {
	
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
	public void shouldSubmitNewPackage() {
		//Nadaj Paczk�
		logger.info("About to run the test");
		HomePage onHomePage = new HomePage(driver);
		onHomePage = onHomePage.navigateToWebApp();
		OrderCourierPage onSubmitCurrentPage = onHomePage.checkIfElementsArePresent().clickOnSubmitNormal();
		OrderCourierResultPage onResultPage = onSubmitCurrentPage.submitActionFromTemplate().acceptParcel();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("NADAJ PACZK�"));	
		
		//Podsumowanie i P�atno��
		onSubmitCurrentPage.submitOrder();
		Assert.assertTrue(onResultPage.getConfirmationMessage().contains("PODSUMOWANIE I P�ATNO��"));	
		
		//Transakcja Zako�czona
		onSubmitCurrentPage.submitOrderCourier();
		Assert.assertTrue(onResultPage.getEndConfirmationMessage().contains("TRANSAKCJA ZAKO�CZONA"));	
		
		onSubmitCurrentPage.myCourierPackages();
		Assert.assertEquals(TestDataParser.getLatesUserOrder(), onResultPage.getLatesCourierPackagesMessage());
	}

}
