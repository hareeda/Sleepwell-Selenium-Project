package com.ust.testcases.mattresses;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.MattressShopByNeedPage;
import com.ust.popages.MattressShopByPricePage;
import com.ust.popages.MattressesShopBySizePage;
import com.ust.popages.MattressesShopByTechPage;
import com.ust.popages.MattressesShopByUserPage;

@Listeners(TestListener.class)
public class MattressFilterTest extends Settings {

	// Page objects of necessary pages.
	HomePage hpage;
	MattressShopByNeedPage msnpage;
	MattressesShopByUserPage msupage;
	MattressesShopByTechPage techpage;
	MattressShopByPricePage pricepage;
	MattressesShopBySizePage sizepage;

	// Verifying Mattress Shop By Need page.
	@Test(priority = 1)
	public void verifyNeedBased() {
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
		msnpage = hpage.clickshopByNeed(hpage.shopByNeed); // Clicking on Shop By Need.
		assertTrue(msnpage.verifyExpectedResult(msnpage.allCozyText, expresult_prop.getProperty("allcozysnug"))); // Asserting
																													// whether
																													// the
																													// expected
																													// text
																													// is
																													// the
																													// element
																													// text.
		hpage = navigateBack(); // Navigating back to HomePage and passing the driver to HomePage.
		navigateToTop(); // Navigating to Top.
	}

	// Verifying Mattress Shop By User page.
	@Test(priority = 2)
	public void verifyUserBased() {
		hpage.click(hpage.mattressesDropdown); // Clicking on Shop Mattress dropdown.
		msupage = hpage.clickshopByUserNeed(hpage.shopByUser); // Clicking on Shop By User.
		assertTrue(msupage.verifyExpectedResult(msupage.myselfText, expresult_prop.getProperty("foryou"))); // Asserting
																											// whether
																											// the
																											// expected
																											// text is
																											// the
																											// element
																											// text.
		hpage = navigateBack(); // Navigating back to HomePage and passing the driver to HomePage.
		navigateToTop(); // Navigating to Top.
	}

	// Verifying Mattress Shop By Tech page.
	@Test(priority = 3)
	public void verifyTechBased() {
		hpage.click(hpage.mattressesDropdown); // Clicking on Shop Mattress dropdown.
		techpage = hpage.clickshopByTech(hpage.shopByTech); // Clicking on Shop By Tech.
		assertTrue(techpage.verifyExpectedResult(techpage.proFitrestText, expresult_prop.getProperty("pronexa"))); // Asserting
																													// whether
																													// the
																													// expected
																													// text
																													// is
																													// the
																													// element
																													// text.
		hpage = navigateBack(); // Navigating back to HomePage and passing the driver to HomePage.
		navigateToTop(); // Navigating to Top.
	}

	// Verifying Mattress Shop By Price page.
	@Test(priority = 4)
	public void verifyPriceBased() {
		hpage.click(hpage.mattressesDropdown); // Clicking on Shop Mattress dropdown.
		pricepage = hpage.clickshopByPrice(hpage.shopByPrice); // Clicking on Shop By Price.
		assertTrue(pricepage.verifyExpectedResult(pricepage.priceText, expresult_prop.getProperty("price"))); // Asserting
																												// whether
																												// the
																												// expected
																												// text
																												// is
																												// the
																												// element
																												// text.
		hpage = navigateBack(); // Navigating back to HomePage and passing the driver to HomePage.
		navigateToTop(); // Navigating to Top.
	}

	// Verifying Mattress Shop By Size page.
	@Test(priority = 5)
	public void verifySizeBased() {
		hpage.click(hpage.mattressesDropdown); // Clicking on Shop Mattress dropdown.
		sizepage = hpage.clickshopBySize(hpage.shopBySize); // Clicking on Shop By Price.
		sizepage.click(sizepage.text); // Clicking on a product to check if the products have different sizes to choose
										// from.
		assertTrue(sizepage.verifyExpectedResult(sizepage.sizeText, expresult_prop.getProperty("size"))); // Asserting
																											// whether
																											// the
																											// expected
																											// text is
																											// the
																											// element
																											// text.
	}

}
