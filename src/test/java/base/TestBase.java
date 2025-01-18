package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestBase {

	Properties prop;
	public WebDriver driver;
	public WebDriver WebDriverManager() throws Exception {
		
		String url = getProperty("QAUrl");
		String browser_properties = getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		//result = testCondition ? value1:value2
		String browser = browser_maven !=null ? browser_maven : browser_properties;
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("safari")) {
				driver = new SafariDriver();
			}
			else {
				throw new Exception("Invalid browser!!!");
				
			}
				
			driver.get(url);
		}
		return driver;
		
	}
	
	public String getProperty(String propName) throws IOException {
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(propName);		
	}
	
}
