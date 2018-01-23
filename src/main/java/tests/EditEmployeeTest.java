package tests;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EditEmployeePageObjects;
import pageObjects.EmployeesPageObjects;
import utils.RandomValueGenerator;

public class EditEmployeeTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void editEmployee() {
		// Login
		login();

		// click on existing employee
		ArrayList<WebElement> list = EmployeesPageObjects.employeeList(driver);
		int randomNumber = (int) Math.floor(Math.random() * list.size());
		WebElement listElement = list.get(randomNumber);
		listElement.click();

		// click on Edit button
		EmployeesPageObjects.editButton(driver).click();
		waiting.waitForLoad(driver);

		// modifiy contents of fields
		String firstName = RandomValueGenerator.getRandomString();
		String lastName = RandomValueGenerator.getRandomString();
		String startDate = RandomValueGenerator.getRandomDate();
		String email = RandomValueGenerator.getRandomString() + "@" + RandomValueGenerator.getRandomString() + ".com";
		fillEmployeeDetailsForm(firstName, lastName, startDate, email);

		// click on Update button
		EditEmployeePageObjects.updateButton(driver).click();
		waiting.waitForLoad(driver);

		// verify that changes took effect
		boolean isPresentInList = false;
		for (WebElement e : EmployeesPageObjects.employeeList(driver)) {
			if (e.getText().equals(firstName + " " + lastName)) {
				// Name and last name found in the list
				isPresentInList = true;
				break;
			}
		}
		Assert.assertTrue(isPresentInList, "firstName and lastName not found in list after editing");

	}
}
