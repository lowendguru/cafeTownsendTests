package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EmployeesPageObjects;
import pageObjects.NewEmployeePageObjects;
import utils.RandomValueGenerator;

public class AddEmployeeTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterClass
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void addEmployee() {
		// Login
		login();

		// Click Create button
		EmployeesPageObjects.createButton(driver).click();

		String firstName = RandomValueGenerator.getRandomString();
		String lastName = RandomValueGenerator.getRandomString();
		String startDate = RandomValueGenerator.getRandomDate();
		String email = RandomValueGenerator.getRandomString() + "@" + RandomValueGenerator.getRandomString() + ".com";

		// Enter valid values in employee fields
		fillEmployeeDetailsForm(firstName, lastName, startDate, email);

		// Click Add button
		NewEmployeePageObjects.addButton(driver).click();

		// Verify that the new entry is present in the list
		boolean isPresentInList = false;
		for (WebElement e : EmployeesPageObjects.employeeList(driver)) {
			if (e.getText().equals(firstName + " " + lastName)) {
				// Name and last name found in the list
				isPresentInList = true;
				break;
			}
		}
		Assert.assertTrue(isPresentInList, "firstName and lastName not found in list");

	}
}
