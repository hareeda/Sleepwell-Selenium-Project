package com.ust.testcases.mattresses;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.MattressComparisonPage;

@Listeners(TestListener.class)
public class MattressCompareTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	MattressComparisonPage mcompage;

	// Verifying navigation to MattressComparisonPage.
	@Test(priority = 1)
	public void navigateToMattressComparisonPage() {
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
		hpage.click(hpage.mattressesDropdown); // Clicking on Shop Mattress dropdown.
		mcompage = hpage.clickMattressCompare(hpage.compareMattresses); // Clicking on Compare Mattress button element.
		assertTrue(mcompage.verifyCurrentUrl(expresult_prop.getProperty("comparison"))); // Asserting navigation to
																							// comparison page.
	}

	@Test(priority = 2)
	public void verifySelectingMattresses1() {
		method.scrolltoElement(mcompage.element); // Scrolling to the comparing mattress products.
		mcompage.click(mcompage.firstDrpdwn); // Clicking on the first dropdown.
		mcompage.click(mcompage.DualMattress1); // Selecting Dual Mattress
		mcompage.click(mcompage.secondDrpdwn); // Clicking on the second dropdown.
		mcompage.click(mcompage.Utsav); // Selecting UTSAV 1.0 Mattress
		explicitWait().until(driver -> {
			return mcompage.pdt2Text.getText().contains(expresult_prop.getProperty("mattress2")) ? mcompage.pdt2Text
					: null;
		}); // Waiting for UTSAV 1.0 Mattress text to be present in the compare tab.
		assertEquals(expresult_prop.getProperty("mattress1"), mcompage.pdt1Text.getText()); // Asserting the compare tab
																							// element with the expected
																							// text.
		assertEquals(expresult_prop.getProperty("mattress2"), mcompage.pdt2Text.getText()); // Asserting the compare tab
																							// element with the expected
																							// text.
	}

	@Test(priority = 2)
	public void verifySelectingMattresses2() {
		method.scrolltoElement(mcompage.element);
		mcompage.click(mcompage.firstDrpdwn); // Clicking on the first dropdown.
		mcompage.click(mcompage.firstDrpdwn); // Clicking on the first dropdown.
		mcompage.click(mcompage.Utsavcomfort2); // Selecting Utsav Comfort Classic.
		mcompage.click(mcompage.secondDrpdwn); // Clicking on the second dropdown.
		mcompage.click(mcompage.secondDrpdwn); // Clicking on the second dropdown.
		mcompage.click(mcompage.StraightBack2); // Selecting Straight Back.
		explicitWait().until(driver -> {
			return mcompage.pdt2Text.getText().contains(expresult_prop.getProperty("mattress4")) ? mcompage.pdt2Text
					: null;
		}); // Waiting for Straight Back text to be present in the compare tab.
		assertEquals(expresult_prop.getProperty("utsav"), mcompage.pdt1Text.getText()); // Asserting the compare tab
																						// element with the expected
																						// text.
		assertEquals(expresult_prop.getProperty("mattress4"), mcompage.pdt2Text.getText()); // Asserting the compare tab
																							// element with the expected
																							// text.
	}
}
