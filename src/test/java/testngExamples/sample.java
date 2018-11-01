package testngExamples;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class sample {
	@Test
	public void testMethod() {
		System.out.println("From test method");
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
