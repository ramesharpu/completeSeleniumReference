package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	static Base b = new Base();
	public static WebDriver driver = b.getDriver();

	@AfterSuite
	public void afterSuite(){
		b.quitBrowser();
	}
}