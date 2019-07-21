# CafeTownsend Tests

# Documents

The following documents can be found in the /docs folder.
* Test Plan - cafetownsend.docx: Test approach and definitions.
* Test Cases - cafetownsend.xlsx: Includes a sheet with a suite of Test Cases for manual execution called "Functional Test Cases". Also has a sheet called "Test Summary" with summary data about test results and feature coverage. Finally, this file has a sheet called "Defects" with the description of issues found during test execution. Video and picture files with evidence of the defects can be found in the /docs/evidence folder.


# Automated Test Suite

These tests are written in Java using 'Selenium' and 'testNG' as a testing framework. 
The test suite contains test cases which represent a small portion of the full manual test suite. These test the basic functionality of the 'CafeTownsend' app.
The tests were designed to be executed on Google Chrome as it is the browser with the biggest market share at the time of these tests.


### CafeTownsend functional Tests

The automated test suite has six test cases:

- ValidLoginTest: This goes through the login process with valid credentials.

- InvalidLoginTest: This enters invalid credentials so that the login process cannot be completed and an error message is displayed to the user.

- LogoutTest: This performs a valid login and then a logout verifying that the session has ended. 

- AddEmployeeTest: This performs a valid login and then creates a new employee. The test verifies if the new employee is present in the employees list. 

- EditEmployeeTest: This performs a valid login and then edits an existing employee. 

- DeleteEmployeeTest:  This test logs in a then deletes an existing employee. It then verifies that the deleted employee is no longer present in the employees list.


## Preconditions

The requirements to run this automated tests are:
- Maven
- Java 1.8
- Google Chrome

### Maven project

This is a maven project. All dependencies are managed automatically and is OS agnostic.

The test suite can be executed via command line. 
```
    $mvn clean test
```
This will run all the tests and results will be available in the /test-output/${timestamp} folder. Every execution creates a new /${timestamp} subfolder. This way all previous executions are saved for future reference.



### Structure
#### Page Object classes
The classes in the "pageObjects" package provide access to the WebElements necessary to interact with all the pages in the web app. This abstraction layer allows for easy code maintenance in the case of changes in the UI. 
#### Test classes
The test classes located under the "tests" package hold the test cases that verify the expected behavior of the application. All tests extend the BaseTest class, thus allowing its methods to be reusable and maintainable.
#### Utils classes
The classes under the "utils" package are auxiliary classes with reusable code.
#### Properties file
The "datafile.properties" file has several parameters used during test execution. This prevents values from being hardcoded in the test classes thus allowing for easy code maintenance.


