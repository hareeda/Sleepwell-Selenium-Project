package com.ust.testcases.dropdown;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;

@Listeners(TestListener.class)
public class MattressDropDownTest extends Settings {

	// Page object of the necessary pages.
	HomePage hpage;

	// Verifying Shop Mattress Dropdown clicking.
	@Test(priority = 1)
	public void verifyMattressDropdownClicking() {
		hpage = setUp(); // Passing the driver to HomePage object after opening the site.
		assertTrue(hpage.verifyCurrentUrl(obj_prop.getProperty("base")), "Home Page was not loaded properly"); // Asserting
																												// that
																												// the
																												// site
																												// has
																												// loaded
																												// properly
																												// or
																												// not.
		assertTrue(hpage.verifyDropDownClickable(hpage.mattressesDropdown)); // Asserting if Shop Mattress Dropdown
																				// element is clickable.
		hpage.click(hpage.mattressesDropdown); // Clicking on Mattress Dropdown element.
	}

	// Verifying the link text under Shop By Need.
	@Test(priority = 2)
	public void verifyLinksUnderShopByNeed() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("Shopbyneed"), hpage.shopByNeed)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("cozysnug"), hpage.cozysnug)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(
				hpage.verifyLinkText(expresult_prop.getProperty("nopartnerdisturbance"), hpage.nopartnerdisturbance)); // Asserting
																														// the
																														// expected
																														// text
																														// with
																														// element
																														// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("multiactivity"), hpage.multiactivity)); // Asserting
																											// the
																											// expected
																											// text with
																											// element
																											// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("backsupport"), hpage.backsupport)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("reversible"), hpage.reversible)); // Asserting the
																										// expected text
																										// with element
																										// text.
	}

	// Verifying the link text under Shop By User.
	@Test(priority = 3)
	public void verifyLinksUnderShopByUser() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("Shopbyuser"), hpage.shopByUser)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("indvidual"), hpage.indvidual)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("couplewithkids"), hpage.couplewithkids)); // Asserting
																												// the
																												// expected
																												// text
																												// with
																												// element
																												// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("couples"), hpage.couples)); // Asserting the
																								// expected text with
																								// element text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("guests"), hpage.guests)); // Asserting the expected
																								// text with element
																								// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("elders"), hpage.elders)); // Asserting the expected
																								// text with element
																								// text.
	}

	// Verifying the link text under Shop By Tech.
	@Test(priority = 4)
	public void verifyLinksUnderShopByTech() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("Shopbytech"), hpage.shopByTech)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("pronexas"), hpage.pronexa)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("profitrest"), hpage.profitrest)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("prolatex"), hpage.prolatex)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("spintech"), hpage.spintech)); // Asserting the
																									// expected text
																									// with element
																									// text.
	}

	// Verifying the link text under Shop By Price.
	@Test(priority = 5)
	public void verifyMattressDropdownShopByPrice() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("Shopbyprice"), hpage.shopByPrice)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("above4k"), hpage.above4k)); // Asserting the
																								// expected text with
																								// element text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("above15k"), hpage.above15k)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("above25k"), hpage.above25k)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("above35k"), hpage.above35k)); // Asserting the
																									// expected text
																									// with element
																									// text.
	}

	// Verifying the link text under Shop By Size.
	@Test(priority = 6)
	public void verifyMattressDropdownShopBySize() {
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("Shopbysize"), hpage.shopBySize)); // Asserting the
																										// expected text
																										// with element
																										// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("kingsize"), hpage.kingsize)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("queensize"), hpage.queensize)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("singlebed"), hpage.singlebed)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("doublebed"), hpage.doublebed)); // Asserting the
																									// expected text
																									// with element
																									// text.
		assertTrue(hpage.verifyLinkText(expresult_prop.getProperty("custom"), hpage.custom)); // Asserting the expected
																								// text with element
																								// text.
	}
}
