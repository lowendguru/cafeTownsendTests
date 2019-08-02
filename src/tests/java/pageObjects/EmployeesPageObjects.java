package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeesPageObjects extends BasePageObject{

	private static WebElement element = null;

	public static WebElement greetingText(WebDriver driver) {
		element = getWebElement(driver, By.id("greetings"));
		return element;
	}

	public static WebElement logoutButton(WebDriver driver) {
		element = getWebElementClickable(driver, By.cssSelector("p.main-button"));
		return element;
	}

	public static WebElement createButton(WebDriver driver) {
		element = getWebElement(driver, By.id("bAdd"));
		return element;
	}
	
	public static WebElement editButton(WebDriver driver) {
		element = getWebElement(driver, By.id("bEdit"));
		return element;
	}
	
	public static WebElement deleteButton(WebDriver driver) {
		element = getWebElement(driver, By.id("bDelete"));
		return element;
	}

	public static ArrayList<WebElement> employeeList(WebDriver driver) {
		ArrayList<WebElement> list = new ArrayList<WebElement>();

		element = getWebElementClickable(driver, By.xpath("//ul[@id='employee-list']/li"));

		List<WebElement> allElements = driver.findElements(By.xpath("//ul[@id='employee-list']/li"));

		for (WebElement element : allElements) {
			list.add(element);
		}

		return list;
	}

}
