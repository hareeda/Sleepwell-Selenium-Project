package com.ust.testcases.navigation;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.base.Settings;
import com.ust.listener.TestListener;
import com.ust.popages.FaqPage;
import com.ust.popages.HomePage;

@Listeners(TestListener.class)
public class FaqTest extends Settings {

	FaqPage fpage;
	HomePage hpage;

	// Verifying navigation to FaqPage.
	@Test(priority = 1)
	public void verifyNavigateToFAQ() {
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
		hpage.click(hpage.menuBar); // Clicking on menu bar.
		method.scrolltoElement(hpage.faqs); // Scrolling to the faq option element in menubar.
		fpage = hpage.clickFAQS(hpage.faqs); // Passing the dirver to FaqPage after clicking on faq option element.
		assertTrue(fpage.verifyCurrentUrl(expresult_prop.getProperty("faq"))); // Asserting navigation to FaqPage.
	}

	// Verifying the Faq welcome text.
	@Test(priority = 2)
	public void verifyFaqWelcomeText() {
		assertTrue(fpage.verifyExpectedString(fpage.faqwelcometext,expresult_prop.getProperty("faqwelcome")));// Asserting Faq welcome text.
	}
}
