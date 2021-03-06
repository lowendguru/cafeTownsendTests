package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EmployeesPageObjects;

public class ValidLoginTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void validLogin() {

		// login
		login();

		// Assert result
		String greetingText = EmployeesPageObjects.greetingText(driver).getText();
		Assert.assertEquals(greetingText, "Hello " + getProperty("validUsername"), "Greeting text not found.");

	}

}
