package stepdefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	//public  WebDriver driver;
	TestContextSetup testContextSetup;
	//String prodNameLandingPage;
	String prodNameOffers;
	LandingPage landingPage;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup=testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("Verify User is on Greencart landing page")
	public void verify_user_is_on_greencart_landing_page() throws Exception {
		/*
		 * testContextSetup.driver = new ChromeDriver();
		 * 
		 * testContextSetup.driver.manage().window().maximize();
		 * testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
		 * (15)); testContextSetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		testContextSetup.testBase.WebDriverManager();
	}

	@When("^user searches with shortname (.+) and extracted actual name of product$")
	public void user_searches_with_shorname_and_extracted_actual_name_of_product(String shortProdName) throws InterruptedException {
		
		landingPage.searchItem(shortProdName);
	   Thread.sleep(2000);
	   testContextSetup.prodNameLandingPage = landingPage.getSearchedProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.prodNameLandingPage+" is extracted from Home Page");
	}
	@When("^enters quantity as (.+) and adds to the cart$")
	public void enters_quantity_and_adds_to_the_cart(String qty) {
		
	   landingPage.enterQuantity(qty); 
	}
	@When("Proceeds to checkout page")
	public void proceeds_to_checkout_page() throws InterruptedException {
	    landingPage.clickAddToCartBtn();
	    landingPage.clickCartAndProceedToCheckOut();
	    Thread.sleep(3000);
	}
}
