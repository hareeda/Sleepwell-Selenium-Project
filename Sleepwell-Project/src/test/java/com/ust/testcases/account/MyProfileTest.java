package com.ust.testcases.account;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.LoginPage;
import com.ust.popages.ProfilePage;

@Listeners(TestListener.class)
public class MyProfileTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	ProfilePage ppage;
	LoginPage lpage;

	// Verifying the my profile page by clicking my profile and logging in.
	@Test(priority = 1)
	public void verifyMyProfile() {
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
		hpage.click(hpage.menuBar); // Clicking on menubar icon.
		hpage.click(hpage.myAccountDropdown); // Clicking on My Account dropdown.
		lpage = hpage.clickMyProfileSignIn(hpage.myProfile); // Clicking My Profile option
		lpage.enterDetails(lpage.emailid, obj_prop.getProperty("loginemail")); // Entering email of existing user.
		lpage.enterDetails(lpage.passkey, obj_prop.getProperty("loginpassword")); // Entering password of existing user.
		ppage = lpage.signclick(lpage.signinbtn); // Clicking on Sign In button.
		explicitWait().until(ExpectedConditions.visibilityOf(ppage.emailText)); // Waiting for driver to find the email
																				// text element.
		assertTrue(ppage.emailText.getText().contains(obj_prop.getProperty("loginemail"))); // Asserting that the user's
																							// login is the element
																							// text.
		hpage = lpage.clickHome(lpage.home); // Clicking on home and passing the driver to HomePage.
	}

	// Verifying the my profile page by logging in and clicking my profile.
	@Test(priority = 2)
	public void verifyMyProfileLoggedIn() {
		hpage.click(hpage.menuBar); // Clicking on menu icon.
		hpage.click(hpage.myAccountDropdown); // Clicking on My Account Dropdown.
		ppage = hpage.clickMyProfile(hpage.myProfile); // Clicking on My Profile element.
		explicitWait().until(ExpectedConditions.visibilityOf(ppage.emailText)); // Waiting for driver to find the email
																				// text element.
		assertTrue(ppage.emailText.getText().contains(obj_prop.getProperty("loginemail"))); // Asserting that the user's
																							// login is the element
																							// text.
	}

}
