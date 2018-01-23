package tests;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.EditEmployeePageObjects;
import pageObjects.EmployeesPageObjects;

public class DeleteEmployeeTest extends BaseTest {

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@AfterTest
	public void tearDown() {
		super.tearDown();
	}

	@Test
	public void deleteEmployee() {

		// Login
		login();

		ArrayList<WebElement> list = EmployeesPageObjects.employeeList(driver);
		WebElement listElement;
		int instances;
		String firstAndLastName;

		// workaround to avoid duplicate entries
		do {
			// click on random existing employee
			int randomNumber = (int) Math.floor(Math.random() * list.size());
			listElement = list.get(randomNumber);
			firstAndLastName = listElement.getText();

			// make sure this element does not have duplicates so verification can work
			instances = 0;
			for (WebElement e : list) {
				if (e.getText().equals(firstAndLastName)) {
					instances++;
				}
				if (instances > 1) {
					break;
				}
			}
		} while (instances > 1);

		// the element has no duplicates, click on it
		listElement.click();

		// click on Edit button
		EmployeesPageObjects.editButton(driver).click();
		waiting.waitForLoad(driver);

		// click on delete button
		EditEmployeePageObjects.deleteButton(driver).click();

		// alert validation is displayed, press OK
		waitingAlert.waitForAlert(driver);
		driver.switchTo().alert().accept();
		waiting.waitForLoad(driver);

		// verify that changes took effect, deleted item is no longer present
		boolean isPresentInList = false;
		for (WebElement e : EmployeesPageObjects.employeeList(driver)) {
			if (e.getText().equals(firstAndLastName)) {
				// Name and last name found in the list
				isPresentInList = true;
				break;
			}
		}
		Assert.assertTrue(!isPresentInList,
				"firstName and lastName found in list after deleting employee: " + firstAndLastName);

	}
}
