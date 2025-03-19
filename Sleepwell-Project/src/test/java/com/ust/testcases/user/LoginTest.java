package com.ust.testcases.user;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Path;
import com.ust.base.Settings;
import com.ust.excelutil.ExcelReader;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.LoginPage;
import com.ust.popages.ProfilePage;

@Listeners(TestListener.class)
public class LoginTest extends Settings {

	// Page objects of necessary pages.
	LoginPage lpage;
	HomePage hpage;
	ProfilePage ppage;

	// Verifying navigation to LoginPage.
	@Test(priority = 1)
	public void verifyNavigateToLoginPage() {
		hpage = setUp(); // Passing the driver to HomePage object after opening the site.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base")), "Home Page was not loaded properly!"); // Asserting
																												// that
																												// the
																												// site
																												// has
																												// loaded
																												// properly
																												// or
																												// not.
		lpage = hpage.clickLogin(hpage.signInIncon); // Clicking on user icon.
		assertTrue(lpage.verifyCurrentUrl(expresult_prop.getProperty("login"))); // Asserting navigation to login page.
	}

	// Verifying positive login using data provider.
	@Test(dataProvider = "getpositivedata", priority = 1)
	public void verifyPositiveLogin(String ename, String pass)// test case for positive login scenario
	{
		lpage.enterDetails(lpage.emailid, ename); // Entering email to emailid element.
		lpage.enterDetails(lpage.passkey, pass); // Entering password to passkey element.
		ppage = lpage.signclick(lpage.signinbtn); // Clicking on Signin button and passing the driver to profile page.
		assertTrue(ppage.emailText.getText().contains(ename)); // Asserting whether the email in my profile page is the
																// sent ename.
		ppage.click(ppage.logout); // Clicking on logout.
		lpage = ppage.clickYes(ppage.yes); // Clicking on yes and passing the driver to LoginPage.
	}

	// Verifying negative login using data provider.
	@Test(dataProvider = "getnegativedata", priority = 2)
	public void verifyNegativeLogin(String ename, String pass) {
		lpage.enterDetails(lpage.emailid, ename); // Entering email to emailid element.
		lpage.enterDetails(lpage.passkey, pass); // Entering password to passkey element.
		lpage.click(lpage.signinbtn); // Clicking on Signin button.
		explicitWait().until(ExpectedConditions.visibilityOf(lpage.errorText)); // Waiting for error text to be visible.
		assertTrue(lpage.errorText.getText().equals(expresult_prop.getProperty("errorlogin"))); // Asserting the error
																								// text with element
																								// text.
	}

	// Verifying continue as guest link.
	@Test(priority = 4)
	public void guestLogin() {
		hpage = lpage.clickGuestLogin(lpage.guestLogin); // Clicking on continue as guest link and passing to HomePage.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base"))); // Asserting that user reaches the home page.
	}

	// Data Provider method for getting positive data from excel sheet.
	@DataProvider
	public String[][] getpositivedata() throws Exception {
		File file = new File(System.getProperty("user.dir") + Path.excel_path);// Creating a file for the exce file.
		String sheetname = "Positive";// Storing the name of sheet in sheetname.
		return ExcelReader.arrayData(file, sheetname);// Returning the 2D array from Excel Reader class.
	}

	// Data Provider method for getting negative data from excel sheet.
	@DataProvider
	public String[][] getnegativedata() throws Exception {
		File file = new File(System.getProperty("user.dir") + Path.excel_path);// Creating a file for the exce file.
		String sheetname = "Negative";// Storing the name of sheet in sheetname.
		return ExcelReader.arrayData(file, sheetname);// Returning the 2D array from Excel Reader class.
	}
}
