Selenium Cucumber BDD Framework with Allure Reporting
This project demonstrates automated tests using the Selenium Cucumber BDD Framework with Java, Maven, and JUnit. The project is designed for behavior-driven development (BDD), where scenarios are written in Gherkin syntax and executed using Cucumber. For reporting, Allure is used to generate detailed test execution reports.

Features
Selenium WebDriver for browser automation.
Cucumber for writing test scenarios in Gherkin.
JUnit for test execution.
Page Object Model(POM)- Page Factory pattern for maintaining test structure.
Allure Reports for detailed reporting.
Prerequisites
Java
Maven
IDE (Eclipse/IntelliJ)

Getting Started
1. Clone the Repository
Copy code
git clone https://github.com/Sanketsaraf/entrata_tests.git
Or download the project and add project to eclipse workspace

3. Install Dependencies
Use Maven to install the required dependencies:
Copy code
mvn clean install
or save pom.xml file

5. Running the Tests
To run the tests using Maven, simply run the following command:

Copy code
mvn verify
This will execute the Cucumber scenarios defined in the src/test/resources/features folder.

Project Structure
bash
Copy code
src
 ├── test
 │   └── java
 │       └── Pages         # Page Object classes
 ├── test
 │   └── java
 │       └── stepdefinitions     # Step Definitions for Cucumber
 │   └── resources
 │       └── features            # Cucumber Feature Files
 └── pom.xml                     # Maven build file with dependencies
Dependencies
This project uses the following Maven dependencies:

Selenium WebDriver
Cucumber-Java
Cucumber-JUnit
JUnit
Allure-Cucumber
These dependencies are defined in the pom.xml.

License
This project is licensed under the MIT License - see the LICENSE file for details.
