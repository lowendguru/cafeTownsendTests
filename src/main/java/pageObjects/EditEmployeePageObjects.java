package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditEmployeePageObjects {
	
	private static WebElement element = null;

	public static WebElement updateButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}
	
	public static WebElement deleteButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//fieldset/div/p")); 
		return element;
	}
}
