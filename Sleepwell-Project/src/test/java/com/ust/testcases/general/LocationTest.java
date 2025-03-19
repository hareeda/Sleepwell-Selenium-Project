package com.ust.testcases.general;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.MattressComparisonPage;

@Listeners(TestListener.class)
public class LocationTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	MattressComparisonPage mcompage;

	// Verifying entering the pincode to get local pricing of that place.
	@Test(priority = 1)
	public void verifyEnteringPincodeandSearching() {
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
		hpage.click(hpage.location); // Clicking on location box element.
		hpage.enterPincode("678642", hpage.pincode); // Entering pincode to pincode box element.
		hpage.click(hpage.submit); // Clicking on submit button icon
		explicitWait().until(driver -> {
            return hpage.location.getText().contains("PALAKKAD") ? hpage.location : null;
        }); // Waiting for loaction box to have PALAKKAD value.
		assertTrue(hpage.verifyExpectedText(hpage.location, "PALAKKAD")); // Asserting whether the loaction box displays the expected location.
	}
	
	// Verifying selecting city to get local pricing of that place.
	@Test(priority = 2)
	public void verifySelectingCityandSearching() {
		hpage.click(hpage.location); // Clicking on location box element.
		hpage.selectCityFromDropDown(hpage.citydropdown, "4693"); // Selecting thiruvanthapuram using its value in the site.
		hpage.click(hpage.submit); // Clicking on the submit button element.	
		explicitWait().until(driver -> {
            return hpage.location.getText().contains("THIRUVANANTHAPURAM") ? hpage.location : null;
        }); // Waiting for loaction box to have THIRUVANANTHAPURAM value.
		assertTrue(hpage.verifyExpectedText(hpage.location, "THIRUVANANTHAPURAM"));
	}
	
}
