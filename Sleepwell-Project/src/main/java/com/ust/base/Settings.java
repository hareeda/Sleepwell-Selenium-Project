package com.ust.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ust.popages.HomePage;
import com.ust.reusable.ReusableMethods;

public class Settings {

	// Declaring the necessary objects.
	public static WebDriver driver;
	protected static ReusableMethods method;
	static HomePage hpage;

	// Object for object property file
	public static Properties obj_prop = new Properties();
	public static String obj_path = System.getProperty("user.dir") + Path.object_path;

	// Object for expected results property file
	public static Properties expresult_prop = new Properties();
	public static String expresult_path = System.getProperty("user.dir") + Path.expectedresults_path;

	// Method to set the browser type and load the properties before the test class
	// execution.
	@Parameters({ "browser" })
	@BeforeClass
	public static WebDriver setDriver(String browser) {

		// try catch block loading the object properties file.
		try (FileInputStream file1 = new FileInputStream(obj_path)) {
			obj_prop.load(file1);
		} catch (FileNotFoundException e) {
			System.err.println("Object properties file not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

		// try catch block loading the expresults properties file.
		try (FileInputStream file2 = new FileInputStream(expresult_path)) {
			expresult_prop.load(file2);
		} catch (FileNotFoundException e) {
			System.err.println("Expected results properties file not found: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}

		// Setting the browser.
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browser.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("unexpectedAlertBehaviour", "accept");
			options.addArguments("--disable-notifications");
			driver = new EdgeDriver(options);
		}
		return driver;
	}

	// Method to initialize the test environment and prepare for test execution
	public static HomePage setUp() {
		method = new ReusableMethods(driver);
		method.getURL(obj_prop.getProperty("base"));
		implicitWait();
		hpage = new HomePage(driver);
		try {
			Thread.sleep(9000); 
		} catch (InterruptedException e) {
			// Handle InterruptedException if the thread is interrupted while sleeping
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
		return hpage;
	}

	// Method to take screenshots of the testcases.
	public static void takeScreenShot(String filepath) {
		try {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// Handle IOException related to file operations
			System.err.println("Error copying screenshot file: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error taking screenshot: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to get the timestamp.
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}

	// Method to put sleep wherever needed.
	public static void waits(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			// Handle InterruptedException if the thread is interrupted while sleeping
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to put explicit wait wherever needed.
	public static WebDriverWait explicitWait() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			return wait;
		} catch (Exception e) {
			// Handle any unexpected exceptions that might occur during WebDriverWait
			// creation
			System.err.println("Error creating WebDriverWait: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
			return null; // Returning null as there was an unexpected error
		}
	}

	// Method to handle alerts.
	public static Alert alerts() {
		try {
			return driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			// Handle NoAlertPresentException if there is no alert present
			System.err.println("No alert present.");
			return null; // Returning null as there is no alert present
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error switching to alert.");
			e.printStackTrace(); // Print stack trace for debugging purposes
			return null; // Returning null as there was an unexpected error
		}
	}

	// Method to put implicit wait.
	public static Timeouts implicitWait() {
		try {
			return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		} catch (TimeoutException e) {
			// Handle TimeoutException if the implicit wait timeout is exceeded
			System.err.println("Timeout setting implicit wait: " + e.getMessage());
			return null; // Returning null as there was an unexpected error
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error setting implicit wait: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
			return null; // Returning null as there was an unexpected error
		}
	}

	// Method to navigate to the previous page in the browser history.
	public static HomePage navigateBack() {
		try {
			driver.navigate().back();
			return new HomePage(driver);
		} catch (NoSuchWindowException e) {
			// Handle NoSuchWindowException if the browser window is closed or not available
			System.err.println("Error navigating back: " + e.getMessage());
			return null; // Returning null as there was an unexpected error
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error navigating back: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
			return null; // Returning null as there was an unexpected error
		}
	}

	// Method to navigate to the top of a page.
	public static void navigateToTop() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0);");
		} catch (WebDriverException e) {
			// Handle WebDriverException if there is an issue with WebDriver interactions
			System.err.println("Error scrolling to top of page: " + e.getMessage());
		} catch (Exception e) {
			// Handle any other unexpected exceptions
			System.err.println("Unexpected error scrolling to top of page: " + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging purposes
		}
	}

	// Method to run after the test class execution.
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
