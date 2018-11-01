package utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	Logger logger = Logger.getLogger(Base.class.getName());

	public Base(){
		ReadPropertiesFile prop = new ReadPropertiesFile();
		Properties selProp = prop.getAllProperties("project.properties");
		invokeBrowser(selProp.getProperty("browser").trim(), selProp.getProperty("url").trim());
		setLogger();
	}

	private void setLogger() {
		String log4jConfPath = getClass().getClassLoader().getResource("log4j.properties").getPath();
		PropertyConfigurator.configure(log4jConfPath);
		logger.getAppender(log4jConfPath);
	}

	public void invokeBrowser(String browser, String url){
		logger.info("Browser ==> " + browser+", url ==> " +url);
		String file = getClass().getClassLoader().getResource("drivers").getPath().toString();
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", file + "//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", file + "//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("html")){
			driver = new HtmlUnitDriver();
		}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", file + "//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		if(url.isEmpty())
			url = "about:blank";
		driver.get(url);
		logger.info("Selenium setup is successful");
	}

	public void closeBrowser(){
		if(driver!=null)
			driver.close();
	}

	public void quitBrowser(){
		if(driver!=null)
			driver.quit();
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver getDriver() {
		return driver;
	}


}
