package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By productName = By.cssSelector(".product-name");
	private By applyBtn = By.cssSelector(".promoBtn");
	private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	
	public String getSearchedProductName() {
		return driver.findElement(productName).getText().trim();
	}
	
	public boolean isApplyButtonAvailable() {
		return driver.findElement(applyBtn).isDisplayed();
	}
	
	public boolean isPlaceOrderButtonAvailable() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	
	
	
	
	
}
