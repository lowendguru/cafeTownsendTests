package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditEmployeePageObjects extends BasePageObject{
	
	private static WebElement element = null;

	public static WebElement updateButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//button[@type='submit']"));
		return element;
	}
	
	public static WebElement deleteButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//p[@ng-click='deleteEmployee()']")); 
		return element;
	}
}
