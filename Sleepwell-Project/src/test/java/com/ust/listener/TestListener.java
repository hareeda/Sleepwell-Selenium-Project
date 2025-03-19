package com.ust.listener;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.ust.base.Settings;
import com.ust.reportutil.ReportsManager;

public class TestListener implements ITestListener {

	WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	private LocalDateTime startTime;

	@Override
	public void onStart(ITestContext context) {
		try {
			String testNgFileName = context.getSuite().getXmlSuite().getFileName(); // Retrieving the filename of the
																					// TestNG suite XML file and store
																					// it in the variable
																					// "testNgFileName".
			String folderName = new File(testNgFileName).getName(); // Extract folder name from file path.
			extent = ReportsManager.createInstance(folderName); // Creating extent instance and passing the folder name
																// to Extent manager class.
		} catch (Exception e) {
			// Handle any exceptions that occur during ExtentReports initialization
			System.err.println("Error initializing ExtentReports: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to run when the test execution starts.
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName()); // Creating a test instance to log the results.
		startTime = LocalDateTime.now(); // Capture the start time
	}

	// Method to run when the test execution succeeds.
	@Override
	public void onTestSuccess(ITestResult result) {
		LocalDateTime endTime = LocalDateTime.now(); // Capture the end time
		long duration = java.time.Duration.between(startTime, endTime).toSeconds();
		test.info("Duration: " + duration + " s");
		test.log(Status.PASS, "Test case passed"); // Logging the test method passed in report.
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); // Generate a label with
																								// test method name and
																								// apply a green color
																								// scheme to it.
		String folderName = result.getInstanceName();// Storing the test class name to foldername.
		String testName = result.getName(); // Stroing the test method name to testName.
		String filepath = System.getProperty("user.dir") + "/ScreenShots/screenshots of " + folderName + "/" + testName
				+ "/" + testName + "_passed.png"; // Storing the path where screenshots of passed test cases will be
													// saved.
		try {
			Settings.takeScreenShot(filepath); // Calling the screenshot method on test success.
			test.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(filepath).build()); // Attaching the
																										// screenshot to
																										// the report.
		} catch (WebDriverException e) {
			// Handle WebDriverException if there is an issue with WebDriver interactions
			System.err.println("Error capturing or attaching screenshot: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to run when the test execution fails.
	@Override
	public void onTestFailure(ITestResult result) {
		LocalDateTime endTime = LocalDateTime.now(); // Capture the end time
		long duration = java.time.Duration.between(startTime, endTime).toSeconds();
		test.info("Duration: " + duration + " s");
		test.log(Status.FAIL, "Test case Failed"); // Logging the test method failed in report.
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED)); // Generate a label with
																							// test method name and
																							// apply a red color scheme
																							// to it.
		test.log(Status.FAIL, "Test case failed due to: " + result.getThrowable()); // Logging the reason for testcase
																					// failure.
		String folderName = result.getInstanceName(); // Storing the test class name to foldername.
		String testName = result.getName(); // Stroing the test method name to testName.
		String filepath = System.getProperty("user.dir") + "/ScreenShots/screenshots of " + folderName + "/" + testName
				+ "/" + testName + "_failed.png"; // Storing the path where screenshots of failed test cases will be
													// saved.
		try {
			Settings.takeScreenShot(filepath); // Calling the screenshot method on test failure.
			test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(filepath).build()); // Attaching the
																										// screenshot to
																										// the report.
		} catch (WebDriverException e) {
			// Handle WebDriverException if there is an issue with WebDriver interactions
			System.err.println("Error capturing or attaching screenshot: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to run when the test execution skips
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test case Skipped"); // Logging the test method skipped in report.
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.AMBER)); // Generate a label with
																								// test method name and
																								// apply a amber color
																								// scheme to it.
	}

	// Method to run when the test execution finishes
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
