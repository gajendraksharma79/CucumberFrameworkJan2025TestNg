package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	private By searchBox = By.xpath("//input[@id='search-field']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String shortProdName) {
		driver.findElement(searchBox).sendKeys(shortProdName);
	}
	
	public String getSearchedProductName() {
		return driver.findElement(productName).getText().trim();
	}
	
}
