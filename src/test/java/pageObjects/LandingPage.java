package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBox = By.cssSelector(".search-keyword");
	private By productName = By.xpath("//h4[@class='product-name']");
	private By topDeals = By.linkText("Top Deals");
	private By quantity = By.xpath("//input[@type='number']");
	private By addToCartBtn = By.xpath("//button[@type='button' and text()='ADD TO CART']");
	private By cartIcon = By.cssSelector(".cart-icon");
	private By proceedToCheckOutBtn = By.xpath("//button[@type='button' and text()='PROCEED TO CHECKOUT']");
	private By test = By.id("test");

	public void searchItem(String shortProdName) {
		driver.findElement(searchBox).sendKeys(shortProdName);
	}
	
	public void getSearchText() {
		driver.findElement(searchBox).getText();
	}
	
	public String getSearchedProductName() {
		return driver.findElement(productName).getText();
	}
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public void enterQuantity(String qty) {
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys(qty);
	}
	public void clickAddToCartBtn() {
		driver.findElement(addToCartBtn).click();
	}

	public void clickCartAndProceedToCheckOut() {
		driver.findElement(cartIcon).click();
		driver.findElement(proceedToCheckOutBtn).click();
	}
}
