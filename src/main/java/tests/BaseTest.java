package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LoginPageObjects;
import pageObjects.NewEmployeePageObjects;
import utils.PropertiesFileReader;
import utils.WaitForAlert;
import utils.WaitForPageToLoad;

public class BaseTest {

	protected static WebDriver driver = null;
	protected Properties properties = PropertiesFileReader.getProperties();

	protected WaitForPageToLoad waiting = new WaitForPageToLoad();
	protected WebDriverWait wait;
	protected WaitForAlert waitingAlert = new WaitForAlert();

	protected void setUp() {

		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("chromeDriverLocation"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			driver = new ChromeDriver(options);
			wait = new WebDriverWait(driver, 20);
		}

	}

	protected void tearDown() {
		driver.quit();
	}

	protected void login() {
		// 1. Go to the login page
		driver.get(properties.getProperty("baseUrl"));
		waiting.waitForLoad(driver);

		// 2. Enter valid credentials in the Username and Password fields.
		LoginPageObjects.usernameTextField(driver).sendKeys(properties.getProperty("validUsername"));
		LoginPageObjects.passwordTextField(driver).sendKeys(properties.getProperty("validPassword"));

		// 3. Click on the Login button
		LoginPageObjects.loginButton(driver).click();
		waiting.waitForLoad(driver);
	}

	protected void fillEmployeeDetailsForm(String firstName, String lastName, String startDate, String email) {

		NewEmployeePageObjects.firstNameTextField(driver).clear();
		NewEmployeePageObjects.firstNameTextField(driver).sendKeys(firstName);
		NewEmployeePageObjects.lastNameTextField(driver).clear();
		NewEmployeePageObjects.lastNameTextField(driver).sendKeys(lastName);
		NewEmployeePageObjects.startDateTextField(driver).clear();
		NewEmployeePageObjects.startDateTextField(driver).sendKeys(startDate);
		NewEmployeePageObjects.emailTextField(driver).clear();
		NewEmployeePageObjects.emailTextField(driver).sendKeys(email);

	}

}
