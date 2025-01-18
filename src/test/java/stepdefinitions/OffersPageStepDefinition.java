package stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class OffersPageStepDefinition {
	
	String prodNameOffers;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
	}

	@Then("^user searched for same shortname (.+) in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortProdName)  {
		
		switchToOffersPageWindow();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		//testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortProdName);
		offersPage.searchItem(shortProdName);
		prodNameOffers = offersPage.getSearchedProductName();
	    
		
	}
	
	public void switchToOffersPageWindow() {
		//landingPage = testContextSetup.pageObjectManager.getLandingPage();
		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			//do nothing
			
		}
		else
		{
			
			//pageObjectManager = new PageObjectManager(testContextSetup.driver);
			landingPage = testContextSetup.pageObjectManager.getLandingPage();
			landingPage.selectTopDealsPage();
			testContextSetup.genericUtils.switchToChildWindow();
			
		}
	}
	@Then("Validate product name in offers page matches with landing page")
	public void Validate_product_name_in_offers_page_matches_with_landing_page() {
		System.out.println(prodNameOffers);
		if(testContextSetup.prodNameLandingPage.equalsIgnoreCase(prodNameOffers)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}
		Assert.assertEquals(testContextSetup.prodNameLandingPage, prodNameOffers);
	}


}
