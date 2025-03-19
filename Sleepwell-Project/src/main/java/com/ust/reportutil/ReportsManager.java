package com.ust.reportutil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ust.base.Settings;

public class ReportsManager {

	public static ExtentReports report;
	public static ExtentSparkReporter sparkReport;

	// Method to create an instance of ExtentReports with desired configuration.
	public static ExtentReports createInstance(String folderName) {

		String repName = "TestReport-" + Settings.getTimeStamp() + ".html"; // Constructing a unique report name using
																			// current timestamp
		sparkReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//" + folderName + " Reports//" + repName); // Creating an
																										// ExtentSparkReporter
																										// instance with
																										// the file path
																										// where the
																										// report will
																										// be generated

		// Configuring the spark reporter with title, name of report, theme and time stamp.
		sparkReport.config().setDocumentTitle("Sleepwell Mattress Automation");
		sparkReport.config().setReportName("Test Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");

		report = new ExtentReports();

		// Attaching the spark reporter to report instance.
		report.attachReporter(sparkReport);

		// Setting the report instance with necessary system information.
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Host Name", "Locathost");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Team Member", "Aliya B");
		report.setSystemInfo("Team Member", "Hareeda M S");
		report.setSystemInfo("Team Member", "S Nikhil Kumar");
		return report;
	}

}
