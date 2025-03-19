package com.ust.testcases.navigation;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.HomePage;
import com.ust.popages.PillowsPage;

@Listeners(TestListener.class)
public class PillowsTest extends Settings {

	// Page objects of necessary pages.
	PillowsPage pillpage;
	HomePage hpage;
	Settings set = new Settings();

	 // Verifying navigation to PillowsPage
	@Test(priority = 1)
	public void verifyNavigateToPillowsPage() {
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
		pillpage = hpage.clickPillows(hpage.pillow); // Clicking on the Shop Pillows element and passing the driver to PillowsPage.
		assertTrue(pillpage.verifyCurrentUrl(expresult_prop.getProperty("pillows"))); // Asserting the navigation to PillowsPage.
	}

	// Verifying Fibre Pillows filter button.
	@Test(priority = 2)
	public void verifyFibrePillowsButton() {
		pillpage.click(pillpage.fibrepillows); // Clicking on Fibre Pillows button.
		assertTrue(pillpage.verifyExpectedResult(pillpage.noresults, expresult_prop.getProperty("fibre"))); // Asserting the no results text. 
		pillpage.click(pillpage.clearfilter); // Clearing all the filters
	}
	
	// Verifying Regular Tech Pillows filter button.
	@Test(priority = 3)
	public void verifyRegularTechPillowsButton() {
		pillpage.click(pillpage.regualrtechpillows); // Clicking on Regular Tech Pillows button.
		for(WebElement pillow: pillpage.getListElements()) {
			assertTrue(pillpage.verifyExpectedResult(pillow, expresult_prop.getProperty("regular"))); // Asserting the products after clicking Regular Tech Pillows button contains Regular Tech. 
		}
		pillpage.click(pillpage.regualrtechpillows); // Clicking on Regular Tech Pillows button.
		pillpage.click(pillpage.clearfilter); // Clearing all the filters
	}
	
	// Verifying Contour Tech Pillows filter button.
	@Test(priority = 4)
	public void verifyContourTechPillowsButton() {
		pillpage.click(pillpage.contourtechpillows); // Clicking on Contour Tech Pillows button.
		for (WebElement pillow : pillpage.getListElements()) {
		    assertTrue(pillpage.verifyExpectedResult(pillow, expresult_prop.getProperty("curves")));// Asserting the products after clicking Contour Tech Pillows button contains Curves. 
		}
		pillpage.click(pillpage.contourtechpillows); // Clicking on Contour Tech Pillows button.
		pillpage.click(pillpage.clearfilter); // Clearing all the filters
	}
}
