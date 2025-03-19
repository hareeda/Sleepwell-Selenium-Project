package com.ust.testcases.dropdown;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;

@Listeners(TestListener.class)
public class MyAccountDropDownTest extends Settings {

	// Page object of the necessary pages.
	HomePage hpage;

	// Verifying whether the My Account dropdown is clickable.
	@Test(priority = 1)
	public void verifyMyAccountDropdownClicking() {
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
		hpage.click(hpage.menuBar); // Clicking on menu icon.
		assertTrue(hpage.verifyDropDownClickable(hpage.myAccountDropdown)); // Asserting whether My Account Dropdown is
																			// clickable.
		hpage.click(hpage.myAccountDropdown); // Clicking on My Account Dropdown.
	}

	// Verifying the link text under the My Account Dropdown.
	@Test(priority = 2)
	public void verifyLinksUnderMyAccount() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("myaccount"), hpage.myAccountDropdown)); // Asserting
																											// the
																											// expected
																											// text with
																											// element
																											// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("myprofile"), hpage.myProfile)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("myorder"), hpage.myOrder)); // Asserting the
																								// expected text with
																								// element text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("myaddress"), hpage.myAddress)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("trackorder"), hpage.trackorder)); // Asserting the
																										// expected text
																										// with element
																										// text.
	}
}
