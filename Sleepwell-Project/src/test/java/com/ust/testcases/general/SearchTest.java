package com.ust.testcases.general;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.Registration;
import com.ust.popages.SearchResultPage;

@Listeners(TestListener.class)
public class SearchTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	Registration rpage;
	SearchResultPage spage;

	// Verifying when no search key is entered and clicking the search button.
	@Test(priority = 1)
	public void verifyBlankSearch() {
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
		hpage.click(hpage.searchIcon); // Clicking on search icon.
		hpage.click(hpage.searchbtn); // Clicking on search button element.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base"))); // Asserting that clicking on search icon
																			// remains in the same page.
	}

	@Test(priority = 2)
	public void verifySearchResult() {
		spage = hpage.enterSearchText(hpage.search, obj_prop.getProperty("validkey")); // Entering "pillows" and
																						// pressing enter.
		explicitWait().until(driver -> {
			return spage.searchResultText1.getText().contains(expresult_prop.getProperty("pillows"))
					? spage.searchResultText1
					: null;
		}); // Waiting for the expected result to be visible.
		assertTrue(spage.verifySearchResult(spage.searchResultText1, expresult_prop.getProperty("pillows"))); // Asserting
																												// whether
																												// the
																												// search
																												// results
																												// text
																												// contains
																												// the
																												// search
																												// key.
	}

	@Test(priority = 3)
	public void verifyPartialMatchSearchResult() {
		spage.click(spage.close);
		spage.enterSearchText(spage.search, obj_prop.getProperty("invalidkey")); // Entering "aliya" and pressing enter.
		explicitWait().until(driver -> {
			return spage.searchResultText2.getText().contains(expresult_prop.getProperty("invalid"))
					? spage.searchResultText2
					: null;
		}); // Waiting for the expected result to be visible.
		assertTrue(spage.verifySearchResult(spage.searchResultText2, expresult_prop.getProperty("invalid"))); // Asserting
																												// whether
																												// the
																												// search
																												// results
																												// text
																												// contains
																												// the
																												// search
																												// key.
	}

}
