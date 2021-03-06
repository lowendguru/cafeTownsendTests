package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewEmployeePageObjects extends  BasePageObject {

	private static WebElement element = null;

	public static WebElement firstNameTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//input[@type='text']"));
		return element;
	}

	public static WebElement lastNameTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("(//input[@type='text'])[2]"));
		return element;
	}

	public static WebElement startDateTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("(//input[@type='text'])[3]"));
		return element;
	}

	public static WebElement emailTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//input[@type='email']"));
		return element;
	}

	public static WebElement addButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("(//button[@type='submit'])[2]"));
		return element;
	}

	public static WebElement cancelButton(WebDriver driver) {
		element = getWebElement(driver, By.linkText("Cancel"));
		return element;
	}

}
