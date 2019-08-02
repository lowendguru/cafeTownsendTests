package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EmployeesPageObjects;

public class LogoutTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void validLogout() {

		login();

		// click on the logout button
		EmployeesPageObjects.logoutButton(driver).click();

		// Assert the user is logged out
		Assert.assertTrue(driver.getCurrentUrl().contains(getProperty("loginURL")),
				"Logout unsuccessful, user is not taken to login screen");

	}

}
