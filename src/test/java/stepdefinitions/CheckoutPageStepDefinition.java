package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	TestContextSetup testContextSetup;
	CheckoutPage checkoutpage;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutpage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	
	 
	
	
	@Then("user verifies same product displays on checkout page")
	public void user_verifies_same_product_displays_on_checkout_page() {
		String prodNameCheckoutPage = checkoutpage.getSearchedProductName().split("-")[0].trim();
	    Assert.assertEquals(testContextSetup.prodNameLandingPage, prodNameCheckoutPage);
	}
	@Then("Validate Apply button is visible")
	public void validate_apply_button_is_visible() {
	    
	    Assert.assertTrue(checkoutpage.isApplyButtonAvailable());
	}
	@Then("Validate Place Order button is visible")
	public void validate_place_order_button_is_visible() {
		
		Assert.assertTrue(checkoutpage.isPlaceOrderButtonAvailable());
	   
	}
	@Then("Validate GreenKart logo is visible")
	public void validate_GreenKart_logo_is_visible() {
		
		Assert.assertTrue(checkoutpage.isPlaceOrderButtonAvailable());
	   
	}
}
