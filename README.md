Sleepwell Selenium Project
A Selenium-based automated testing framework that follows the Page Object Model (POM) with Page Factory and is built using a hybrid framework to test the functionality of the Sleepwell e-commerce website.

Project Features
Page Object Model (POM) with Page Factory for better code maintainability.
Hybrid Framework combining Data-Driven and Keyword-Driven approaches.
Reusable Utility Classes for common operations.
TestNG Integration for structured test execution.
Maven Project Setup for dependency management.
Excel-based Data-Driven Testing using Apache POI.
Logging and Reporting using Extent Reports.

Project Structure
Sleepwell-Project
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.ust.base               # Core framework setup
│   │   │   │   ├── Path.java
│   │   │   │   ├── PropertyLoader.java
│   │   │   │   ├── Settings.java
│   │   │   ├── com.ust.executil           # Utility classes
│   │   │   │   ├── ExcelReader.java
│   │   │   ├── com.ust.popages            # Page Object Model (POM) classes
│   │   │   ├── com.ust.reportutil         # Reporting utilities
│   │   │   │   ├── ReportsManager.java
│   │   │   ├── com.ust.reusable           # Reusable methods
│   │   │   │   ├── ReusableMethods.java
│   │   ├── resources
│   │   │   ├── object.properties          # Properties file for element locators
│   │   │   ├── dataset.xlsx               # Test data for data-driven testing
│   ├── test
│   │   ├── java
│   │   │   ├── com.ust.testcases          # Test case implementations
│   │   │   ├── com.ust.listener           # TestNG Listeners
│   │   │   │   ├── TestListener.java
│   │   ├── resources
│   │   │   ├── test-output                # Test reports
│   ├── pom.xml                            # Maven configuration file
│   ├── testng.xml                         # TestNG suite configuration
│   ├── README.md                          # Project documentation

Setup Instructions
Prerequisites
Install Java 8+
Install Maven
Install Eclipse/IntelliJ
Install Selenium WebDriver
Install TestNG
Configure Git

Clone Repository
git clone https://github.com/hareeda/Sleepwell-Selenium-Project.git
cd Sleepwell-Selenium-Project

Install Dependencies
mvn clean install

Run Tests
mvn test
OR
testng.xml

Technologies Used
Selenium WebDriver
Java
TestNG
Maven
Page Object Model (POM) with Page Factory
Apache POI for Excel Data-Driven Testing
Extent Reports for Reporting
GitHub for Version Control
Contributors
👤 Hareeda M S
📧 hareeda33@gmail.com
🔗 https://linkedin.com/in/hareeda-suresh

