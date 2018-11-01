package testngExamples;

import org.testng.annotations.Test;

import utils.Base;
import utils.BaseTest;
import utils.ReadPropertiesFile;

import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class sample extends BaseTest{
	Logger logger = Logger.getLogger(Base.class.getName());
	@Test
	public void testMethod() {
		System.out.println("From test method");
		logger.info("Browser page tile = "+driver.getTitle());
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("From before method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("From after method");
	}

}
