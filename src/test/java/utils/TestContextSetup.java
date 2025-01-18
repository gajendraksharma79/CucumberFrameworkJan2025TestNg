package utils;

import org.openqa.selenium.WebDriver;

import base.TestBase;
import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String prodNameLandingPage;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws Exception {
		testBase = new TestBase();
		driver = testBase.WebDriverManager();
		pageObjectManager = new PageObjectManager(driver);
		genericUtils = new GenericUtils(driver);
		
	}

}
