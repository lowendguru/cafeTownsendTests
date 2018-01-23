package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	private static WebElement element = null;

	public static WebElement usernameTextField(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@type='text']"));
		return element;
	}
	
	public static WebElement passwordTextField(WebDriver driver){
		element = driver.findElement(By.xpath("//input[@type='password']"));
		return element;
	}
	
	public static WebElement loginButton(WebDriver driver){
		element = driver.findElement(By.xpath("//button[@type='submit']"));
		return element;
	}
	
	public static WebElement invalidLoginErrorMessage(WebDriver driver){
		element = driver.findElement(By.xpath("//fieldset/p"));
		return element;
	}
	
	
}
