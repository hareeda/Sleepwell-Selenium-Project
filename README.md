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

Key Components:
Base Package (com.ust.base) – Contains core framework setup, including configurations and property loaders.
Utility Package (com.ust.executil) – Houses utility classes such as ExcelReader for handling test data.
POM Classes (com.ust.popages) – Separate classes for each web page, encapsulating locators and methods.
Reporting (com.ust.reportutil) – Manages test execution reports with ReportsManager.
Reusable Components (com.ust.reusable) – Contains reusable functions to avoid code duplication.
Test Cases (com.ust.testcases) – Implements automated test scripts using TestNG.
Listeners (com.ust.listener) – Handles TestNG listeners for reporting and logging.
Resource Files (resources) – Stores properties files for element locators and Excel files for data-driven testing.
Maven & TestNG (pom.xml, testng.xml) – Maven for dependency management and TestNG for test execution.

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

