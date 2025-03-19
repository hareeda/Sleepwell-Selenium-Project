package com.ust.testcases.user;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.LoginPage;
import com.ust.popages.Registration;

@Listeners(TestListener.class)
public class RegistrationTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	LoginPage lpage;
	Registration rpage;

	// Verifying navigation to RegistrationPage.
	@Test(priority = 1)
	public void verifyNavigateToRegistrationPage() {
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
		lpage = hpage.clickLogin(hpage.signInIncon); // Clicking on user icon and passing the driver to LoginPage.
		rpage = lpage.clickRegister(lpage.registerLink); // Clicking on Create an account link and passing the driver to
															// RegistrationPage.
		assertTrue(rpage.verifyCurrentUrl(expresult_prop.getProperty("registration"))); // Asserting navigation to
																						// RegistrationPage.
	}

	// Verifying whether the register button is disabled if no details is entered.
	@Test(priority = 2)
	public void verifyBlankFormSubmission() {
		assertTrue(rpage.checkBtnDisabled(rpage.ck));// Asserting whether the register button is disabled if no details
														// is entered.
	}

	// Verifying after Registration form is submitted the register button is
	// disabled.
	@Test(priority = 3, enabled = false)
	public void verifyFormSubmission() {
		rpage.enterDetails(obj_prop.getProperty("fistname"), rpage.firstname); // Entering the firstname to firstname
																				// element.
		rpage.enterDetails(obj_prop.getProperty("lastname"), rpage.lasttname); // Entering the lastname to lastname
																				// element.
		rpage.enterDetails(obj_prop.getProperty("email"), rpage.email); // Entering the email to email element.
		rpage.enterDetails(obj_prop.getProperty("mobile"), rpage.mobile); // Entering the mobile to mobile element.
		rpage.enterDetails(obj_prop.getProperty("date"), rpage.date); // Entering the date to date element.
		rpage.enterDetails(obj_prop.getProperty("password"), rpage.password); // Entering the password to password
																				// element.
		rpage.click(rpage.ck); // Clicking the register button.
		assertTrue(rpage.checkBtnDisabled(rpage.ck)); // Asserting that the button is disabled after submission.
	}
}
