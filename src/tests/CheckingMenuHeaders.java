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
	private HomePage onCheckingMenuHeaders;

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
	public void shouldCheckAllWebHeaders() throws InterruptedException {
		//Checking headers
		HomePage onHomePage = new HomePage(driver, null);
		CheckingMenuHeadersResultPage onMainPage = new CheckingMenuHeadersResultPage(driver, null) ;  
		onHomePage = onHomePage.navigateToWebApp();
		
		logger.info("OFERTA");
		setOnCheckingMenuHeaders(onHomePage.clickOnOfferNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageOferta().contains("OFERTA"));
        System.out.println("OFERTA Header - OK...");
		
        logger.info("MOJE KONTO");
		setOnCheckingMenuHeaders(onHomePage.clickOnAccountNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageSubHeader().contains("MOJE DANE"));
        System.out.println("MOJE KONTO Header - OK...");

        logger.info("NARZÊDZIA");
		setOnCheckingMenuHeaders(onHomePage.clickOnToolsNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageTools().contains("NARZÊDZIA"));
        System.out.println("NARZÊDZIA Header - OK...");
        
        logger.info("MOJE ALLEGRO");
		setOnCheckingMenuHeaders(onHomePage.clickOnAllegroNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageSubHeader().contains("MOJE ALLEGRO"));
        System.out.println("MOJE ALLEGRO Header - OK...");
        
        logger.info("FAQ");
		setOnCheckingMenuHeaders(onHomePage.clickOnFaqNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageSubHeader().contains("FAQ"));
        System.out.println("FAQ Header - OK...");
        
        logger.info("KONTAKT");
		setOnCheckingMenuHeaders(onHomePage.clickOnFaqNormal());
		Assert.assertTrue(onMainPage.getConfirmationMessageSubHeader().contains("KONTAKT"));
        System.out.println("KONTAKT Header - OK...");
	}

	public HomePage getOnCheckingMenuHeaders() {
		return onCheckingMenuHeaders;
	}

	public void setOnCheckingMenuHeaders(HomePage onCheckingMenuHeaders) {
		this.onCheckingMenuHeaders = onCheckingMenuHeaders;
	}

}