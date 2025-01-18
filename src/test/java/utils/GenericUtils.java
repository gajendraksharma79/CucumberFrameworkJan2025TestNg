package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import pageObjects.LandingPage;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow() {
		
			
			Set<String> allWinHandles = driver.getWindowHandles();
			Iterator<String> iterator = allWinHandles.iterator();
			String mainWindowHandle = iterator.next();
			while(iterator.hasNext()) {
				String childWindow=iterator.next();
				if(!mainWindowHandle.equalsIgnoreCase(childWindow)) {
					driver.switchTo().window(childWindow);
				}
			}
		}
	

}
