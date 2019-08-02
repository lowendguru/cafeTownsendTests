package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects extends BasePageObject {

	private static WebElement element = null;

	public static WebElement usernameTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//input[@type='text']"));
		return element;
	}

	public static WebElement passwordTextField(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//input[@type='password']"));
		return element;
	}

	public static WebElement loginButton(WebDriver driver) {
		element = getWebElement(driver, By.xpath("//button[@type='submit']"));
		return element;
	}

	public static WebElement invalidLoginErrorMessage(WebDriver driver) {
		element = getWebElementClickable(driver, By.cssSelector("p.error-message.ng-binding"));
		return element;
	}

}
