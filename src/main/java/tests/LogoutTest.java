package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EmployeesPageObjects;

public class LogoutTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void validLogout() {

		login();

		// click on the logout button
		EmployeesPageObjects.logoutButton(driver).click();
		waiting.waitForLoad(driver);

		// Assert the user is logged out
		Assert.assertTrue(driver.getCurrentUrl().contains(properties.getProperty("loginURL")),
				"Logout unsuccessful, user is not taken to login screen");

	}

}
