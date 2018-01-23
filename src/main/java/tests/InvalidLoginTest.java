package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;

public class InvalidLoginTest extends BaseTest {

	
	 @BeforeClass
	 public void setUp() {
		 super.setUp();
	 }
	
	 @AfterTest
	 public void tearDown(){
		 super.tearDown();
	 }
	 
	 @Test
	 public void invalidLogin() {
		 
		 //1. Go to the login page
		 driver.get(properties.getProperty("baseUrl"));
		 waiting.waitForLoad(driver);
		 
		 //2. Enter valid credentials in the Username and Password fields.		 
		 LoginPageObjects.usernameTextField(driver).sendKeys(properties.getProperty("invalidUsername"));
		 LoginPageObjects.passwordTextField(driver).sendKeys(properties.getProperty("invalidPassword"));
		 
		 //3. Click on the Login button
		 LoginPageObjects.loginButton(driver).click();
		 waiting.waitForLoad(driver);
		 
		 // Assert result
		 String errorMessage = LoginPageObjects.invalidLoginErrorMessage(driver).getText();
		 Assert.assertEquals(errorMessage, properties.getProperty("invalidLoginMessage"), "Invalid login error message not found.");
		 
	 }
}
